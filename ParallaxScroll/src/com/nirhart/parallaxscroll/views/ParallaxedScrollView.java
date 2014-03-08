package com.nirhart.parallaxscroll.views;

import android.view.View;

public class ParallaxedScrollView extends ParallaxedView{

	public ParallaxedScrollView(View view) {
		super(view);
	}

	@Override
	protected void translatePreICS(View view, float offset) {
		view.offsetTopAndBottom((int)offset - lastOffset);
		lastOffset = (int)offset;
	}
}
