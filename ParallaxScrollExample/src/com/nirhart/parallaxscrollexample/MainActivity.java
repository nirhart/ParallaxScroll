package com.nirhart.parallaxscrollexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

	public void onSingleScrollParallaxAlphaClicked(View v) {
		Intent intent = new Intent(this, SingleParallaxAlphaScrollView.class);
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

	public void onSingleExpandableListParallaxClicked(View v) {
		Intent intent = new Intent(this, SingleParallaxExpandableListView.class);
		startActivity(intent);
	}

	public void onMultipleExpandableListParallaxClicked(View v) {
		Intent intent = new Intent(this, MultipleParallaxExpandableListView.class);
		startActivity(intent);
	}
	
	public void onMultipleListParallaxClicked(View v) {
		Intent intent = new Intent(this, MultipleParallaxListView.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.action_github) {
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/nirhart/ParallaxScroll"));
			startActivity(browserIntent);
		}
		return true;
	}
}