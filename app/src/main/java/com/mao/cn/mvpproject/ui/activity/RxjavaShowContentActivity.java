// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 08/04/2017 16:53 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mvpproject.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.mao.cn.mvpproject.R;
import com.mao.cn.mvpproject.component.AppComponent;
import com.mao.cn.mvpproject.component.DaggerRxjavaShowContentComponent;
import com.mao.cn.mvpproject.contants.ValueMaps;
import com.mao.cn.mvpproject.model.MovieDetail;
import com.mao.cn.mvpproject.modules.RxjavaShowContentModule;
import com.mao.cn.mvpproject.ui.adapter.MovieTopAdapter;
import com.mao.cn.mvpproject.ui.commons.BaseActivity;
import com.mao.cn.mvpproject.ui.features.IRxjavaShowContent;
import com.mao.cn.mvpproject.ui.presenter.RxjavaShowContentPresenter;
import com.mao.cn.mvpproject.utils.tools.ListU;
import com.mao.cn.mvpproject.utils.tools.LogU;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * DESC   :
 * AUTHOR : Xabad
 */
public class RxjavaShowContentActivity extends BaseActivity implements IRxjavaShowContent {

    @Inject
    RxjavaShowContentPresenter presenter;

    @BindView(R.id.ib_header_back)
    ImageButton ibHeaderBack;
    @BindView(R.id.tv_header_title)
    TextView tvHeaderTitle;
    @BindView(R.id.rvData)
    RecyclerView rvData;

    @Override
    public void getArgs(Bundle bundle) {

    }

    @Override
    public int setView() {
        return R.layout.aty_rxjava_show_content;
    }

    @Override
    public void initView() {
        presenter.getMovieTop(0, 10);
    }

    @Override
    public void setListener() {

        RxView.clicks(ibHeaderBack).throttleFirst(ValueMaps.ClickTime.BREAK_TIME_MILLISECOND, TimeUnit
                .MILLISECONDS).subscribe(aVoid -> {
            finish();
        }, throwable -> {
            LogU.e(throwable.getMessage());
        });


    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerRxjavaShowContentComponent.builder()
                .appComponent(appComponent)
                .rxjavaShowContentModule(new RxjavaShowContentModule(this))
                .build().inject(this);
    }

    @Override
    public void showTopMovie(List<MovieDetail> movieDetails,String title) {
        if (!checkActivityState()) return;
        tvHeaderTitle.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(title);
        if (ListU.notEmpty(movieDetails)) {
            LinearLayoutManager linearLayoutCourse = new LinearLayoutManager(context);
            linearLayoutCourse.setOrientation(LinearLayoutManager.VERTICAL);
            rvData.setLayoutManager(linearLayoutCourse);
            MovieTopAdapter movieTopAdapter = new MovieTopAdapter(this);
            movieTopAdapter.addMovieList(movieDetails);
            rvData.setAdapter(movieTopAdapter);
        }
    }

    @Override
    public void onDestroy() {
        presenter.onDestroySubscribe();
        super.onDestroy();
    }
}
