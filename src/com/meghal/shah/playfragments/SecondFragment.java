package com.meghal.shah.playfragments;

import com.example.playfragments.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;

public class SecondFragment extends Fragment implements OnTouchListener{
	 static final int MIN_DISTANCE = 100;
	 private float downX, downY, upX, upY;
	 private final GestureDetector gestureDetector = new GestureDetector(new GestureListener());
	 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_two,
				container, false);
		rootView.setOnTouchListener(this);
		
		return rootView;
	}

	boolean maximized = true;
	
	@Override
	public boolean onTouch(View v,final MotionEvent event) {
        return (gestureDetector).onTouchEvent(event);
        /*
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN: {
			downX = event.getX();
			downY = event.getY();
			//   return true;
		}
		case MotionEvent.ACTION_UP: {
			upX = event.getX();
			upY = event.getY();

			float deltaX = downX - upX;
			float deltaY = downY - upY;
			Log.i("", ""+upX+", "+downX+" , "+upY+" , "+downY);
			// swipe horizontal?
			if(Math.abs(deltaX) > MIN_DISTANCE){
				// left or right
				if(deltaX < 0) { this.onLeftToRightSwipe(); return true; }
				if(deltaX > 0) { this.onRightToLeftSwipe(); return true; }
			} else { Log.i("", "Swipe was only " + Math.abs(deltaX) + " long, need at least " + MIN_DISTANCE); }

			// swipe vertical?
			if(Math.abs(deltaY) > MIN_DISTANCE){
				// top or down
				if(deltaY < 0) { this.onTopToBottomSwipe(); return true; }
				if(deltaY > 0) { this.onBottomToTopSwipe(); return true; }
			} else { Log.i("", "Swipe was only " + Math.abs(deltaX) + " long, need at least " + MIN_DISTANCE); }

			//     return true;
		}
		}
		return false;
		*/
	}


	class GestureListener extends SimpleOnGestureListener {

	        private static final int SWIPE_THRESHOLD = 100;
	        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

	        @Override
	        public boolean onDown(MotionEvent e) {
	            return true;
	        }

	        @Override
	        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
	            boolean result = false;
	            try {
	                float diffY = e2.getY() - e1.getY();
	                float diffX = e2.getX() - e1.getX();
	                if (Math.abs(diffX) > Math.abs(diffY)) {
	                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
	                        if (diffX > 0) {
	                            onLeftToRightSwipe();
	                        } else {
	                            onRightToLeftSwipe();
	                        }
	                    }
	                } else {
	                    if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
	                        if (diffY > 0) {
	                            onTopToBottomSwipe();
	                        } else {
	                            onBottomToTopSwipe();
	                        }
	                    }
	                }
	            } catch (Exception exception) {
	                exception.printStackTrace();
	            }
	            return result;
	        }
	    }

	
	public final void onRightToLeftSwipe() {
	
	}

	public void onLeftToRightSwipe(){
		
	}

	public void onTopToBottomSwipe(){
		if(maximized)
			((MainActivity)getActivity()).minimizeSecondFragment();
		else 
			((MainActivity)getActivity()).maximizeSecondFragment();
		
		maximized = !maximized;
	}

	public void onBottomToTopSwipe(){
		if(maximized)
			((MainActivity)getActivity()).minimizeSecondFragment();
		else 
			((MainActivity)getActivity()).maximizeSecondFragment();
		
		maximized = !maximized;
	}

}
