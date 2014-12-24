package com.uwais.Tap_Race;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TapRaceActivity extends Activity {

    private TextView tvCount, tvTimer;
    private RelativeLayout rlMain;
    private Context context;
    private TimeLimitedTapGame newGame;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tap_activity);
	context = this;
	tvCount = (TextView) findViewById(R.id.tvCount);
	tvTimer = (TextView) findViewById(R.id.tvTimer);
	rlMain = (RelativeLayout) findViewById(R.id.rlMain);
	newGame = new TimeLimitedTapGame(context, tvCount,
		Constants.TEN_SECONDS_LIMIT_IN_MILLS, tvTimer);
	rlMain.setOnClickListener(new OnClickListener() {

	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		newGame.updateCounter();
	    }

	});
	rlMain.setOnLongClickListener(new OnLongClickListener() {

	    @Override
	    public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		newGame.resetCounter();
		return true;
	    }

	});
	
	if (newGame.getGameCode() == 0){
	    CountDownTimer cdt = newGame.getCountDownTimer().start();
	}
    }
}