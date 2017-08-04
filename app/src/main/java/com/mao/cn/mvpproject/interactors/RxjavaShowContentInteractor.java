// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 08/04/2017 16:53 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mvpproject.interactors;

import com.mao.cn.mvpproject.http.HttpApi;
import com.mao.cn.mvpproject.http.RestApiAdapter;

import javax.inject.Inject;

import rx.Observable;

/**
 * DESC   :
 * AUTHOR : Xabad
 */
public class RxjavaShowContentInteractor {

    @Inject
    public RxjavaShowContentInteractor() {

    }

    public Observable<String> getMovieTop(int start, int count) {
        HttpApi httpApi = RestApiAdapter.getStringInstance().create(HttpApi.class);
        return httpApi.getTodayMovie(start, count);
    }


}
