package com.nirhart.parallaxscrollexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.nirhart.parallaxscroll.views.ParallaxListView;

public class MultipleParallaxListView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_multiple_parallax);
		ParallaxListView listView = (ParallaxListView) findViewById(R.id.list_view);
		CustomAdapter adapter = new CustomAdapter(LayoutInflater.from(this));
		listView.setAdapter(adapter);
	}
}
