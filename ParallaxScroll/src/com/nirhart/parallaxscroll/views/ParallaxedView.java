package com.nirhart.parallaxscroll.views;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

public abstract class ParallaxedView {
	static public boolean isAPI11 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
	protected WeakReference<View> view;
	protected int lastOffset;
	protected List<Animation> animations;

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
