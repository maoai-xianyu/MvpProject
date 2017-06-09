// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 06/09/2017 11:36 上午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mvpproject.ui.presenterimp;

import com.mao.cn.mvpproject.interactors.LoadingInteractor;
import com.mao.cn.mvpproject.ui.commons.BasePresenterImp;
import com.mao.cn.mvpproject.ui.features.ILoading;
import com.mao.cn.mvpproject.ui.presenter.LoadingPresenter;

/**
* DESC   :
* AUTHOR : Xabad
*/
public class LoadingPresenterImp extends BasePresenterImp implements LoadingPresenter {
    LoadingInteractor interactor;
    ILoading viewInterface;
    public LoadingPresenterImp(ILoading viewInterface,LoadingInteractor loadingInteractor) {
        super();
        this.viewInterface = viewInterface;
        this.interactor = loadingInteractor;
    }
}
