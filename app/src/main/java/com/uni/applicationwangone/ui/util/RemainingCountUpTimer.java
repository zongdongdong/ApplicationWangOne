package com.uni.applicationwangone.ui.util;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Dong on 2015/11/21.
 */
public class RemainingCountUpTimer extends CountDownTimer {

    private ProgressBar mPbTimer;
    private TextView mTxtvProgress;
    private Runnable mRunnable;
    private int mProgress;

    public RemainingCountUpTimer(int progress, ProgressBar pbTimer, TextView txtvProgress, Runnable runnable) {
        super(progress, 10);
        mProgress = progress;
        mTxtvProgress = txtvProgress;
        mPbTimer = pbTimer;
        mRunnable = runnable;
        mPbTimer.setProgress(0);
        mPbTimer.setMax(progress);
    }

    @Override
    public void onTick(long leftTimeInMilliseconds) {
        mTxtvProgress.setText((int)((mProgress - leftTimeInMilliseconds)* 100 / mProgress) + "%");
        mPbTimer.setProgress((int) (mProgress-leftTimeInMilliseconds));
    }

    @Override
    public void onFinish() {
        new Handler(Looper.getMainLooper()).post(mRunnable);
        this.cancel();
    }
}
