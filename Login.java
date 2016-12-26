package com.example.connoisseur;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	EditText et,et1;
	Button b,b1,b2;
	Cursor cr;
	Database d;
	SQLiteDatabase db;
	static String uname;
	//Database d;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		b = (Button)findViewById(R.id.signinbtn);
		b1 = (Button)findViewById(R.id.signupbtn);
		et = (EditText)findViewById(R.id.etuname);
		et1 = (EditText)findViewById(R.id.etpass);
		b2 = (Button)findViewById(R.id.gotoadm);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				try{
					d = new Database(Login.this);
					db = d.getReadableDatabase();
					cr = db.rawQuery("select * from userinfo where uname = '"+et.getText()+"' and upass = '"+et1.getText()+"'", null);
					if(cr.getCount()>0){
						cr.moveToNext();
						uname = cr.getString(0);
					
						Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
						Home.check = -1;
						Intent in = new Intent(Login.this,Home.class);
						startActivity(in);
					}
				}catch(Exception ex){
					Toast.makeText(Login.this, "Incorrect details!!Retry.", Toast.LENGTH_SHORT).show();
				}
			}
		});
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(Login.this, "Register here!!", Toast.LENGTH_SHORT).show();
				Intent in = new Intent(Login.this,Registration.class);
				startActivity(in);
			}
		});
		
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent in = new Intent(Login.this,Admin.class);
				startActivity(in);	
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
