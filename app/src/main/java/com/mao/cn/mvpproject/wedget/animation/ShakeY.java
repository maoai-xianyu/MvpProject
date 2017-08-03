package com.mao.cn.mvpproject.wedget.animation;

import android.view.View;

import com.mao.cn.mvpproject.wedget.animation.animationeffects.BaseEffects;
import com.nineoldandroids.animation.ObjectAnimator;

public class ShakeY extends BaseEffects {

    @Override
    protected void setupAnimation(View view) {
        getAnimatorSet().playTogether(
                ObjectAnimator.ofFloat(view, "translationY", 0, 15, -10, 10, -5, 5, 0).setDuration(mDuration)

        );
    }
}
