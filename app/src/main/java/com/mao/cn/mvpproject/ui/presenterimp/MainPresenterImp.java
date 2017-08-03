// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 06/09/2017 11:17 上午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mvpproject.ui.presenterimp;

import com.mao.cn.mvpproject.R;
import com.mao.cn.mvpproject.callBack.StringCallback;
import com.mao.cn.mvpproject.converter.RetrofitError;
import com.mao.cn.mvpproject.interactors.MainInteractor;
import com.mao.cn.mvpproject.ui.commons.BasePresenterImp;
import com.mao.cn.mvpproject.ui.features.IMain;
import com.mao.cn.mvpproject.ui.presenter.MainPresenter;
import com.mao.cn.mvpproject.utils.network.NetworkUtils;

/**
* DESC   :
* AUTHOR : Xabad
*/
public class MainPresenterImp extends BasePresenterImp implements MainPresenter {
    MainInteractor interactor;
    IMain viewInterface;
    public MainPresenterImp(IMain viewInterface,MainInteractor mainInteractor) {
        super();
        this.viewInterface = viewInterface;
        this.interactor = mainInteractor;
    }


    @Override
    public void getMovieTop(int start, int count) {

        if (!NetworkUtils.isConnected(context)){
            viewInterface.onTip(context.getString(R.string.no_connect_net));
            return;
        }
        interactor.getMovieTop(start, count, new StringCallback() {
            @Override
            public void success(String var1) {

            }

            @Override
            public void failure(RetrofitError var1) {

                viewInterface.interError(var1);
            }
        });

    }
}
