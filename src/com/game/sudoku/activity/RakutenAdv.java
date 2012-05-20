package com.game.sudoku.activity;

import com.game.sudoku.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class RakutenAdv extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void gotoTravel(View view){
    	Uri uri=Uri.parse("http://travel.rakuten.co.jp");
    	Intent intent=new Intent(Intent.ACTION_VIEW,uri);
    	startActivity(intent);
    }
    public void gotoIchiba(View view){
    	Uri uri=Uri.parse("http://www.rakuten.co.jp");
    	Intent intent=new Intent(Intent.ACTION_VIEW,uri);
    	startActivity(intent);
    }
    public void gotoRanking(View view){
    	Uri uri=Uri.parse("http://ranking.rakuten.co.jp");
    	Intent intent=new Intent(Intent.ACTION_VIEW,uri);
    	startActivity(intent);
    }
    public void gotoAuction(View view){
    	Uri uri=Uri.parse("http://auction.rakuten.co.jp");
    	Intent intent=new Intent(Intent.ACTION_VIEW,uri);
    	startActivity(intent);
    }
    public void gotoShashinkan(View view){
    	Uri uri=Uri.parse("http://shashinkan.rakuten.co.jp");
    	Intent intent=new Intent(Intent.ACTION_VIEW,uri);
    	startActivity(intent);
    }

    public void gotoIspeed(View view){
    	Uri uri=Uri.parse("http://ispeed.jp");
    	Intent intent=new Intent(Intent.ACTION_VIEW,uri);
    	startActivity(intent);
    }

    public void gotoBooks(View view){
    	Uri uri=Uri.parse("http://books.rakuten.co.jp");
    	Intent intent=new Intent(Intent.ACTION_VIEW,uri);
    	startActivity(intent);
    }
    public void gotoCard(View view){
    	Uri uri=Uri.parse("http://card.rakuten.co.jp");
    	Intent intent=new Intent(Intent.ACTION_VIEW,uri);
    	startActivity(intent);
    }



}