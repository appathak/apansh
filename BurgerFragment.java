package com.example.connoisseur;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class BurgerFragment extends Fragment implements OnClickListener{
	
	Activity act;
	String uname;
	int i = 1,grossamt;
	TextView t1,t2,t3;
 	Spinner sp,sp1,sp2,sp3;
 	Button b[];
 	int ids[] = {
 		R.id.vbgadd1,R.id.vbgadd2,R.id.vbgadd3	
 	};
 	ArrayAdapter<String> ad,ad1;
 	ArrayList<String> al,al1;
 	ArrayList<Button> buttonarray;
 	String Types="Veg Burger",Qty;
	Database d;
	SQLiteDatabase sqdb;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_burger_fragment, container, false);
	}
	@Override
	public void onStart() {
		int m=0;
		act = getActivity();
		sp1 = (Spinner)act.findViewById(R.id.vbgspinner2);
		sp2 = (Spinner)act.findViewById(R.id.vbgspinner3);
		sp3 = (Spinner)act.findViewById(R.id.vbgspinner4);
		
		t1 = (TextView)act.findViewById(R.id.vbgt1);
		t2 = (TextView)act.findViewById(R.id.vbgt2);
		t3 = (TextView)act.findViewById(R.id.vbgt3);
		b = new Button[20];
		buttonarray = new ArrayList<Button>(ids.length);
		for(int k:ids){
		b[m] = (Button)act.findViewById(k);
		b[m].setOnClickListener(this);
		m++;
		}
		al1 = new ArrayList<String>();
		
		ad = new ArrayAdapter<String>(act, android.R.layout.simple_spinner_item,al);
		sp.setAdapter(ad);
		al1.add("Qty..");
		while(i<=10){
			al1.add(i+"");
			i++;
		}
		ad1 = new ArrayAdapter<String>(act, android.R.layout.simple_spinner_item,al1);
		sp1.setAdapter(ad1);
		sp2.setAdapter(ad1);
		sp3.setAdapter(ad1);
		
		
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> list, View arg1,
					int position, long arg3) {
				Types = list.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {}
		});
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


		super.onStart();
	}

	@Override
	public void onClick(View v) {
		String name,names,price;
		int j=0,id;
		Intent in;
		
		switch(v.getId()){
		
		case R.id.vbgadd1:	if(Home.check<0){
						names = t1.getText()+"";
						id = 20;
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
							    	d = new Database(act);
							    	sqdb = d.getWritableDatabase();
							    	sqdb.execSQL("insert into cart values('"+Login.uname+"','"+id+"','"+name+"','"+Types+"','"+price+"','"+Qty+"','"+grossamt+"')");
							    	sqdb.close();
								    Toast.makeText(getActivity(), name+"::"+price+"::"+Types, Toast.LENGTH_LONG).show();
								    in = new Intent(act,Cart.class);
								    startActivity(in);
							    }
							    catch (Exception e) {
							    	Toast.makeText(act, e.getMessage()+"", Toast.LENGTH_LONG).show();
								}
								break;}
		else{
			Toast.makeText(getActivity(), "Please Login First:", Toast.LENGTH_LONG).show();
			in = new Intent(act,Login.class);
			startActivity(in);
		}
		case R.id.vbgadd2:if(Home.check<0){
						names = t2.getText()+"";
						id = 21;
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
							    	d = new Database(act);
							    	sqdb = d.getWritableDatabase();
							    	sqdb.execSQL("insert into cart values('"+Login.uname+"','"+id+"','"+name+"','"+Types+"','"+price+"','"+Qty+"','"+grossamt+"')");
							    	sqdb.close();
							    }
							    catch (Exception e) {
							    	e.printStackTrace();
								}
								Toast.makeText(getActivity(), "Added to cart"+name+":"+price+":"+Types, Toast.LENGTH_LONG).show();
								in = new Intent(act,Cart.class);
								startActivity(in);
								break;
								}
		else{
			Toast.makeText(getActivity(), "Please Login First:", Toast.LENGTH_LONG).show();
			in = new Intent(act,Login.class);
			startActivity(in);
		}
		case R.id.vbgadd3:if(Home.check<0){
						names = t3.getText()+"";
						id = 22;
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
							    	d = new Database(act);
							    	sqdb = d.getWritableDatabase();
							    	sqdb.execSQL("insert into cart values('"+Login.uname+"','"+id+"','"+name+"','"+Types+"','"+price+"','"+Qty+"','"+grossamt+"')");
							    	sqdb.close();
							    }
							    catch (Exception e) {
							    	e.printStackTrace();
								}
								Toast.makeText(getActivity(), "Added to cart"+name+":"+price+":"+Types, Toast.LENGTH_LONG).show();
								in = new Intent(act,Cart.class);
								startActivity(in);
								break;
					}	
		else{
			Toast.makeText(getActivity(), "Please Login First:", Toast.LENGTH_LONG).show();
			in = new Intent(act,Login.class);
			startActivity(in);
		}
		default:break;
		}
	}
}