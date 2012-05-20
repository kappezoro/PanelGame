package com.game.sudoku.activity;

import java.util.Timer;

import java.util.TimerTask;

import com.game.sudoku.sound.AudioSignal;
import com.game.sudoku.R;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioTrack;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class SudokuActivity extends Activity {

/*ダイアルボタン用
	 private ToggleButton numOne;
	 private ToggleButton numTwo;
	 private ToggleButton numThree;
	 private ToggleButton numFour;
	 private ToggleButton numFive;
	 private ToggleButton numSix;
	 private ToggleButton numSeven;
	 private ToggleButton numEight;
	 private ToggleButton numNine;
*/

	/*
	 * 音声データ
	 */
    private byte[] c5;
    private byte[] d5;
    private byte[] e5;
    private byte[] f5;
    private byte[] g5;
    private byte[] a5;
    private byte[] b5;
    private byte[] c6;

    /*
     * サンプルレート
     */
    private static int SAMPLE_RATE = 44100; //44.1KH 44100
    //AudioTrack
    private AudioTrack track;


    /*
     * パネルの色指定フラグ
     * 初期値0を指定
     * 0の場合は黒、1の場合は緑
     */
	int flg11 = 0;int flg12 = 0;int flg13 = 0;int flg14 = 0;int flg15 = 0;
	int flg16 = 0;int flg17 = 0;int flg18 = 0;int flg19 = 0;
	int flg21 = 0;int flg22 = 0;int flg23 = 0;int flg24 = 0;int flg25 = 0;
	int flg26 = 0;int flg27 = 0;int flg28 = 0;int flg29 = 0;
	int flg31 = 0;int flg32 = 0;int flg33 = 0;int flg34 = 0;int flg35 = 0;
	int flg36 = 0;int flg37 = 0;int flg38 = 0;int flg39 = 0;
	int flg41 = 0;int flg42 = 0;int flg43 = 0;int flg44 = 0;int flg45 = 0;
	int flg46 = 0;int flg47 = 0;int flg48 = 0;int flg49 = 0;
	int flg51 = 0;int flg52 = 0;int flg53 = 0;int flg54 = 0;int flg55 = 0;
	int flg56 = 0;int flg57 = 0;int flg58 = 0;int flg59 = 0;
	int flg61 = 0;int flg62 = 0;int flg63 = 0;int flg64 = 0;int flg65 = 0;
	int flg66 = 0;int flg67 = 0;int flg68 = 0;int flg69 = 0;
	int flg71 = 0;int flg72 = 0;int flg73 = 0;int flg74 = 0;int flg75 = 0;
	int flg76 = 0;int flg77 = 0;int flg78 = 0;int flg79 = 0;
	int flg81 = 0;int flg82 = 0;int flg83 = 0;int flg84 = 0;int flg85 = 0;
	int flg86 = 0;int flg87 = 0;int flg88 = 0;int flg89 = 0;
	int flg91 = 0;int flg92 = 0;int flg93 = 0;int flg94 = 0;int flg95 = 0;
	int flg96 = 0;int flg97 = 0;int flg98 = 0;int flg99 = 0;

	int total = flg11 + flg12 + flg13 + flg14 + flg15 +
 flg16 + flg17 + flg18 + flg19 +
 flg21 + flg22 + flg23 + flg24 + flg25 +
 flg26 + flg27 + flg28 + flg29 +
 flg31 + flg32 + flg33 + flg34 + flg35 +
 flg36 + flg37 + flg38 + flg39 +
 flg41 + flg42 + flg43 + flg44 + flg45 +
 flg46 + flg47 + flg48 + flg49 +
 flg51 + flg52 + flg53 + flg54 + flg55 +
 flg56 + flg57 + flg58 + flg59 +
 flg61 + flg62 + flg63 + flg64 + flg65 +
 flg66 + flg67 + flg68 + flg69 +
 flg71 + flg72 + flg73 + flg74 + flg75 +
 flg76 + flg77 + flg78 + flg79 +
 flg81 + flg82 + flg83 + flg84 + flg85 +
 flg86 + flg87 + flg88 + flg89 +
 flg91 + flg92 + flg93 + flg94 + flg95 +
 flg96 + flg97 + flg98 + flg99;

	/*
	 * タイマー用の変数設定
	 */
	 int tickcount;
	 Timer timer = null;   //タイマを定義
	 TextView mDisplayText; //表示領域の定義

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/*ダイアルボタン用
		 numOne = (ToggleButton)findViewById(R.id.one);
		 numTwo = (ToggleButton)findViewById(R.id.two);
		 numThree = (ToggleButton)findViewById(R.id.three);
		 numFour = (ToggleButton)findViewById(R.id.four);
		 numFive = (ToggleButton)findViewById(R.id.five);
		 numSix = (ToggleButton)findViewById(R.id.six);
		 numSeven = (ToggleButton)findViewById(R.id.seven);
		 numEight = (ToggleButton)findViewById(R.id.eight);
		 numNine = (ToggleButton)findViewById(R.id.nine);
		 */


	/*
	 * タイマー機能の設定
	 * 1秒単位で動く
	 */

	 //結果の表示先を設定
	 	mDisplayText = (TextView)findViewById(R.id.time);
	 //カウント値の初期化
	 	tickcount = 16;
	 	//Timerを設定する
	 	timer = new Timer(true);
	 	final android.os.Handler handler = new android.os.Handler();
	 	timer.schedule(
	 	new TimerTask() {
		@Override
		public void run() {
			handler.post( new Runnable(){
				public void run(){
					//結果出力用のテキストボックス
						StringBuffer buff = new StringBuffer();
						buff.append("Time:");
						buff.append(tickcount);
						tickcount--;
						mDisplayText.setText(buff.toString());
						if(tickcount==0){
							Intent intent =new Intent (SudokuActivity.this,ResultActivity.class);
							intent.putExtra("Total", flg11 + flg12 + flg13 + flg14 + flg15 +
									 flg16 + flg17 + flg18 + flg19 +
									 flg21 + flg22 + flg23 + flg24 + flg25 +
									 flg26 + flg27 + flg28 + flg29 +
									 flg31 + flg32 + flg33 + flg34 + flg35 +
									 flg36 + flg37 + flg38 + flg39 +
									 flg41 + flg42 + flg43 + flg44 + flg45 +
									 flg46 + flg47 + flg48 + flg49 +
									 flg51 + flg52 + flg53 + flg54 + flg55 +
									 flg56 + flg57 + flg58 + flg59 +
									 flg61 + flg62 + flg63 + flg64 + flg65 +
									 flg66 + flg67 + flg68 + flg69 +
									 flg71 + flg72 + flg73 + flg74 + flg75 +
									 flg76 + flg77 + flg78 + flg79 +
									 flg81 + flg82 + flg83 + flg84 + flg85 +
									 flg86 + flg87 + flg88 + flg89 +
									 flg91 + flg92 + flg93 + flg94 + flg95 +
									 flg96 + flg97 + flg98 + flg99);
							intent.setAction(Intent.ACTION_VIEW);
							startActivity(intent);
						}
				}
			});
		}
	 	}, 1000, 1000);


		 //AudioTrackクラスの作成と初期化
		 AudioSignal audioSignal = new AudioSignal(SAMPLE_RATE,SAMPLE_RATE);
	     track = audioSignal.getAudioTrack();

	     //音声データ作成
	        c5 = audioSignal.getSquareWave(AudioSignal.FREQUENCY_C5);
	        d5 = audioSignal.getSquareWave(AudioSignal.FREQUENCY_D5);
	        e5 = audioSignal.getSquareWave(AudioSignal.FREQUENCY_E5);
	        f5 = audioSignal.getSquareWave(AudioSignal.FREQUENCY_F5);
	        g5 = audioSignal.getSquareWave(AudioSignal.FREQUENCY_G5);
	        a5 = audioSignal.getSquareWave(AudioSignal.FREQUENCY_A5);
	        b5 = audioSignal.getSquareWave(AudioSignal.FREQUENCY_B5);
	        c6 = audioSignal.getSquareWave(AudioSignal.FREQUENCY_C6);

	     //タイマー機能
	        Timer mTimer = new Timer();

	        if(track.getPlayState()==AudioTrack.PLAYSTATE_PLAYING){
	            track.stop();
	            track.reloadStaticData();
	        }
	            track.write(c5, 0, c5.length);
	            track.write(d5, 0, d5.length);
	            track.write(e5, 0, e5.length);
	            track.write(f5, 0, f5.length);
	            track.write(g5, 0, g5.length);
	            track.write(a5, 0, a5.length);
	            track.write(b5, 0, b5.length);
	            track.write(c6, 0, c6.length);
	            track.play();
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line11(View view) {
		switch (flg11) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg11 = 1;
		      if(track.getPlayState()==AudioTrack.PLAYSTATE_PLAYING){
		            track.stop();
		            track.reloadStaticData();
		        }
		      track.write(c5, 0, c5.length);
		      track.play();
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg11 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line12(View view) {
		switch (flg12) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg12 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg12 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line13(View view) {
		switch (flg13) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg13 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg13 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line14(View view) {
		switch (flg14) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg14 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg14 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line15(View view) {
		switch (flg15) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg15 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg15 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line16(View view) {
		switch (flg16) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg16 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg16 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line17(View view) {
		switch (flg17) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg17 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg17 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line18(View view) {
		switch (flg18) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg18 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg18 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line19(View view) {
		switch (flg19) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg19 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg19 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line21(View view) {
		switch (flg21) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg21 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg21 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line22(View view) {
		switch (flg22) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg22 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg22 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line23(View view) {
		switch (flg23) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg23 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg23 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line24(View view) {
		switch (flg24) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg24 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg24 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line25(View view) {
		switch (flg25) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg25 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg25 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line26(View view) {
		switch (flg26) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg26 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg26 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line27(View view) {
		switch (flg27) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg27 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg27 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line28(View view) {
		switch (flg28) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg28 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg28 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line29(View view) {
		switch (flg29) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg29 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg29 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line31(View view) {
		switch (flg31) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg31 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg31 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line32(View view) {
		switch (flg32) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg32 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg32 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line33(View view) {
		switch (flg33) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg33 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg33 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line34(View view) {
		switch (flg34) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg34 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg34 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line35(View view) {
		switch (flg35) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg35 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg35 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line36(View view) {
		switch (flg36) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg36 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg36 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line37(View view) {
		switch (flg37) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg37 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg37 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line38(View view) {
		switch (flg38) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg38 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg38 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line39(View view) {
		switch (flg39) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg39 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg39 = 0;
			break;
		}
	}	/*
	 * パネルごとのアクション指定
	 */
	public void line41(View view) {
		switch (flg41) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg41 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg41 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line42(View view) {
		switch (flg42) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg42 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg42 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line43(View view) {
		switch (flg43) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg43 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg43 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line44(View view) {
		switch (flg44) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg44 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg44 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line45(View view) {
		switch (flg45) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg45 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg45 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line46(View view) {
		switch (flg46) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg46 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg46 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line47(View view) {
		switch (flg47) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg47 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg47 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line48(View view) {
		switch (flg48) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg48 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg48 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line49(View view) {
		switch (flg49) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg49 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg49 = 0;
			break;
		}
	}	/*
	 * パネルごとのアクション指定
	 */
	public void line51(View view) {
		switch (flg51) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg51 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg51 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line52(View view) {
		switch (flg52) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg52 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg52 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line53(View view) {
		switch (flg53) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg53 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg53 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line54(View view) {
		switch (flg54) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg54 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg54 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line55(View view) {
		switch (flg55) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg55 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg55 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line56(View view) {
		switch (flg56) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg56 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg56 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line57(View view) {
		switch (flg57) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg57 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg57 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line58(View view) {
		switch (flg58) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg58 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg58 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line59(View view) {
		switch (flg59) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg59 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg59 = 0;
			break;
		}
	}	/*
	 * パネルごとのアクション指定
	 */
	public void line61(View view) {
		switch (flg61) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg61 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg61 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line62(View view) {
		switch (flg62) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg62 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg62 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line63(View view) {
		switch (flg63) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg63 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg63 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line64(View view) {
		switch (flg64) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg64 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg64 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line65(View view) {
		switch (flg65) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg65 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg65 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line66(View view) {
		switch (flg66) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg66 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg66 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line67(View view) {
		switch (flg67) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg67 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg67 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line68(View view) {
		switch (flg68) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg68 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg68 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line69(View view) {
		switch (flg69) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg69 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg69 = 0;
			break;
		}
	}	/*
	 * パネルごとのアクション指定
	 */
	public void line71(View view) {
		switch (flg71) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg71 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg71 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line72(View view) {
		switch (flg72) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg72 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg72 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line73(View view) {
		switch (flg73) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg73 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg73 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line74(View view) {
		switch (flg74) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg74 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg74 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line75(View view) {
		switch (flg75) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg75 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg75 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line76(View view) {
		switch (flg76) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg76 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg76 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line77(View view) {
		switch (flg77) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg77 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg77 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line78(View view) {
		switch (flg78) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg78 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg78 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line79(View view) {
		switch (flg79) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg79 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg79 = 0;
			break;
		}
	}	/*
	 * パネルごとのアクション指定
	 */
	public void line81(View view) {
		switch (flg81) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg81 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg81 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line82(View view) {
		switch (flg82) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg82 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg82 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line83(View view) {
		switch (flg83) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg83 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg83 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line84(View view) {
		switch (flg84) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg84 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg84 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line85(View view) {
		switch (flg85) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg85 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg85 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line86(View view) {
		switch (flg86) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg86 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg86 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line87(View view) {
		switch (flg87) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg87 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg87 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line88(View view) {
		switch (flg88) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg88 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg88 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line89(View view) {
		switch (flg89) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg89 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg89 = 0;
			break;
		}
	}	/*
	 * パネルごとのアクション指定
	 */
	public void line91(View view) {
		switch (flg91) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg91 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg91 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line92(View view) {
		switch (flg92) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg92 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg92 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line93(View view) {
		switch (flg93) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg93 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg93 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line94(View view) {
		switch (flg94) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg94 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg94 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line95(View view) {
		switch (flg95) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg95 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg95 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line96(View view) {
		switch (flg96) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg96 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg96 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line97(View view) {
		switch (flg97) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg97 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg97 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line98(View view) {
		switch (flg98) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg98 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg98 = 0;
			break;
		}
	}

	/*
	 * パネルごとのアクション指定
	 */
	public void line99(View view) {
		switch (flg99) {
		case (0):
			view.setBackgroundColor(0xff00ff00);
			flg99 = 1;
			break;
		case (1):
			view.setBackgroundColor(0xff000000);
			flg99 = 0;
			break;
		}
	}
}