package com.example.connoisseur;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AlertWindow extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alert_window);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alert_window, menu);
		return true;
	}
	public void display(){
		
	}
}
