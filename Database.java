package com.example.connoisseur;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper{

	public Database(Context context) {
		super(context, "Connoisseur", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase sq) {
		sq.execSQL("create table userinfo(uname string primary key,fname string,lname string,mail string,upass string,conpass string,dob string,mob string)");
		sq.execSQL("create table details(uname string primary key,address string,prevorder string,feedback blob,userrate string)");
		sq.execSQL("create table cart(uname string,itemid int,itemname string,itemtype string,price int,quantity int,grossamt int)");
		sq.execSQL("create table billing(orderno int,uname string,grossamt int,taxes double,promocode string,payableamt int)");
		sq.execSQL("create table offers(promoid int primary key,promomsg string,promocode string)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase sq, int arg1, int arg2) {
		onCreate(sq);
	}
	
}
