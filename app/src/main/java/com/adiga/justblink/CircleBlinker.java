package com.adiga.justblink;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

public class CircleBlinker extends ActionBarActivity {
    private Handler handleTimer = new Handler();
    private int blinkerType = 3;
    //private int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_blinker);

        final View contentView = findViewById(R.id.FrLay);

        handleTimer.post(threeBlinkers);
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView iv1 = (ImageView) findViewById(R.id.imageView);
                ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
                ImageView iv3 = (ImageView) findViewById(R.id.imageView3);
                iv1.setVisibility(View.INVISIBLE);
                iv2.setVisibility(View.INVISIBLE);
                iv3.setVisibility(View.INVISIBLE);
                if (blinkerType == 3) {
                    //setBlinkerSize((int)(size * 1.5));
                    handleTimer.removeCallbacks(threeBlinkers);
                    handleTimer.postDelayed(twoBlinkers, 300);
                    blinkerType = 2;
                } else if (blinkerType == 2) {
                    //setBlinkerSize(size);
                    handleTimer.removeCallbacks(twoBlinkers);
                    handleTimer.postDelayed(oneBlinker, 300);
                    blinkerType = 1;
                } else {
                    //setBlinkerSize(size);
                    handleTimer.removeCallbacks(oneBlinker);
                    handleTimer.postDelayed(threeBlinkers, 300);
                    blinkerType = 3;
                }
            }
        });
    }

    /*
        private void setBlinkerSize(int size) {
            Log.v("Setting size", "" + size);
            ImageView iv1 = (ImageView) findViewById(R.id.imageView);
            ImageView iv2 = (ImageView) findViewById(R.id.imageView);
            ImageView iv3 = (ImageView) findViewById(R.id.imageView3);

            iv1.setVisibility(View.INVISIBLE);
            iv2.setVisibility(View.INVISIBLE);
            iv3.setVisibility(View.INVISIBLE);
            iv1.getLayoutParams().height = size;
            iv1.getLayoutParams().width = size;
            iv3.getLayoutParams().height = size;
            iv3.getLayoutParams().width = size;
            iv1.requestLayout();
            iv3.requestLayout();
        }
    */
    private Runnable oneBlinker = new Runnable() {

        public void run() {
            ImageView iv1 = (ImageView) findViewById(R.id.imageView);
            ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
            ImageView iv3 = (ImageView) findViewById(R.id.imageView3);

            if (iv2.getVisibility() == View.INVISIBLE) {
                iv1.setVisibility(View.INVISIBLE);
                iv2.setVisibility(View.VISIBLE);
                iv3.setVisibility(View.INVISIBLE);
            } else {
                iv1.setVisibility(View.INVISIBLE);
                iv2.setVisibility(View.INVISIBLE);
                iv3.setVisibility(View.INVISIBLE);
            }
            handleTimer.postDelayed(oneBlinker, 300);
        }
    };

    private Runnable twoBlinkers = new Runnable() {

        public void run() {
            ImageView iv1 = (ImageView) findViewById(R.id.imageView);
            ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
            ImageView iv3 = (ImageView) findViewById(R.id.imageView3);

            if (iv1.getVisibility() == View.VISIBLE) {
                iv1.setVisibility(View.INVISIBLE);
                iv2.setVisibility(View.INVISIBLE);
                iv3.setVisibility(View.VISIBLE);
            } else {
                iv1.setVisibility(View.VISIBLE);
                iv2.setVisibility(View.INVISIBLE);
                iv3.setVisibility(View.INVISIBLE);
            }
            handleTimer.postDelayed(twoBlinkers, 300);
        }
    };

    private Runnable threeBlinkers = new Runnable() {

        public void run() {
            ImageView iv1 = (ImageView) findViewById(R.id.imageView);
            ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
            ImageView iv3 = (ImageView) findViewById(R.id.imageView3);

            if (iv1.getVisibility() == View.VISIBLE) {
                iv1.setVisibility(View.INVISIBLE);
                iv2.setVisibility(View.INVISIBLE);
                iv3.setVisibility(View.INVISIBLE);
            } else {
                iv1.setVisibility(View.VISIBLE);
                iv2.setVisibility(View.VISIBLE);
                iv3.setVisibility(View.VISIBLE);
            }
            handleTimer.postDelayed(threeBlinkers, 300);
        }
    };
}
