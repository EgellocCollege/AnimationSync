package com.demo.animationsync;


import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class AninDownState implements IAnimState {

    private static final String TAG = "AnimationDownState";
    private  Anim anim;



    public AninDownState(Anim anim){
        this.anim = anim;
    }

    @Override
    public AnimationSet getAnimationSet() {
        AnimationSet animationSet;

        animationSet = new AnimationSet(true);

        /*
         *  创建一个半透明效果的动画对象，效果从完全透明到完全不透明
         */
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);

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
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1f,0,1f);

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
        TranslateAnimation translateAnimation = new TranslateAnimation(0,400,0,0);

        /*
         *  将四种动画效果放入同一个AnimationSet中
         */
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);

        animationSet.setDuration(10000);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
//                lastStartTime = System.currentTimeMillis();
//                System.out.println(lastStartTime);
//                Log.d("Lwx642472",String.valueOf(lastStartTime));
                anim.setLastPlayTime(System.currentTimeMillis());
                anim.setCurrentAnimState(anim.getRuningAnimState());

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                anim.setCurrentAnimState(anim.getNoAnimState());
                Log.d("Lwx642472","End Time :" + String.valueOf(System.currentTimeMillis()));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        return animationSet;
    }
}
