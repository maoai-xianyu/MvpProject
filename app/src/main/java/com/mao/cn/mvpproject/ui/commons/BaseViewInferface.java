package com.mao.cn.mvpproject.ui.commons;

import com.mao.cn.mvpproject.common.CommViewInterface;
import com.mao.cn.mvpproject.converter.RetrofitError;

/**
 * Created by zhangkun on 2017/6/9.
 */

public interface BaseViewInferface extends CommViewInterface {


    void interError(RetrofitError error);

    void interError(Throwable throwable);
}
