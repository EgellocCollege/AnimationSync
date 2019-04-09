package com.demo.animationsync;

import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.AnimationSet;

public class Anim {

    IAnimState currentAnimState;

    IAnimState runingAnimState;
    IAnimState noAnimState;

    //    private float alpha;
//    private float translationX;
//    private float scaleX;
//    private float scaleY;

    public long getLastPlayTime() {
        return lastPlayTime;
    }

    public void setLastPlayTime(long lastPlayTime) {
        this.lastPlayTime = lastPlayTime;
    }

    private long lastPlayTime;


    public void setPlayTime(long playTime) {
        this.lastPlayTime = playTime;
    }

    public Anim(){
        runingAnimState = new AnimRunningState(this);
        noAnimState = new AninDownState(this);
        currentAnimState = noAnimState;
    }

    public IAnimState getRuningAnimState() {
        return runingAnimState;
    }


    public IAnimState getNoAnimState() {
        return noAnimState;
    }




    public IAnimState getCurrentAnimState() {
        return currentAnimState;
    }

    public void setCurrentAnimState(IAnimState currentAnimState) {
        this.currentAnimState = currentAnimState;
    }

    public AnimationSet getAnimationSet(){
        return currentAnimState.getAnimationSet();
    }


}
