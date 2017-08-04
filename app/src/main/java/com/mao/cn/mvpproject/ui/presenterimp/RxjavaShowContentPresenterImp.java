// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 08/04/2017 16:53 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mvpproject.ui.presenterimp;

import com.google.gson.JsonSyntaxException;
import com.mao.cn.mvpproject.R;
import com.mao.cn.mvpproject.interactors.RxjavaShowContentInteractor;
import com.mao.cn.mvpproject.model.Movie;
import com.mao.cn.mvpproject.ui.commons.BasePresenterImp;
import com.mao.cn.mvpproject.ui.features.IRxjavaShowContent;
import com.mao.cn.mvpproject.ui.presenter.RxjavaShowContentPresenter;
import com.mao.cn.mvpproject.utils.network.NetworkUtils;
import com.mao.cn.mvpproject.utils.tools.GsonU;
import com.mao.cn.mvpproject.utils.tools.ListU;
import com.mao.cn.mvpproject.utils.tools.StringU;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Func1;
import rx.subscriptions.CompositeSubscription;

/**
 * DESC   :
 * AUTHOR : Xabad
 */
public class RxjavaShowContentPresenterImp extends BasePresenterImp implements RxjavaShowContentPresenter {
    RxjavaShowContentInteractor interactor;
    IRxjavaShowContent viewInterface;
    private CompositeSubscription subscriptions;

    public RxjavaShowContentPresenterImp(IRxjavaShowContent viewInterface, RxjavaShowContentInteractor rxjavaShowContentInteractor) {
        super();
        this.viewInterface = viewInterface;
        this.interactor = rxjavaShowContentInteractor;
        this.subscriptions = new CompositeSubscription();
    }

    @Override
    public void getMovieTop(int start, int count) {
        if (!NetworkUtils.isConnected(context)) {
            viewInterface.onTip(context.getString(R.string.no_connect_net));
            return;
        }
        viewInterface.showLoadingDialog("");
        Subscription subscribe = interactor.getMovieTop(start, count).flatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return Observable.just(s);
            }
        }).compose(applyIoSchedulers()).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                viewInterface.hideLoadingDialog();
            }

            @Override
            public void onError(Throwable e) {
                viewInterface.hideLoadingDialog();
                viewInterface.interError(e);
                viewInterface.showTopMovie(null, "");
            }

            @Override
            public void onNext(String s) {
                Movie convert = null;
                try {
                    convert = GsonU.convert(s, Movie.class);
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
                if (convert != null && StringU.isNotEmpty(convert.getTitle()) && ListU.notEmpty(convert.getSubjects())) {
                    viewInterface.showTopMovie(convert.getSubjects(), convert.getTitle());
                } else {
                    viewInterface.showTopMovie(null, "");
                }

            }
        });

        if (subscriptions != null){
            subscriptions.add(subscribe);
        }
    }


    @Override
    public void onDestroySubscribe() {
        if (subscriptions != null) {
            subscriptions.unsubscribe();
        }
    }
}
