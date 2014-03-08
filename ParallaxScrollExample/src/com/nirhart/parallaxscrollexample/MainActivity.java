package com.nirhart.parallaxscrollexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void onSingleScrollParallaxClicked(View v) {
		Intent intent = new Intent(this, SingleParallaxScrollView.class);
		startActivity(intent);
	}
	
	public void onMultipleScrollParallaxClicked(View v) {
		Intent intent = new Intent(this, MultipleParallaxScrollView.class);
		startActivity(intent);
	}

	public void onSingleListParallaxClicked(View v) {
		Intent intent = new Intent(this, SingleParallaxListView.class);
		startActivity(intent);
	}
	
	public void onMultipleListParallaxClicked(View v) {
		Intent intent = new Intent(this, MultipleParallaxListView.class);
		startActivity(intent);
	}
}