package com.demo.animationsync;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class AnimRunningState implements IAnimState{

    private static final String TAG = "AnimRunningState";
    private  Anim anim;

    public AnimRunningState(Anim anim){
        this.anim = anim;
    }


    @Override
    public AnimationSet getAnimationSet() {

        long currentSystemTimeMs = System.currentTimeMillis();
        float alpha = (currentSystemTimeMs - anim.getLastPlayTime())/10000f;
        float translationX = 400 * (currentSystemTimeMs - anim.getLastPlayTime())/10000f;
        float scaleX = (currentSystemTimeMs - anim.getLastPlayTime())/10000f;
        float scaleY = (currentSystemTimeMs - anim.getLastPlayTime())/10000f;

        Log.d("Lwx642472","scaleX:" + String.valueOf(scaleX));
        Log.d("Lwx642472","translationX:" + String.valueOf(translationX));

        Log.d("Lwx642472","alpha:" + String.valueOf(alpha));
        Log.d("Lwx642472","translationX:" + String.valueOf(translationX));

        Log.d("Lwx642472","translationX:" + String.valueOf(translationX));

        AnimationSet animationSet;

        long duratiom = 10000l - (currentSystemTimeMs - anim.getLastPlayTime());
        Log.d("Lwx642472","duratiom:" + String.valueOf(duratiom));


        animationSet = new AnimationSet(true);

        /*
         *  创建一个半透明效果的动画对象，效果从完全透明到完全不透明
         */
        AlphaAnimation alphaAnimation = new AlphaAnimation(alpha,1);



        /*
         *  创建一个缩放效果的动画
         *  入参列表含义如下：
         *  fromX：x轴的初始值
         *  toX：x轴缩放后的值
         *  fromY：y轴的初始值
         *  toY：y轴缩放后的值
         *  pivotXType：x轴坐标的类型，有ABSOLUT绝对坐标、RELATIVE_TO_SELF相对于自身坐标、RELATIVE_TO_PARENT相对于父控件的坐标
         *  pivotXValue：x轴的值，0.5f表明是以自身这个控件的一半长度为x轴
         *  pivotYType：y轴坐标的类型
         *  pivotYValue：轴的值，0.5f表明是以自身这个控件的一半长度为y轴
         */
        ScaleAnimation scaleAnimation = new ScaleAnimation(scaleX,1f,scaleY,1f);

        /*
         *  创建一个移动动画效果
         *  入参的含义如下：
         *  fromXType：移动前的x轴坐标的类型
         *  fromXValue：移动前的x轴的坐标
         *  toXType：移动后的x轴的坐标的类型
         *  toXValue：移动后的x轴的坐标
         *  fromYType：移动前的y轴的坐标的类型
         *  fromYValue：移动前的y轴的坐标
         *  toYType：移动后的y轴的坐标的类型
         *  toYValue：移动后的y轴的坐标
         */
        TranslateAnimation translateAnimation = new TranslateAnimation(translationX,400,0,0);

        /*
         *  将四种动画效果放入同一个AnimationSet中
         */
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);


        animationSet.setDuration(duratiom);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                    Log.d("Lwx642472","onAnimationStart:" + String.valueOf( System.currentTimeMillis()));
            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                anim.setCurrentAnimState(anim.getNoAnimState());
                Log.d("Lwx642472","End Time :" + String.valueOf(System.currentTimeMillis()));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        return animationSet;
    }
}
