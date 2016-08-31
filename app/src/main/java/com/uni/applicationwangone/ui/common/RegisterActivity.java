package com.uni.applicationwangone.ui.common;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.ui.activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @Bind(R.id.etAcount)
    EditText etAcount;
    @Bind(R.id.etPassword)
    EditText etPassword;
    @Bind(R.id.etRePassword)
    EditText etRePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.imgvBack, R.id.btnRegister})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgvBack:
                finish();
                break;
            case R.id.btnRegister:
                break;
        }
    }
}
