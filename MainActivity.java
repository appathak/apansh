package com.example.connoisseur;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	ProgressBar pb;
	int pbstatus=0,progresstime=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = (ProgressBar)findViewById(R.id.progressBar1);
        Thread th = new Thread(){
        	public void run(){
        		try{
        			while(pbstatus<100){
        				pbstatus++;
        				Thread.sleep(30);
        				pb.setProgress(pbstatus);
        			}
        		}
        		catch(Exception e){
        			e.printStackTrace();
        		}
                Intent in = new Intent(MainActivity.this,Home.class);
                startActivity(in);
        	}
        };
        th.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
