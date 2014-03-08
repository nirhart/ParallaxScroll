package com.nirhart.parallaxscroll.views;

import android.view.View;
import android.view.animation.TranslateAnimation;

public class ParallaxedListView extends ParallaxedView {

	public ParallaxedListView(View view) {
		super(view);
	}

	@Override
	protected void translatePreICS(View view, float offset) {
		TranslateAnimation ta = new TranslateAnimation(0, 0, lastOffset, offset);
		ta.setDuration(0);
		ta.setFillAfter(true);
		view.setAnimation(ta);
		ta.start();
		lastOffset = (int)offset;
	}
}
