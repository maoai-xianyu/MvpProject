// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 08/04/2017 16:53 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mvpproject.ui.features;


import com.mao.cn.mvpproject.model.MovieDetail;
import com.mao.cn.mvpproject.ui.commons.BaseViewInferface;

import java.util.List;

/**
* DESC   :
* AUTHOR : Xabad
*/
public interface IOkhttpShowContent extends BaseViewInferface {
    void showTopMovie(List<MovieDetail> subjects, String title);

}
