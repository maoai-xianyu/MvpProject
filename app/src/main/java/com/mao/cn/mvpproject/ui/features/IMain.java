// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 06/09/2017 11:17 上午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mvpproject.ui.features;

import com.mao.cn.mvpproject.base.BaseViewInterface;
import com.mao.cn.mvpproject.model.MovieDetail;

import java.util.List;

/**
* DESC   :
* AUTHOR : Xabad
*/
public interface IMain extends BaseViewInterface {

    void showTopMovie(List<MovieDetail> movieDetails,String platformTitle);

}
