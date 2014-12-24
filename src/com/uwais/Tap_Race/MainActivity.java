package com.uwais.Tap_Race;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
    
    private Button play, how, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
	play = (Button) findViewById(R.id.bPlay);
	how = (Button) findViewById(R.id.bHow);
	score = (Button) findViewById(R.id.bScores);
	
	play.setOnClickListener(this);
	how.setOnClickListener(this);
	score.setOnClickListener(this);
	
    }

    @Override
    public void onClick(View v) {
	// TODO Auto-generated method stub
	switch(v.getId()){
	    case R.id.bPlay:
		Intent i = new Intent(this, TapRaceActivity.class);
		startActivity(i);
		break;
	    case R.id.bHow:
		
		break;
	    case R.id.bScores:
		
		
		break;
	}
    }

    
    
}
