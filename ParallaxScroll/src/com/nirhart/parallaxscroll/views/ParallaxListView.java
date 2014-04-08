package com.nirhart.parallaxscroll.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

import com.nirhart.parallaxscroll.R;

public class ParallaxListView extends ListView implements OnScrollListener {

	private static final float DEFAULT_PARALLAX_FACTOR = 1.9F;
	private static final boolean DEFAULT_IS_CIRCULAR = false;
	private float parallaxFactor = DEFAULT_PARALLAX_FACTOR;
	private ParallaxedView parallaxedView;
	private boolean isCircular;
	private OnScrollListener listener = null;

	public ParallaxListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs);
	}

	public ParallaxListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	protected void init(Context context, AttributeSet attrs) {
		TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.ParallaxScroll);
		this.parallaxFactor = typeArray.getFloat(R.styleable.ParallaxScroll_parallax_factor, DEFAULT_PARALLAX_FACTOR);
		this.isCircular = typeArray.getBoolean(R.styleable.ParallaxScroll_circular_parallax, DEFAULT_IS_CIRCULAR);
		typeArray.recycle();
		super.setOnScrollListener(this);
	}

	@Override
	public void setOnScrollListener(OnScrollListener l) {
		this.listener = l;
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
	}

	public void addParallaxedHeaderView(View v) {
		super.addHeaderView(v);
		addParallaxedView(v);
	}

	public void addParallaxedHeaderView(View v, Object data, boolean isSelectable) {
		super.addHeaderView(v, data, isSelectable);
		addParallaxedView(v);
	}

	private void addParallaxedView(View v) {
		this.parallaxedView = new ParallaxedListView(v);
	}

	protected void parallaxScroll() {
		if (isCircular)
			circularParallax();
		else
			headerParallax();
	}

	private void circularParallax() {
		if (getChildCount() > 0) {
			int top = -getChildAt(0).getTop();
			float factor = parallaxFactor;
			fillParallaxedViews();
			parallaxedView.setOffset((float)top / factor);
		}
	}

	private void headerParallax() {
		if (parallaxedView != null) {
			if (getChildCount() > 0) {
				int top = -getChildAt(0).getTop();
				float factor = parallaxFactor;
				parallaxedView.setOffset((float)top / factor);
			}
		}
	}

	private void fillParallaxedViews() {
		if (parallaxedView == null || parallaxedView.is(getChildAt(0)) == false) {
			if (parallaxedView != null) {
				parallaxedView.setOffset(0);
				parallaxedView.setView(getChildAt(0));
			} else {
				parallaxedView = new ParallaxedListView(getChildAt(0));
			}
		}
	}
	
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		parallaxScroll();
		if (this.listener != null)
			this.listener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		if (this.listener != null)
			this.listener.onScrollStateChanged(view, scrollState);
	}
	
	public class ParallaxedListView extends ParallaxedView {

		public ParallaxedListView(View view) {
			super(view);
		}

		@Override
		protected void translatePreICS(View view, float offset) {
			TranslateAnimation ta = new TranslateAnimation(0, 0, offset, offset);
			ta.setDuration(0);
			ta.setFillAfter(true);
			view.setAnimation(ta);
			ta.start();
		}
	}
}
