package com.example.connoisseur;

import android.R.drawable;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.content.Intent;
import android.view.Menu;
import android.widget.FrameLayout;

public class Adminoperation extends Activity {

	FrameLayout fl;
	ActionBar ar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adminoperation);
		
		fl = (FrameLayout)findViewById(R.id.adminframe);
		ar = getActionBar();
		ActionBar.Tab tab1 = ar.newTab();
		tab1.setText("User Details");
		tab1.setIcon(drawable.ic_dialog_info);
		tab1.setTabListener(new TabListener() {
			
			@Override
			public void onTabUnselected(Tab arg0, FragmentTransaction ft) {}
			
			@Override
			public void onTabSelected(Tab arg0, FragmentTransaction ft) {
				Adminfrag1 af = new Adminfrag1();
				ft.replace(R.id.adminframe, af);
			}
			
			@Override
			public void onTabReselected(Tab arg0, FragmentTransaction arg1) {}
		});
		ActionBar.Tab tab2 = ar.newTab();
		tab2.setIcon(drawable.ic_input_add);
		tab2.setText("Promotions and Offers");
		tab2.setTabListener(new TabListener() {
			
			@Override
			public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {}
			
			@Override
			public void onTabSelected(Tab arg0, FragmentTransaction ft) {
				Adminfrag2 af1 = new Adminfrag2();
				ft.replace(R.id.adminframe, af1);
			}
			
			@Override
			public void onTabReselected(Tab arg0, FragmentTransaction arg1) {}
		});
		ar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		ar.addTab(tab1);
		ar.addTab(tab2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.adminoperation, menu);
		return true;
	}
	@Override
	public void onBackPressed() {
		Intent in = new Intent(Adminoperation.this,Admin.class);
		startActivity(in);
		super.onBackPressed();
	}

}
