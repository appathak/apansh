package com.example.connoisseur;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends Activity {
	Button b;
	EditText et,et1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		b = (Button)findViewById(R.id.adminsigninbtn);
		et = (EditText)findViewById(R.id.etuname);
		et1 = (EditText)findViewById(R.id.etpass);
		
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String a = et.getText()+"";
				String b = et1.getText()+"";
				if(a.equals("AdminFood") && b.equals("Admin976")){
					Intent in = new Intent(Admin.this,Adminoperation.class);
					startActivity(in);
				}
				else{
					Toast.makeText(Admin.this, "Wrong details!!", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	@Override
	public void onBackPressed() {
		Intent in = new Intent(Admin.this,Home.class);
		startActivity(in);
		
		super.onBackPressed();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin, menu);
		return true;
	}

}
