package com.example.connoisseur;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class OrderChoice extends Dialog implements OnClickListener{
	public Activity ac;
	public Dialog d;
	public Button order,browse;
	public OrderChoice(Activity ac) {
		super(ac);
		this.ac = ac;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_order_choice);
		
		order =(Button) findViewById(R.id.btn_yes);
		browse =(Button) findViewById(R.id.btn_no);
		order.setOnClickListener(this);
		browse.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
	    case R.id.btn_yes:
	    	Intent in = new Intent(getContext(),Pizza.class);
	    	ac.startActivity(in);
	    	break;
	    case R.id.btn_no:
	      dismiss();
	      break;
	    default:
	      break;
		}
		dismiss();
	}
}
