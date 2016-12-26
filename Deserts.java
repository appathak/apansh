package com.example.connoisseur;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Deserts extends Activity implements OnClickListener{

	String uname;
	int i = 1,grossamt;
	TextView t1,t2,t3;
 	Spinner sp,sp1,sp2,sp3;
 	Button b[];
 	int ids[] = {
 		R.id.dstadd1,R.id.dstadd2,R.id.dstadd3	
 	};
 	ArrayAdapter<String> ad,ad1;
 	ArrayList<String> al,al1;
 	ArrayList<Button> buttonarray;
 	String Types="Deserts",Qty;
	Database d;
	SQLiteDatabase sqdb;
 	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deserts);
		int m=0;
		sp1 = (Spinner)findViewById(R.id.dstspinner2);
		sp2 = (Spinner)findViewById(R.id.dstspinner3);
		sp3 = (Spinner)findViewById(R.id.dstspinner4);
		
		t1 = (TextView)findViewById(R.id.dstt1);
		t2 = (TextView)findViewById(R.id.dstt2);
		t3 = (TextView)findViewById(R.id.dstt3);
		b = new Button[20];
		buttonarray = new ArrayList<Button>(ids.length);
		for(int k:ids){
		b[m] = (Button)findViewById(k);
		b[m].setOnClickListener(this);
		m++;
		}
		al1 = new ArrayList<String>();
		
		al1.add("Qty..");
		while(i<=10){
			al1.add(i+"");
			i++;
		}
		ad1 = new ArrayAdapter<String>(Deserts.this, android.R.layout.simple_spinner_item,al1);
		sp1.setAdapter(ad1);
		sp2.setAdapter(ad1);
		sp3.setAdapter(ad1);
		
		
		sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> list, View arg1,
					int position, long arg3) {

				Qty = list.getItemAtPosition(position).toString();	
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {}
		});
		sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> list, View arg1,
					int position, long arg3) {
				Qty = list.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {}
		});
		sp3.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> list, View arg1,
					int position, long arg3) {
				Qty = list.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {}
		});
	}
	@Override
	public void onClick(View v) {
		String name,names,price;
		int j=0,id;
		Intent in;
		
		switch(v.getId()){
		
		case R.id.dstadd1:	if(Home.check<0){
						names = t1.getText()+"";
						id = 16;
								while(j<names.length()){
									if(names.charAt(j)=='-'){
										break;
									}
									j++;
								}
								name = names.substring(0, j);
								price = names.substring(j+1,names.length());
								grossamt = (Integer.parseInt(price)*Integer.parseInt(Qty));
							    try{
							    	d = new Database(Deserts.this);
							    	sqdb = d.getWritableDatabase();
							    	sqdb.execSQL("insert into cart values('"+Login.uname+"','"+id+"','"+name+"','"+Types+"','"+price+"','"+Qty+"','"+grossamt+"')");
							    	sqdb.close();
								    Toast.makeText(Deserts.this, name+"::"+price+"::"+Types, Toast.LENGTH_LONG).show();
								    in = new Intent(Deserts.this,Cart.class);
								    startActivity(in);
							    }
							    catch (Exception e) {
							    	Toast.makeText(Deserts.this, e.getMessage()+"", Toast.LENGTH_LONG).show();
								}
								break;}
		else{
			Toast.makeText(Deserts.this, "Please Login First:", Toast.LENGTH_LONG).show();
			in = new Intent(Deserts.this,Login.class);
			startActivity(in);
		}
		case R.id.dstadd2:if(Home.check<0){
						names = t2.getText()+"";
						id = 17;
								while(j<names.length()){
									if(names.charAt(j)=='-'){
										break;
									}
									j++;
								}
								name = names.substring(0, j);
								price = names.substring(j+1,names.length());
								grossamt = (Integer.parseInt(price)*Integer.parseInt(Qty));
								try{
							    	d = new Database(Deserts.this);
							    	sqdb = d.getWritableDatabase();
							    	sqdb.execSQL("insert into cart values('"+Login.uname+"','"+id+"','"+name+"','"+Types+"','"+price+"','"+Qty+"','"+grossamt+"')");
							    	sqdb.close();
							    }
							    catch (Exception e) {
							    	e.printStackTrace();
								}
								Toast.makeText(Deserts.this, "Added to cart"+name+":"+price+":"+Types, Toast.LENGTH_LONG).show();
								in = new Intent(Deserts.this,Cart.class);
								startActivity(in);
								break;
								}
		else{
			Toast.makeText(Deserts.this, "Please Login First:", Toast.LENGTH_LONG).show();
			in = new Intent(Deserts.this,Login.class);
			startActivity(in);
		}
		case R.id.dstadd3:if(Home.check<0){
						names = t3.getText()+"";
						id = 18;
								while(j<names.length()){
									if(names.charAt(j)=='-'){
										break;
									}
									j++;
								}
								name = names.substring(0, j);
								price = names.substring(j+1,names.length());
								grossamt = (Integer.parseInt(price)*Integer.parseInt(Qty));
								try{
							    	d = new Database(Deserts.this);
							    	sqdb = d.getWritableDatabase();
							    	sqdb.execSQL("insert into cart values('"+Login.uname+"','"+id+"','"+name+"','"+Types+"','"+price+"','"+Qty+"','"+grossamt+"')");
							    	sqdb.close();
							    }
							    catch (Exception e) {
							    	e.printStackTrace();
								}
								Toast.makeText(Deserts.this, "Added to cart"+name+":"+price+":"+Types, Toast.LENGTH_LONG).show();
								in = new Intent(Deserts.this,Cart.class);
								startActivity(in);
								break;
					}	
		else{
			Toast.makeText(Deserts.this, "Please Login First:", Toast.LENGTH_LONG).show();
			in = new Intent(Deserts.this,Login.class);
			startActivity(in);
		}
		default:break;
		}

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
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	if(item.getTitle().equals("Cart")){
		Intent in = new Intent(Deserts.this,Cart.class);
		startActivity(in);
	}
	if(item.getTitle().equals("SignIn")){
		Intent in = new Intent(Deserts.this,Login.class);
		startActivity(in);
	}
	if(item.getTitle().equals("Sign Out")){
		Toast.makeText(Deserts.this, "Succefully logged out", Toast.LENGTH_LONG).show();
		Home.check = 0;
		Cart.Carts.clear();
		Login.uname = "";
		Intent in = new Intent(Deserts.this,Home.class);
		startActivity(in);
	}
	return super.onOptionsItemSelected(item);
}
}
