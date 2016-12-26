package com.example.connoisseur;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Pizza extends Activity {
	ActionBar ac;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pizza);
		ac = getActionBar();
		ActionBar.Tab veg= ac.newTab();
		veg.setText("Vegetarian");
		veg.setIcon(R.drawable.vegicon);
		veg.setTabListener(new TabListener() {
			
			@Override
			public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {}
			
			@Override
			public void onTabSelected(Tab arg0, FragmentTransaction ft) {
				PizzaFragment pf = new PizzaFragment();
				ft.replace(R.id.myframe1, pf);
			}
			
			@Override
			public void onTabReselected(Tab arg0, FragmentTransaction arg1) {}
		});

		ActionBar.Tab nonveg= ac.newTab();
		nonveg.setText("Non-Vegetarian");
		nonveg.setIcon(R.drawable.nonvegicon);
		nonveg.setTabListener(new TabListener() {
			
			@Override
			public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {}
			
			@Override
			public void onTabSelected(Tab arg0, FragmentTransaction ft) {
				PizzaFragment1 pf1 = new PizzaFragment1();
				ft.replace(R.id.myframe1, pf1);
			}
			
			@Override
			public void onTabReselected(Tab arg0, FragmentTransaction arg1) {}
		});
		
		ac.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		ac.addTab(veg);
		ac.addTab(nonveg);
	}
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			if(item.getTitle().equals("SignIn")){
				Intent in = new Intent(Pizza.this,Login.class);
				startActivity(in);
			}
			if(item.getTitle().equals("Sign Out")){
				Toast.makeText(Pizza.this, "Succefully logged out", Toast.LENGTH_LONG).show();
				Home.check = 0;
				Intent in = new Intent(Pizza.this,Home.class);
				startActivity(in);
			}
			return super.onOptionsItemSelected(item);
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		String str=null;
		if(Home.check == 0){
			str = "SignIn";
		}
		else if(Home.check < 0){
			str = "Sign Out";
		}
		MenuItem mt = menu.add(str);
		mt.setEnabled(true);
		MenuItem mt1 = menu.add("location");
		mt1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		mt1.setIcon(android.R.drawable.ic_menu_mylocation);
		
		MenuItem mt2 = menu.add("Cart");
		mt2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		mt2.setIcon(android.R.drawable.ic_menu_slideshow);
		getMenuInflater().inflate(R.menu.pizza, menu);
		return true;
	}

}
