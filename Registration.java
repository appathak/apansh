package com.example.connoisseur;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends Activity {
	EditText et,et1,et2,et3,et4,et5,et6,et7;
	Button b,b1;
	SQLiteDatabase sqdb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		
		b = (Button)findViewById(R.id.submitregbtn);
		b1 = (Button)findViewById(R.id.resetbtn);
		
		et = (EditText)findViewById(R.id.fname);
		et1 = (EditText)findViewById(R.id.lname);
		et2 = (EditText)findViewById(R.id.mail);
		et3 = (EditText)findViewById(R.id.uname);
		et4 = (EditText)findViewById(R.id.pass);
		et5 = (EditText)findViewById(R.id.conpass);
		et6 = (EditText)findViewById(R.id.DOB);
		et7 = (EditText)findViewById(R.id.phone);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			/*	String fname = et.getText()+"";
				String lname = et1.getText()+"";
				String uname = et3.getText()+"";
				String mail = et2.getText()+"";
				String pass = et4.getText()+"";
				String conpass = et5.getText()+"";
				String dob = et6.getText()+"";
				String phone = et7.getText()+"";
			*/	
				//if((!fname.equals(null)) && (!lname.equals(null)) && (!uname.equals(null))&& (!mail.equals(null)) && (!pass.equals(null)) && (!conpass.equals(null)) && (!dob.equals(null)) && (!phone.equals(null)) && et4.getText().equals(et5.getText())){
				try{
				Database d = new Database(Registration.this);
				sqdb = d.getWritableDatabase();
				sqdb.execSQL("insert into userinfo values('"+et3.getText()+"','"+et.getText()+"','"+et1.getText()+"'," +
						"'"+et2.getText()+"','"+et4.getText()+"','"+et5.getText()+"','"+et6.getText()+"','"+et7.getText()+"')");
				
				Toast.makeText(Registration.this,et.getText()+":"+et1.getText()+":"+et2.getText()+":"+et3.getText()+":"
						+et4.getText()+":"+et5.getText()+":"+et6.getText()+":"+et7.getText(), Toast.LENGTH_LONG).show();
					Intent in = new Intent(Registration.this,Login.class);
					startActivity(in);
				}catch(Exception exception){
					Toast.makeText(Registration.this, exception.getMessage()+"", Toast.LENGTH_LONG).show();
				}
				//else{
				//	Toast.makeText(Registration.this, "Incomplete Details!!", Toast.LENGTH_LONG).show();
				//}
			}
		});
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				et.setText("");
				et1.setText("");
				et2.setText("");
				et3.setText("");
				et4.setText("");
				et5.setText("");
				et6.setText("");
				et7.setText("");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registration, menu);
		return true;
	}

}
