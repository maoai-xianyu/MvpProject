package com.mao.cn.mvpproject.wedget.animation.animationeffects;


import com.mao.cn.mvpproject.wedget.animation.FadeIn;
import com.mao.cn.mvpproject.wedget.animation.FadeOut;
import com.mao.cn.mvpproject.wedget.animation.FlipH;
import com.mao.cn.mvpproject.wedget.animation.FlipV;
import com.mao.cn.mvpproject.wedget.animation.NewsPaper;
import com.mao.cn.mvpproject.wedget.animation.ShakeY;
import com.mao.cn.mvpproject.wedget.animation.SideFall;
import com.mao.cn.mvpproject.wedget.animation.SlideLeft;
import com.mao.cn.mvpproject.wedget.animation.SlideRight;
import com.mao.cn.mvpproject.wedget.animation.SlideTop;

/**
 * Created by lee on 2014/7/30.
 */
//TODO
public enum Effectstype {

    Fadein(FadeIn.class),
    Fadeout(FadeOut.class),
    Slideleft(SlideLeft.class),
    Slidetop(SlideTop.class),
    SlideCenter(com.mao.cn.mvpproject.wedget.animation.SlideCenter.class),
    SlideBottomIn(com.mao.cn.mvpproject.wedget.animation.SlideBottomIn.class),
    SlideBottomOut(com.mao.cn.mvpproject.wedget.animation.SlideBottomOut.class),
    SlideBottomForLevelUp(com.mao.cn.mvpproject.wedget.animation.SlideBottomForLevelUp.class),
    Slideright(SlideRight.class),
    Fall(com.mao.cn.mvpproject.wedget.animation.Fall.class),
    Newspager(NewsPaper.class),
    Fliph(FlipH.class),
    Flipv(FlipV.class),
    RotateBottom(com.mao.cn.mvpproject.wedget.animation.RotateBottom.class),
    RotateLeft(com.mao.cn.mvpproject.wedget.animation.RotateLeft.class),
    Slit(com.mao.cn.mvpproject.wedget.animation.Slit.class),
    Shake(com.mao.cn.mvpproject.wedget.animation.Shake.class),
    ShakeUpAndDown(ShakeY.class),
    Sidefill(SideFall.class),
    RotateH(com.mao.cn.mvpproject.wedget.animation.RotateH.class),
    AddCoin(com.mao.cn.mvpproject.wedget.animation.AddCoin.class),
    SlideBottomForCoinNum(com.mao.cn.mvpproject.wedget.animation.SlideBottomForCoinNum.class),
    SlideBottomForRecordResult(com.mao.cn.mvpproject.wedget.animation.SlideBottomForRecordResult.class),
    SlideBottomForRecordResultKg(com.mao.cn.mvpproject.wedget.animation.SlideBottomForRecordResultKg.class),
    ScaleBig(com.mao.cn.mvpproject.wedget.animation.ScaleBig.class),
    ImageViewScaleXY(com.mao.cn.mvpproject.wedget.animation.ImageViewScaleXY.class);

    private Class<? extends BaseEffects> effectsClazz;

    private Effectstype(Class<? extends BaseEffects> mclass) {
        effectsClazz = mclass;
    }

    public BaseEffects getAnimator() {
        BaseEffects bEffects = null;
        try {
            bEffects = effectsClazz.newInstance();
        } catch (ClassCastException e) {
            throw new Error("Can not init animatorClazz instance");
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            throw new Error("Can not init animatorClazz instance");
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            throw new Error("Can not init animatorClazz instance");
        }
        return bEffects;
    }
}
