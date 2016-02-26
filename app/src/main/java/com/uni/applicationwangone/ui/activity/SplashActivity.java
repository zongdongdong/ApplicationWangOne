package com.uni.applicationwangone.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.ui.util.MUtils;

public class SplashActivity extends Activity {

    private TextView txtvCurrentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViews();
        setViews();
    }

    private void findViews(){
        txtvCurrentTime = (TextView)findViewById(R.id.txtvCurrentTime);
    }

    private void setViews(){
        txtvCurrentTime.setText(MUtils.getCurrentTime("yyyy/MM/dd HH:mm"));
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        },3000);
    }
}
