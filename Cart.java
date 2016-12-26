package com.example.connoisseur;

import java.util.ArrayList;

import android.R.drawable;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.StaticLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class Cart extends Activity {
	ImageButton b;
	ListView lst;
	int price,quantity,Totalprice;
	static int cartvalue;
	String name,type;
	Database d;
	String Total;
	static ArrayList<String> Carts;
	ArrayAdapter<String> ad;
	SQLiteDatabase sqdb;
	Button b1;
	Cursor cr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart);
		b = (ImageButton)findViewById(R.id.del); 
		b1 = (Button)findViewById(R.id.confrmbtn);
		lst = (ListView)findViewById(R.id.listView1);
		Carts = new ArrayList<String>();
		try{
		d = new Database(Cart.this);
		sqdb = d.getReadableDatabase();
		cr = sqdb.rawQuery("select * from cart where uname = '"+Login.uname+"'", null);
		while(!cr.isLast()){
			cr.moveToNext();
			name = cr.getString(2);
			type = cr.getString(3);
			price = cr.getInt(4);
			quantity = cr.getInt(5);
			Totalprice = Totalprice + cr.getInt(6); 
			Carts.add(name+":"+price+":"+type+":"+quantity);
		}
		ad = new ArrayAdapter<String>(Cart.this, android.R.layout.simple_selectable_list_item,Carts);
		lst.setAdapter(ad);
		}catch(Exception e){
			cartvalue = 0;
			Toast.makeText(Cart.this, "Cart is empty!!", Toast.LENGTH_LONG).show();
		}
		
		Toast.makeText(Cart.this, Totalprice+"", Toast.LENGTH_LONG).show();
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Carts.clear();
				Intent in = new Intent(Cart.this,Home.class);
				startActivity(in);
			}
		});
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(Cart.this,Billing.class);
				Total = Totalprice+"";
				i.putExtra("Amount", Totalprice);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getTitle().equals("Confirm")){
			//Intent i = new Intent(Cart.this,Billing.class);
			//i.putExtra("Amount",Totalprice);
			//startActivity(i);
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		MenuItem mt = menu.add("Confirm");
		mt.setEnabled(true);
		mt.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		mt.setIcon(drawable.btn_dropdown);
		return true;
	}

}
