package com.adiga.justblink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class BlinkerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blinker);
        Toast t = Toast.makeText(BlinkerActivity.this, R.string.tap_msg,
                Toast.LENGTH_SHORT);
        t.show();
    }

    public void startClick(View v) {
        Intent in = new Intent(this, CircleBlinker.class);
        startActivity(in);
        finish();
    }
}
