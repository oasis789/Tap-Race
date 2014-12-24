package com.uwais.Tap_Race;

import android.content.Context;
import android.util.TypedValue;
import android.widget.TextView;

public class TapGame {

    private int count;
    private TextView tvCount;
    private float fontSize;
    private Context context;
    private boolean increase;
    private int GAME_CODE;

    public TapGame(Context context, TextView tvCount, int GAME_CODE) {
	count = 0;
	increase = true;
	this.tvCount = tvCount;
	this.context = context;
	this.GAME_CODE = GAME_CODE;
    }

    public void updateCounter() {
	count++;
	fontSize = pixelsToSp(context, tvCount.getTextSize());

	if (fontSize > 170) {
	    increase = false;
	}

	if (fontSize < 10) {
	    increase = true;
	}

	if (increase) {
	    fontSize += 5;
	} else {
	    fontSize -= 5;
	}

	tvCount.setText(Integer.toString(count));
	tvCount.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
    }

    public void resetCounter() {
	count = 0;
	fontSize = 90;
	tvCount.setText(Integer.toString(count));
	tvCount.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
    }

    public float pixelsToSp(Context context, Float px) {
	float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
	return px / scaledDensity;
    }

    public int getCounter(){
	return count;
    }
    
    public int getGameCode(){
	return GAME_CODE;
    }
}
