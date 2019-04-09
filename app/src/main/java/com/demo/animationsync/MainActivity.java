package com.demo.animationsync;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "AnimationSync";

    Anim anim = new Anim();

    AnimationSet animationSet;



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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView image0 = (ImageView)findViewById(R.id.image0);
        final ImageView image1 = (ImageView)findViewById(R.id.image1);
        final ImageView image2 = (ImageView)findViewById(R.id.image2);

        animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);

        animationSet.setDuration(10000);


        Button btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = anim.getAnimationSet();
                image0.startAnimation(animationSet);

////                ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(image0, "translationX", 0, 400, 0);
////                tv1TranslateY.setDuration(10000);
////                tv1TranslateY.start();
//
//                image0.startAnimation(animationSet);

            }
        });

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = anim.getAnimationSet();
                image1.startAnimation(animationSet);

//                image1.startAnimation(animationSet);

            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = anim.getAnimationSet();
                image2.startAnimation(animationSet);
            }
        });


    }
}
