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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Billing extends Activity {

	Database d;
	int rows,amt;
	double tax,finalamt;
	Button b;
	Cursor cr;
	TextView tv,tv1,tv2,tv3;
	SQLiteDatabase sqdb;
	LinearLayout inner;
	EditText et;
	int Total = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_billing);
		b = (Button)findViewById(R.id.paybtn); 
		inner = (LinearLayout)findViewById(R.id.innerframe);
		tv1 = (TextView)findViewById(R.id.lastamt);
		tv2 = (TextView)findViewById(R.id.orderno);
		tv3 = (TextView)findViewById(R.id.tax);
		et = (EditText)findViewById(R.id.promoedit);
		int dd=(int)(Math.random()*10000);
		tv2.setText(dd+"");
		try{
		d = new Database(Billing.this);
		sqdb = d.getReadableDatabase();
		cr = sqdb.rawQuery("select itemname,price,quantity,grossamt from cart where uname = '"+Login.uname+"'", null);
		while(!cr.isLast()){	
			cr.moveToNext();
			tv = new TextView(Billing.this);
			tv.setText(cr.getString(0)+" "+cr.getInt(1)+"*"+cr.getInt(2)+"="+cr.getInt(3));
			Total += cr.getInt(3);
			inner.addView(tv);
		}
		
		tax = (Total * (0.40))*(0.145);
		finalamt = Total+tax;
		Toast.makeText(Billing.this, finalamt+"", Toast.LENGTH_LONG).show();
		tv3.setText(tv3.getText()+":\t"+tax);
		tv1.setText(tv1.getText()+":\t"+finalamt);
		}catch(Exception e){
			Toast.makeText(Billing.this, e.getMessage()+"", Toast.LENGTH_LONG).show();
		}
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
					try{
					sqdb = d.getWritableDatabase();
					sqdb.execSQL("insert into billing values('"+tv2.getText()+"','"+Login.uname+"','"+Total+"','"+tax+"','"+et.getText()+"','"+finalamt+"')");
					sqdb.close();
					Toast.makeText(getBaseContext(), "Order Placed!!", Toast.LENGTH_LONG).show();
					Intent in = new Intent(Billing.this,Info.class);
				}catch(Exception e){
					Toast.makeText(getBaseContext(), e.getMessage()+"", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.billing, menu);
		return true;
	}
}
