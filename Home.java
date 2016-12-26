package com.example.connoisseur;

import java.util.List;
import java.util.Locale;

import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity implements OnClickListener{
	ActionBar ac;
	static int check;
	Button b;
	TextView tv,tv1,tv2,tv3,tv4,tv5;
	ImageButton ib,ib1,ib2,ib3,ib4,ib5;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);	
		ac = getActionBar();
		ac.setHomeButtonEnabled(true);
		//ac.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#CC0400")));
		
		tv = (TextView)findViewById(R.id.textView1);
		tv1 = (TextView)findViewById(R.id.textView2);
		tv2 = (TextView)findViewById(R.id.textView3);
		tv3 = (TextView)findViewById(R.id.textView4);
		tv4 = (TextView)findViewById(R.id.textView5);
		tv5 = (TextView)findViewById(R.id.textView6);
		
		b = (Button)findViewById(R.id.signinlink);
		b.setOnClickListener(this);
		
		ib = (ImageButton)findViewById(R.id.imageButton1);
		ib.setOnClickListener(this);
		ib1 = (ImageButton)findViewById(R.id.imageButton2);
		ib1.setOnClickListener(this);
		ib2 = (ImageButton)findViewById(R.id.imageButton3);
		ib2.setOnClickListener(this);
		ib3 = (ImageButton)findViewById(R.id.imageButton4);
		ib3.setOnClickListener(this);
		ib4 = (ImageButton)findViewById(R.id.imageButton5);
		ib4.setOnClickListener(this);
		ib5 = (ImageButton)findViewById(R.id.imageButton6);
		ib5.setOnClickListener(this);
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getTitle().equals("location")){
			LocationManager man=(LocationManager)getSystemService(LOCATION_SERVICE);
			Criteria c=new Criteria();
			c.setAccuracy(Criteria.ACCURACY_MEDIUM);
			c.setBearingAccuracy(Criteria.ACCURACY_MEDIUM);
			c.setCostAllowed(false);
			
			String provider=man.getBestProvider(c, true);
			LocationProvider lprovider=man.getProvider(LocationManager.GPS_PROVIDER);
			if(lprovider!=null)
			{
				Location last=man.getLastKnownLocation(provider);
				if(last!=null)
				Toast.makeText(getBaseContext()," last "+last.getLatitude()+" "
						+last.getLongitude(),Toast.LENGTH_LONG).show();
				Geocoder gcd=new Geocoder(Home.this,Locale.getDefault());
				try
				{
					List<Address> address=gcd.getFromLocation(last.getLatitude(),last.getLongitude(), 1);
					if(address.size()>0)
					{
						Toast.makeText(Home.this,""+address.get(0).getLocality()+"\n"+address.get(0).getPostalCode()+"\n"+
								address.get(0).getAddressLine(0)+"\n"+address.get(0).getSubAdminArea()+"\n"+
								address.get(0).getSubLocality()+"\n"+address.get(0).getAdminArea()+" : ",Toast.LENGTH_LONG).show();
					}
				}
				catch(Exception e)
				{
					Toast.makeText(getBaseContext(), e.getMessage()+"",Toast.LENGTH_LONG).show();
				}
			}
		}
		if(item.getTitle().equals("Cart")){
			Intent in = new Intent(Home.this,Cart.class);
			startActivity(in);
		}
		if(item.getTitle().equals("SignIn")){
			Intent in = new Intent(Home.this,Login.class);
			startActivity(in);
		}
		if(item.getTitle().equals("Sign Out")){
			Toast.makeText(Home.this, "Succefully logged out", Toast.LENGTH_LONG).show();
			check = 0;
			Login.uname = "";
			Cart.Carts.clear();
			Intent in = new Intent(Home.this,Home.class);
			startActivity(in);
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		String str=null;
		if(check == 0){
			str = "SignIn";
		}
		else if(check < 0){
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
	public void onBackPressed() {
		
		super.onBackPressed();
	}
	@Override
	public void onClick(View v) {
		Intent in;
		switch(v.getId()){
			case R.id.signinlink:	if(check<0){
										Toast.makeText(Home.this, "Already signed in!!", Toast.LENGTH_LONG).show();
									}
									else{ 
										in = new Intent(Home.this,Login.class);
										startActivity(in);
									}
									break;
			case R.id.imageButton1:	
									OrderChoice oc=new OrderChoice(Home.this);
									oc.show();  
									break;
			case R.id.imageButton2:	in = new Intent(Home.this,Burgers.class);
									startActivity(in);
									break;
			case R.id.imageButton3:	in = new Intent(Home.this,Chicken.class);
									startActivity(in);
									break;
			case R.id.imageButton4:	in = new Intent(Home.this,Beverages.class);
									startActivity(in);
									break;
			case R.id.imageButton5:	in = new Intent(Home.this,Deserts.class);
									startActivity(in);
									break;
			case R.id.imageButton6: in = new Intent(Home.this,Combos.class);
									startActivity(in);
									break;
			default:break;
		}
	}
}
