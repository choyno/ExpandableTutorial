package com.example.expandablelisttutorial;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpAdapter extends BaseExpandableListAdapter {

	private Context myContext;
	ExpList expList = new ExpList();
	public ExpAdapter(Context context) {
		myContext = context;
	}
	
	
	@Override
	public Object getChild(int groupPostion, int childPostion) {
		return null;
	}
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}
	@SuppressWarnings("static-access")
	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.child_row, null);
		}
		
		TextView tvPlayerName = (TextView) convertView.findViewById(R.id.tvPlayerName); 
		
		tvPlayerName.setText(expList.arrChildElements[groupPosition][childPosition]);
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return ExpList.arrChildElements[groupPosition].length ;
	}
	@Override
	public Object getGroup(int groupPosition) {
		return null;
	}
	@Override
	public int getGroupCount() {
		return ExpList.arrGroupElements.length;
	}
	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}
	@SuppressWarnings("static-access")
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		Log.d("loooo", expList.arrGroupElements[0].toString());
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.group_row, null);
		}
			
		ImageView expand_img = (ImageView) convertView.findViewById(R.id.explist_indicator);
		if(isExpanded){
			expand_img.setTag("on");
			expand_img.setImageResource(R.drawable.expander_ic_maximized);
		}else{
			expand_img.setTag("off");
			expand_img.setImageResource(R.drawable.expander_ic_minimized);
		}
		
		TextView tvGroupName = (TextView) convertView.findViewById(R.id.tvGroupName);
		tvGroupName.setText(expList.arrGroupElements[groupPosition]);
	
		return convertView;
		
	}
	private ImageView findViewById(int explistIndicator) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean hasStableIds() {
		return false;
	}
	@Override
	public boolean isChildSelectable(int groupPostion, int childPosition) {
		return false;
	}
	
 

}
