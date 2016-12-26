package com.example.connoisseur;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adminfrag2 extends Fragment{
	
	Database d;
	SQLiteDatabase sqdb;
	Button b,b1;
	Activity act;
	EditText et,et1,et2;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_adminfrag2, container,false);
 	}
	@Override
	public void onStart() {
		act = getActivity();
		b = (Button)act.findViewById(R.id.addpromo);
		b1 = (Button)act.findViewById(R.id.DeletePromo);
		et = (EditText)act.findViewById(R.id.pid);
		et1 = (EditText)act.findViewById(R.id.pmsg);
		et2 = (EditText)act.findViewById(R.id.pcode);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(et.getText()!=null&&et1.getText()!=null&&et2.getText()!=null){
					try{
					d = new Database(act);
					sqdb = d.getWritableDatabase();
					sqdb.execSQL("insert into offers values('"+et.getText()+"','"+et1.getText()+"','"+et2.getText()+"')");
					sqdb.close();
				}catch(Exception e){
					Toast.makeText(getActivity(), e.getMessage()+"", Toast.LENGTH_LONG).show();
				}}else{
					Toast.makeText(getActivity(),"Incorrect details!!", Toast.LENGTH_LONG).show();
				}
			}
		});
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				try{
					Database d = new Database(act);
					sqdb = d.getWritableDatabase();
					sqdb.execSQL("delete from offers where promoid = '"+et.getText()+"'");
					sqdb.close();
				}catch(Exception e){
					Toast.makeText(getActivity(), e.getMessage()+"", Toast.LENGTH_LONG).show();
				}
			}
		});
		super.onStart();
	}
}