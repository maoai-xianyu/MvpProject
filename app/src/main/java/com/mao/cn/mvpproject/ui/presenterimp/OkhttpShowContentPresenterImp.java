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

import com.mao.cn.mvpproject.R;
import com.mao.cn.mvpproject.interactors.OkhttpShowContentInteractor;
import com.mao.cn.mvpproject.ui.commons.BasePresenterImp;
import com.mao.cn.mvpproject.ui.features.IOkhttpShowContent;
import com.mao.cn.mvpproject.ui.presenter.OkhttpShowContentPresenter;
import com.mao.cn.mvpproject.utils.network.NetworkUtils;

/**
* DESC   :
* AUTHOR : Xabad
*/
public class OkhttpShowContentPresenterImp extends BasePresenterImp implements OkhttpShowContentPresenter {
    OkhttpShowContentInteractor interactor;
    IOkhttpShowContent viewInterface;
    public OkhttpShowContentPresenterImp(IOkhttpShowContent viewInterface,OkhttpShowContentInteractor okhttpShowContentInteractor) {
        super();
        this.viewInterface = viewInterface;
        this.interactor = okhttpShowContentInteractor;
    }

    @Override
    public void getMovieTop(int start, int count) {
        if (!NetworkUtils.isConnected(context)) {
            viewInterface.onTip(context.getString(R.string.no_connect_net));
            return;
        }
        viewInterface.showLoadingDialog("");

    }
}
