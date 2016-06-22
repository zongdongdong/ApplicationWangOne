package com.uni.applicationwangone.ui.NewFragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.okhttp.Request;
import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.OnRequestCallback;
import com.uni.applicationwangone.data.model.SMSBean;
import com.uni.applicationwangone.data.model.SMSDataResponse;
import com.uni.applicationwangone.data.model.SpinnerBean;
import com.uni.applicationwangone.data.model.SpinnerDataResponse;
import com.uni.applicationwangone.ui.AppConstant;
import com.uni.applicationwangone.ui.activity.BaseActivity;
import com.uni.applicationwangone.ui.adapter.FileAdapter;
import com.uni.applicationwangone.ui.adapter.SpinnerAdapter;
import com.uni.applicationwangone.ui.fragments.BaseFragment;
import com.uni.applicationwangone.ui.util.JSONUtils;
import com.uni.applicationwangone.ui.util.MUtils;
import com.uni.applicationwangone.ui.util.UIHelper;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 说明书
 */
public class ReadFragment extends BaseFragment {
    @Bind(R.id.txtvTitle)
    TextView txtvTitle;
    @Bind(R.id.spinner)
    Spinner spinner;
    @Bind(R.id.listview)
    ListView listview;
    private FileAdapter fileAdapter;

    private SpinnerAdapter adapter;
    private View mRootView;
    private List<SpinnerBean> spinnerBeanList;
    private String currentCompanyId = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_read, container, false);
        ButterKnife.bind(this, mRootView);
        setViews();
        setClickListeners();
        loadSpinnerList();
        return mRootView;
    }

    public void setViews() {
        txtvTitle.setText("说明书搜索");
        adapter = new SpinnerAdapter();
        spinner.setAdapter(adapter);
        fileAdapter = new FileAdapter();
        listview.setAdapter(fileAdapter);
    }

    public void setClickListeners(){

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SpinnerBean spinnerBean = (SpinnerBean) adapter.getItem(i);
                if(spinnerBean!=null&& !currentCompanyId.equals(spinnerBean._id)){
                    currentCompanyId = spinnerBean._id;
                    fileAdapter.clear();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final SMSBean smsBean = (SMSBean)fileAdapter.getItem(i);
                final File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+smsBean.sms);
                if(file.exists()){
                    AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());  //先得到构造器
                    builder.setTitle("提示"); //设置标题
                    builder.setMessage("是否打开此文件?"); //设置内容
                    builder.setPositiveButton("打开", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = MUtils.openFile(file.getAbsolutePath());
                            startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("取消", null);
                    builder.create().show();
                }else{
                    AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());  //先得到构造器
                    builder.setTitle("提示"); //设置标题
                    builder.setMessage("是否下载此文件?"); //设置内容
                    builder.setPositiveButton("下载", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            downLoadFile(smsBean.url,smsBean.sms);
                        }
                    });
                    builder.setNegativeButton("取消", null);
                    builder.create().show();
                }
            }
        });
    }

    @OnClick(R.id.txtvLeft)
    public void onBack(View view) {
        ((BaseActivity) getActivity()).onBackPressed();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btnSearch)
    public void onSearch(View view) {
        if(TextUtils.isEmpty(currentCompanyId)){
            UIHelper.showToast(getActivity(),"请选择厂家");
            return;
        }
        OkHttpUtils.get()
                .url(AppConstant.Host+"/app/sms/query")
                .addParams("cj",currentCompanyId)
                .build()
                .execute(new OnRequestCallback(getActivity(),true,"正在查询...") {
                    @Override
                    public void onError(Request request, Exception e) {
                        UIHelper.showToast(getActivity(),"查询失败，请稍后重新查询...");
                    }

                    @Override
                    public void onResponse(String response) {
                        Log.i("Response:",response);
                        SMSDataResponse smsDataResponse = JSONUtils.fromJson(response,SMSDataResponse.class);
                        if(smsDataResponse!=null&&smsDataResponse.data!=null&&smsDataResponse.data.size()>0){
                            fileAdapter.refreshData(smsDataResponse.data);
                        }else{
                            UIHelper.showToast(getActivity(),"未搜索到相关内容");
                        }
                    }
                });
    }

    public void loadSpinnerList(){
        OkHttpUtils.get()
                .url(AppConstant.Host+"/app/cj/list")
                .build()
                .execute(new OnRequestCallback(getActivity(),true,"数据加载中...") {
                    @Override
                    public void onError(Request request, Exception e) {
                        UIHelper.showToast(getActivity(),"数据加载失败...");
                    }

                    @Override
                    public void onResponse(String response) {
                        Log.i("Resonse:",response);
                        SpinnerDataResponse spinnerDataResponse = JSONUtils.fromJson(response,SpinnerDataResponse.class);
                        if(spinnerDataResponse!=null&&spinnerDataResponse.data!=null){
                            spinnerBeanList = spinnerDataResponse.data;
                            spinnerBeanList.add(0,new SpinnerBean("","请选择"));
                            adapter.refreshData(spinnerBeanList);
                        }else{
                            UIHelper.showToast(getActivity(),"数据加载失败...");
                        }
                    }
                });
    }

    public void downLoadFile(String url,String name){
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), name) {
                    @Override
                    public void onBefore(Request request) {
                        super.onBefore(request);
                        showProgressDialog();
                    }

                    @Override
                    public void inProgress(float progress) {
                        if(progressBar!=null){
                            progressBar.setProgress((int) (100 * progress));
                        }
                        if(txtvProgress!=null){
                            txtvProgress.setText((int) (100 * progress)+"%");
                        }
                    }

                    @Override
                    public void onAfter() {
                        super.onAfter();
                        cancelProgressDialog();
                    }

                    @Override
                    public void onError(Request request, Exception e) {
                        cancelProgressDialog();
                    }

                    @Override
                    public void onResponse(final File file) {
                        Log.e("filePath", ":" + file.getAbsolutePath());
                        cancelProgressDialog();
                        UIHelper.showToast(getActivity(),"下载成功");
                        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());  //先得到构造器
                        builder.setTitle("提示"); //设置标题
                        builder.setMessage("是否打开此文件?"); //设置内容
                        builder.setPositiveButton("打开", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = MUtils.openFile(file.getAbsolutePath());
                                startActivity(intent);
                            }
                        });
                        builder.setNegativeButton("取消", null);
                        builder.create().show();
                    }
                });
    }

    private AlertDialog progressDialog = null;
    private ProgressBar progressBar;
    private TextView txtvProgress;
    public void showProgressDialog(){
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_progress_view,null);
        progressBar = (ProgressBar)view.findViewById(R.id.progressbar);
        txtvProgress = (TextView)view.findViewById(R.id.txtvProgress);
        progressBar.setProgress(0);
        txtvProgress.setText(0+"%");
        if(progressDialog == null){
            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            builder.setTitle("正在下载...");
            builder.setView(view);
            progressDialog = builder.create();
        }
        progressDialog.cancel();
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void cancelProgressDialog(){
        if(progressDialog!=null&&progressDialog.isShowing()){
            progressDialog.cancel();
        }
    }
}
