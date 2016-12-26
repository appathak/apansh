package com.example.connoisseur;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PizzaFragment1 extends Fragment{
	Activity act;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_pizza_fragment1, container, false);
	}
	
	@Override
	public void onStart() {
		act = getActivity();
		super.onStart();
	}
}
