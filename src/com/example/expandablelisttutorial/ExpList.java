package com.example.expandablelisttutorial;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

public class ExpList extends ExpandableListActivity {

	
	// GROUP HEADER
	
	static final String arrGroupElements[] = {
			"India",
			"Australia",
			"England",
			"South Africa"
	};
	
	static final String arrChildElements[][] = {
		{"india 1", "india 2", "india 3"},
		{"australia 1", "australia 2", "australia 3'"},
		{"england 1", "england 3", "englang 4"},
		{"south 1", "south 2", "south 3"}
	};
	
	DisplayMetrics metrics;
	int width;
	ExpandableListView expList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main);
		super.onCreate(savedInstanceState);
		
		expList = getExpandableListView();
		metrics = new DisplayMetrics();
		
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		width = metrics.widthPixels;
		expList.setIndicatorBounds(width - GetDipsFromPixels(50), width - GetDipsFromPixels(50));
		expList.setAdapter(new ExpAdapter(this));
		expList.setGroupIndicator(null);
		expList.setOnGroupExpandListener(new OnGroupExpandListener(){

			@Override
			public void onGroupExpand(int groupPosition) { 
				Log.d("OnGroupExpand", ""+groupPosition);
				
				
			}
		});
		
		expList.setOnChildClickListener(new OnChildClickListener(){

			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int position, int childPosition, long id) 
			{
				Log.d("onChildClickListener", "=======");
				return false;
			}
		});
	}
	
 
	public int GetDipsFromPixels(float pixels){
		final float scale = getResources().getDisplayMetrics().density;
		return (int) (pixels + scale + 0.5f);
	}
	
}













































































