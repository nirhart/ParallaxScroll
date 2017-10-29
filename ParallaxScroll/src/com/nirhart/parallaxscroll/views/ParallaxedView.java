package com.nirhart.parallaxscroll.views;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class ParallaxedView {
    private static boolean isAPI11 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    private static boolean isAPI18 = Build.VERSION.SDK_INT >= 18;
    protected WeakReference<View> view;
    protected int lastOffset;
    protected List<Animation> animations;
    protected Rect clippingRect = new Rect();
    protected boolean firstRectGet = false;
    private int lastScrollY;

    abstract protected void translatePreICS(View view, float offset);

    public ParallaxedView(View view) {
        this.lastOffset = 0;
        this.animations = new ArrayList<Animation>();
        this.view = new WeakReference<View>(view);
    }

    public boolean is(View v) {
        return (v != null && view != null && view.get() != null && view.get().equals(v));
    }

    @SuppressLint("NewApi")
    public void setOffset(float offset) {
        View view = this.view.get();
        if (view != null)
            if (isAPI11) {
                view.setTranslationY(offset);
            } else {
                translatePreICS(view, offset);
            }
    }

    @SuppressLint("NewApi")
    public void setOffset(float offset, int originalScrollY) {
        View view = this.view.get();
        if (view != null)
            if (isAPI11) {
                if (!firstRectGet) {
                    clippingRect.top = view.getTop();
                    clippingRect.left = view.getLeft();
                    clippingRect.right = view.getRight();
                    clippingRect.bottom = view.getBottom();
                    firstRectGet = true;
                }
                if (lastScrollY == 0) {
                    lastScrollY = originalScrollY;
                }
                int delta = lastScrollY - originalScrollY;
                clippingRect.bottom += delta;
                view.setTranslationY(Math.round(offset));
                if (isAPI18) view.setClipBounds(clippingRect);
                lastScrollY = originalScrollY;
                if (isAPI18) {
                    if (clippingRect.bottom <= clippingRect.top) {
                        view.setVisibility(View.INVISIBLE);
                    } else {
                        view.setVisibility(View.VISIBLE);
                    }
                }
            } else {
                translatePreICS(view, offset);
            }
    }

    public void setAlpha(float alpha) {
        View view = this.view.get();
        if (view != null)
            if (isAPI11) {
                view.setAlpha(alpha);
            } else {
                alphaPreICS(view, alpha);
            }
    }

    protected synchronized void addAnimation(Animation animation) {
        animations.add(animation);
    }

    protected void alphaPreICS(View view, float alpha) {
        addAnimation(new AlphaAnimation(alpha, alpha));
    }

    protected synchronized void animateNow() {
        View view = this.view.get();
        if (view != null) {
            AnimationSet set = new AnimationSet(true);
            for (Animation animation : animations)
                if (animation != null)
                    set.addAnimation(animation);
            set.setDuration(0);
            set.setFillAfter(true);
            view.setAnimation(set);
            set.start();
            animations.clear();
        }
    }

    public void setView(View view) {
        this.view = new WeakReference<View>(view);
    }
}
