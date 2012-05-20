package com.game.sudoku.activity;


import com.game.sudoku.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ResultActivity extends Activity{
	@Override
	// 画面構成
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v("FLG","ResultActivity");
		setContentView(R.layout.result);
		Intent intent = getIntent();
		int total = intent.getIntExtra("Total",0);
		Toast.makeText(this, Integer.toString(total), 50).show();
		Log.v("FLG",Integer.toString(total));
	}
}
