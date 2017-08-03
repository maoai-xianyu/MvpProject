package com.mao.cn.mvpproject.wedget.animation;

import android.view.View;

import com.mao.cn.mvpproject.wedget.animation.animationeffects.BaseEffects;
import com.nineoldandroids.animation.ObjectAnimator;


public class AddCoin extends BaseEffects {
    @Override
    protected void setupAnimation(View view) {
        getAnimatorSet().playTogether(
                ObjectAnimator.ofFloat(view, "translationY", 0, -300,-800).setDuration(mDuration),
                ObjectAnimator.ofFloat(view, "translationX", 0, 200,500).setDuration(mDuration),
                ObjectAnimator.ofFloat(view, "scaleX", 1, 0.8f, 0.5f).setDuration(mDuration),
                ObjectAnimator.ofFloat(view,"scaleY",1,0.8f,0.5f).setDuration(mDuration),
                ObjectAnimator.ofFloat(view, "alpha", 1, 0).setDuration(mDuration*3/2)

        );
    }
}
