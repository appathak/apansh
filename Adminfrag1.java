package com.example.connoisseur;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Adminfrag1 extends Fragment{
	Activity act;
	Database d;
	SQLiteDatabase sqdb;
	Button b;
	TextView tv,tv1,tv2,tv3,tv4;
	EditText et;
	Cursor cr;
	Spinner sp;
	ArrayList<String> al;
	String name;
	ArrayAdapter<String> ad;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_adminfrag1, container,false);
	}
	@Override
	public void onStart() {
		act = getActivity();
		tv = (TextView)act.findViewById(R.id.f);
		tv1 = (TextView)act.findViewById(R.id.Mail);
		tv2 = (TextView)act.findViewById(R.id.adpass);
		tv3 = (TextView)act.findViewById(R.id.adob);
		tv4 = (TextView)act.findViewById(R.id.adph);
		sp = (Spinner)act.findViewById(R.id.detailspin);
		al = new ArrayList<String>();
		al.add("Select uname");
		try{
			d = new Database(act);
			sqdb = d.getReadableDatabase();
			cr = sqdb.rawQuery("select uname from userinfo", null);
			while(!cr.isLast()){
				cr.moveToNext();
				al.add(cr.getString(0));
			}
		}catch(Exception e){
			Toast.makeText(act,"No User Exist!!", Toast.LENGTH_LONG).show();
		}
		ad = new ArrayAdapter<String>(act ,android.R.layout.simple_spinner_item, al);
		sp.setAdapter(ad);
		
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> list, View arg1,
					int position, long arg3) {
				try{
					String a = list.getItemAtPosition(position).toString();
					if(a.equalsIgnoreCase("Select uname")){
						
					}
					else{
					d = new Database(act);
					sqdb = d.getReadableDatabase();
					cr = sqdb.rawQuery("select * from userinfo where uname = '"+a+"'", null);
					while(!cr.isLast()){
						cr.moveToNext();
						tv.setText(cr.getString(1)+" "+cr.getString(2));
						tv1.setText(cr.getString(3));
						tv2.setText(cr.getString(4));
						tv3.setText(cr.getString(6));
						tv4.setText(cr.getString(7));
					}}
				
				}catch(Exception e){
					Toast.makeText(act,"No User Exist!!", Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {}
		});
		
		super.onStart();
	}
}