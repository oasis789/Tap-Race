package com.uwais.Tap_Race;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.widget.TextView;

public class TimeLimitedTapGame extends TapGame {

    private long timeLimit;
    private CountDownTimer cdt;
    private TextView tvTimer;
    private long timeLeft;
    private Context context;
    private TimeLimitedTapGame thisGame;

    public TimeLimitedTapGame(Context scontext, TextView tvCount,
	    long stimeLimit, TextView stvTimer) {
	super(scontext, tvCount, 0);
	thisGame = this;
	this.context = scontext;
	this.timeLimit = stimeLimit;
	this.tvTimer = stvTimer;
	cdt = new CountDownTimer(timeLimit, 10) {

	    @Override
	    public void onFinish() {
		// TODO Auto-generated method stub
		tvTimer.setText("00:00");
		final Dialog d = new AlertDialog.Builder(context)
			.setTitle("You've Tapped Out!!!")
			.setMessage(
				"You managed to tap "
					+ thisGame.getCounter()
					+ " many times!!!").setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
					    
					    @Override
					    public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						thisGame.resetCounter();
						cdt.start();
					    }
					}).setNegativeButton("Quit", new DialogInterface.OnClickListener() {
					    
					    @Override
					    public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						thisGame.resetCounter();
						((Activity) context).finish();
					    }
					}).create();
		d.show();
	    }

	    @Override
	    public void onTick(long millisUntilFinished) {
		// TODO Auto-generated method stub
		timeLeft = millisUntilFinished / 10;
		String stimeLeft = null;
		String fractionOfSecond = null;
		String seconds = null;
		stimeLeft = String.valueOf(timeLeft);
		// Greater than 10s
		if (timeLeft > 1000) {
		    fractionOfSecond = stimeLeft.substring(2);
		    seconds = stimeLeft.substring(0, 2);
		} else if (timeLeft > 100) {
		    // Greater than 1s
		    fractionOfSecond = stimeLeft.substring(1);
		    seconds = "0" + stimeLeft.substring(0, 1);
		} else if (timeLeft > 10) {
		    // Greater than 0.1s
		    fractionOfSecond = stimeLeft.substring(0);
		    seconds = "00";
		} else {
		    // Less than 0.1s
		    fractionOfSecond = "0" + stimeLeft.substring(0);
		    seconds = "00";
		}

		tvTimer.setText(seconds + ":" + fractionOfSecond);
	    }

	};
    }

    public CountDownTimer getCountDownTimer() {
	return cdt;
    }

}
