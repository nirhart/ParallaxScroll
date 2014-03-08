package com.nirhart.parallaxscrollexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nirhart.parallaxscroll.views.ParallaxListView;

public class SingleParallaxListView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_one_parallax);
		ParallaxListView listView = (ParallaxListView) findViewById(R.id.list_view);
		CustomAdapter adapter = new CustomAdapter(LayoutInflater.from(this));
		listView.setAdapter(adapter);
		
		TextView v = new TextView(this);
		v.setText("PARALLAXED");
		v.setGravity(Gravity.CENTER);
		v.setTextSize(40);
		v.setHeight(200);
		v.setBackgroundResource(R.drawable.item_background);
		
		listView.addParallaxedHeaderView(v);
	}
	
	public class CustomAdapter extends BaseAdapter {

		private LayoutInflater inflater;

		public CustomAdapter(LayoutInflater inflater) {
			this.inflater = inflater;
		}
		
		@Override
		public int getCount() {
			return 20;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView textView = (TextView) convertView;
			if (textView == null)
				textView = (TextView) inflater.inflate(R.layout.item, null);
			textView.setText("Item " + position);
			return textView;
		}
		
	}
}
