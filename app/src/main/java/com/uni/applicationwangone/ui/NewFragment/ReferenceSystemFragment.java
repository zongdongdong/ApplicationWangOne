package com.uni.applicationwangone.ui.NewFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.okhttp.Request;
import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.OnRequestCallback;
import com.uni.applicationwangone.data.model.ReferenceDataResponse;
import com.uni.applicationwangone.ui.AppConstant;
import com.uni.applicationwangone.ui.activity.BaseActivityActivity;
import com.uni.applicationwangone.ui.activity.NewMainActivity;
import com.uni.applicationwangone.ui.fragments.BaseFragment;
import com.uni.applicationwangone.ui.util.JSONUtils;
import com.uni.applicationwangone.ui.util.UIHelper;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 消缺参考系统
 */
public class ReferenceSystemFragment extends BaseFragment {
    @Bind(R.id.txtvTitle)
    TextView txtvTitle;
    @Bind(R.id.txtvLeft)
    TextView txtvLeft;
    @Bind(R.id.etName)
    EditText etName;
    @Bind(R.id.etType)
    EditText etType;
    @Bind(R.id.etPeriodName)
    EditText etPeriodName;
    @Bind(R.id.etDesc)
    EditText etDesc;
    private View mRootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment\
        if(mRootView == null){
            mRootView = inflater.inflate(R.layout.fragment_reference_system, container, false);
        }
        ButterKnife.bind(this, mRootView);
        txtvTitle.setText("消缺参考系统");
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.txtvLeft)
    public void onClick(View view) {
        ((BaseActivityActivity) getActivity()).onBackPressed();
    }

    @OnClick(R.id.btnSearch)
    public void onSearch(View view) {
        String name = etName.getText().toString().trim();
        String type = etType.getText().toString().trim();
        String periodName = etPeriodName.getText().toString().trim();
        String desc = etDesc.getText().toString().trim();
        OkHttpUtils.get().url(AppConstant.Host+"/app/xqck/query")
                        .addParams("bdzmc",name)
                        .addParams("jgmc",periodName)
                        .addParams("qxlx",type)
                        .addParams("qxms",desc)
                        .build()
                        .execute(new OnRequestCallback(getActivity(),true,"正在搜索，请稍等...") {
                            @Override
                            public void onError(Request request, Exception e) {
                                UIHelper.showToast(getActivity(),"搜索失败，请稍后重新搜索...");
                            }

                            @Override
                            public void onResponse(String response) {
                                Log.i("Response:",response);
                                //解析数据，传入list数据
                                ReferenceDataResponse referenceDataResponse = JSONUtils.fromJson(response,ReferenceDataResponse.class);
                                if(referenceDataResponse!=null&&referenceDataResponse.data!=null&&referenceDataResponse.data.size()>0){
                                    ((NewMainActivity)getActivity()).goReferenceResult(referenceDataResponse.data);
                                }else{
                                    UIHelper.showToast(getActivity(),"未搜索到相关内容");
                                }
                            }
                        });
    }
}
