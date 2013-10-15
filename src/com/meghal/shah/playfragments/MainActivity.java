package com.meghal.shah.playfragments;

import com.example.playfragments.R;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		CustomListFragment newFragment = new CustomListFragment();
		FragmentTransaction transaction = getFragmentManager().beginTransaction();

		// Replace whatever is in the fragment_container view with this fragment,
		// and add the transaction to the back stack so the user can navigate back
		transaction.replace(R.id.fragment_container, newFragment);
//		transaction.addToBackStack(null);

		// Commit the transaction
		transaction.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private SecondFragment mSecondFragment;
	
	public void setSecondFragment(SecondFragment mSecondFragment){
		this.mSecondFragment = mSecondFragment;
	}
	
	public void minimizeSecondFragment(){
		Log.i("", "minimize");
		FrameLayout secondFrameLayout = (FrameLayout) findViewById(R.id.fragment_container2);
		ViewGroup.LayoutParams params = secondFrameLayout.getLayoutParams();
		params.height = 640;
		params.width = 360;
		secondFrameLayout.setLayoutParams(params);		
	}
	
	public void maximizeSecondFragment(){
		Log.i("", "maximize");
		FrameLayout secondFrameLayout = (FrameLayout) findViewById(R.id.fragment_container2);
		ViewGroup.LayoutParams params = secondFrameLayout.getLayoutParams();
		params.height = LayoutParams.MATCH_PARENT;
		params.width = LayoutParams.MATCH_PARENT;
		secondFrameLayout.setLayoutParams(params);	
	}
	

}
