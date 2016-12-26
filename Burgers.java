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

public class Burgers extends Activity {
	ActionBar ac;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_burgers);
		ac = getActionBar();
		ActionBar.Tab tab = ac.newTab();
		tab.setText("Vegetarian");
		tab.setIcon(R.drawable.vegicon);
		tab.setTabListener(new TabListener() {
			
			@Override
			public void onTabUnselected(Tab arg0, FragmentTransaction ft) {}
			
			@Override
			public void onTabSelected(Tab arg0, FragmentTransaction ft) {
				BurgerFragment pf = new BurgerFragment();
				ft.replace(R.id.burgerframes, pf);
			}
			
			@Override
			public void onTabReselected(Tab arg0, FragmentTransaction ft) {
			}
		});
		
		ActionBar.Tab tab1 = ac.newTab();
		tab1.setText("Non-Vegetarian");
		tab1.setIcon(R.drawable.nonvegicon);
		tab1.setTabListener(new TabListener() {
			
			@Override
			public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {}
			
			@Override
			public void onTabSelected(Tab arg0, FragmentTransaction ft) {
				BurgerFragent1 pf1 = new BurgerFragent1();
				ft.replace(R.id.burgerframes, pf1);
			}
			
			@Override
			public void onTabReselected(Tab arg0, FragmentTransaction arg1) {}
		});
		ac.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		ac.addTab(tab);
		ac.addTab(tab1);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		Toast.makeText(getBaseContext(), Home.check+"", Toast.LENGTH_LONG).show();
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
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	if(item.getTitle().equals("Cart")){
		Intent in = new Intent(Burgers.this,Cart.class);
		startActivity(in);
	}
	if(item.getTitle().equals("SignIn")){
		Intent in = new Intent(Burgers.this,Login.class);
		startActivity(in);
	}
	if(item.getTitle().equals("Sign Out")){
		Toast.makeText(Burgers.this, "Succefully logged out", Toast.LENGTH_LONG).show();
		Home.check = 0;
		Cart.Carts.clear();
		Login.uname = "";
		Intent in = new Intent(Burgers.this,Home.class);
		startActivity(in);
	}
	return super.onOptionsItemSelected(item);
}	
}
