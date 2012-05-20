package com.game.sudoku.view;

import android.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class PuzzleView extends View {

	public PuzzleView(Context context) {
		super(context);
	}

	public PuzzleView(Context context, AttributeSet attrs) {

		super(context, attrs);
	}

	public PuzzleView(Context context, AttributeSet attrs, int defStyle) {

		super(context, attrs, defStyle);
	}

	public void onDraw(Canvas canvas) {

		// 座標系がわかるような罫線を引く
		Paint paint = new Paint();
		paint.setColor(Color.argb(100, 255, 255, 255));

		Paint paint2 = new Paint();
		paint2.setColor(0xffa4c639);

		for (int y = 15; y < 600; y = y + 63) {
			if (y == 204 || y == 393) {
				canvas.drawLine(15, y, 582, y, paint2);
			} else {
				canvas.drawLine(15, y, 582, y, paint);
			}
		}
		for (int x = 15; x < 600; x = x + 63) {
			if (x == 204 || x == 393) {
				canvas.drawLine(x, 15, x, 582, paint2);
			} else {
				canvas.drawLine(x, 15, x, 582, paint);
			}
		}
	}
}
