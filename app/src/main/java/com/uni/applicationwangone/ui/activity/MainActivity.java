package com.uni.applicationwangone.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.DataProvider;
import com.uni.applicationwangone.ui.dialog.ListPop;
import com.uni.applicationwangone.ui.fragments.BaseFragment;
import com.uni.applicationwangone.ui.fragments.DeviceNumberFragment;
import com.uni.applicationwangone.ui.fragments.DingZhiQuHaoFragment;
import com.uni.applicationwangone.ui.fragments.NetPortSettingFragment;
import com.uni.applicationwangone.ui.fragments.SettingViewPagerFragment;
import com.uni.applicationwangone.ui.fragments.PasswordFragment;
import com.uni.applicationwangone.ui.fragments.ShuZhiXingDingZhiFragment;
import com.uni.applicationwangone.ui.fragments.ThreeButtonDialogFragment;
import com.uni.applicationwangone.ui.fragments.TimeSettingFragment;
import com.uni.applicationwangone.ui.fragments.TwoButtonDialogFragment;
import com.uni.applicationwangone.ui.fragments.ViewPagerFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private DataProvider mDataProvider;
    private Button btnTop,btnBottom,btnLeft,btnRight,btnCancel,btnConfirm;
    private TextView txtvLook,txtvSetting,txtvPreSetting,txtvPrint,txtvDesc;
    private int MenuIndex = 0;
    private ListPop firstLevelPop = null;
    private int FirstLevelMenuIndex = -1;

    private ListPop secondLevelPop = null;
    private int SecondLevelMenuIndex = -1;

    private ListPop thirdLevelPop = null;
    private int ThirdLevelMenuIndex = -1;

    private int FragmentIndex = -1;

    private BaseFragment baseFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDataProvider = DataProvider.getInstance(this);

        txtvLook = (TextView)findViewById(R.id.txtvLook);
        txtvSetting = (TextView)findViewById(R.id.txtvSetting);
        txtvPreSetting = (TextView)findViewById(R.id.txtvPreSetting);
        txtvPrint = (TextView)findViewById(R.id.txtvPrint);
        txtvDesc = (TextView)findViewById(R.id.txtvDesc);

        btnTop = (Button)findViewById(R.id.btnTop);
        btnBottom = (Button)findViewById(R.id.btnBottom);
        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnRight = (Button)findViewById(R.id.btnRight);
        btnCancel = (Button)findViewById(R.id.btnCancel);
        btnConfirm = (Button)findViewById(R.id.btnConfirm);

        initMenuStyle();

        btnTop.setOnClickListener(this);
        btnBottom.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnTop:
                if(baseFragment != null){
                    fragmentTopOrBottom(true);
                }else if(ThirdLevelMenuIndex != -1){
                    firstLevelTopOrBottom(true,thirdLevelPop,ThirdLevelMenuIndex,3);
                }else if(SecondLevelMenuIndex != -1){
                    firstLevelTopOrBottom(true,secondLevelPop,SecondLevelMenuIndex,2);
                }else if(FirstLevelMenuIndex != -1){
                    firstLevelTopOrBottom(true,firstLevelPop,FirstLevelMenuIndex,1);
                }else{

                }
                break;
            case R.id.btnBottom:
                if(baseFragment != null){
                    fragmentTopOrBottom(false);
                }else if(ThirdLevelMenuIndex != -1){
                    firstLevelTopOrBottom(false,thirdLevelPop,ThirdLevelMenuIndex,3);
                }else if(SecondLevelMenuIndex != -1){
                    firstLevelTopOrBottom(false,secondLevelPop,SecondLevelMenuIndex,2);
                }else if(FirstLevelMenuIndex != -1){
                    firstLevelTopOrBottom(false,firstLevelPop,FirstLevelMenuIndex,1);
                }else{

                }
                break;
            case R.id.btnLeft:
                if(baseFragment != null){
                    fragmentLeftOrRight(true);
                }else if(ThirdLevelMenuIndex != -1){

                }else if(SecondLevelMenuIndex != -1){

                }else if(FirstLevelMenuIndex != -1){

                }else{
                    menuLeftOrRight(true);
                }
                break;
            case R.id.btnRight:
                if(baseFragment != null){
                    fragmentLeftOrRight(false);
                }else if(ThirdLevelMenuIndex != -1){

                }else if(SecondLevelMenuIndex != -1){

                }else if(FirstLevelMenuIndex != -1){

                }else{
                    menuLeftOrRight(false);
                }
                break;
            case R.id.btnCancel:
                if(baseFragment != null){
                    removeFragment();
                }else if(ThirdLevelMenuIndex != -1){
                    if(thirdLevelPop!=null){
                        thirdLevelPop.dismiss();
                        thirdLevelPop = null;
                    }
                    ThirdLevelMenuIndex = -1;
                }else if(SecondLevelMenuIndex != -1){
                    if(secondLevelPop!=null){
                        secondLevelPop.dismiss();
                        secondLevelPop = null;
                    }
                    SecondLevelMenuIndex = -1;
                }else if(FirstLevelMenuIndex != -1){
                    if(firstLevelPop!=null){
                        firstLevelPop.dismiss();
                        firstLevelPop = null;
                    }
                    FirstLevelMenuIndex = -1;
                }else{

                }
                break;
            case R.id.btnConfirm:
                if(baseFragment != null){
                    fragmentConfirm();
                }else if(ThirdLevelMenuIndex != -1){
                    String levelText = thirdLevelPop.getLevelTextForPosition(ThirdLevelMenuIndex);
                    if(!levelText.contains(">")){
                        baseFragment = mDataProvider.getFragment(levelText,MenuIndex);
                        setFragment();
                    }
                }else if(SecondLevelMenuIndex != -1){
                    if(secondLevelPop!=null){
                        String levelText = secondLevelPop.getLevelTextForPosition(SecondLevelMenuIndex);
                        if(levelText.contains(">")){
                            thirdLevelPop = new ListPop(MainActivity.this,mDataProvider.getLevelData(levelText));
                            ThirdLevelMenuIndex = 0;
//                            secondLevelPop.showAtLocation(txtvPreSetting,Gravity.RIGHT,0,0);
                            if(mDataProvider.getLevelData(levelText).length>SecondLevelMenuIndex+2){
                                thirdLevelPop.showAsDropDown(getMenuView(),firstLevelPop.getItemMaxWidth() + 5 + secondLevelPop.getItemMaxWidth() +5,0);
                            }else{
                                thirdLevelPop.showAsDropDown(getMenuView(), firstLevelPop.getItemMaxWidth() + 5 + secondLevelPop.getItemMaxWidth() + 5, firstLevelPop.getItemHeight()*FirstLevelMenuIndex + secondLevelPop.getItemHeight() * SecondLevelMenuIndex + 10);
                            }
                        }else{
                            baseFragment = mDataProvider.getFragment(levelText,MenuIndex);
                            setFragment();
                        }
                    }
                }else if(FirstLevelMenuIndex != -1){
                    if(firstLevelPop!=null){
                        String levelText = firstLevelPop.getLevelTextForPosition(FirstLevelMenuIndex);
                        if(levelText.contains(">")){
                            secondLevelPop = new ListPop(MainActivity.this,mDataProvider.getLevelData(levelText));
                            SecondLevelMenuIndex = 0;
//                            secondLevelPop.showAtLocation(txtvPreSetting,Gravity.RIGHT,0,0);
                            if(mDataProvider.getLevelData(levelText).length>FirstLevelMenuIndex+2){
                                secondLevelPop.showAsDropDown(getMenuView(),firstLevelPop.getItemMaxWidth()+5,0);
                            }else{
                                secondLevelPop.showAsDropDown(getMenuView(),firstLevelPop.getItemMaxWidth()+5,firstLevelPop.getItemHeight()*FirstLevelMenuIndex+10);
                            }
                        }else{
                            baseFragment = mDataProvider.getFragment(levelText,MenuIndex);
                            setFragment();
                        }
                    }
                }else{
                    firstLevelPop = new ListPop(MainActivity.this,mDataProvider.getMenuData(MenuIndex));
//                    firstLevelPop.showAtLocation(txtvLook, Gravity.BOTTOM,0,0);
                    FirstLevelMenuIndex = 0;
                    firstLevelPop.showAsDropDown(getMenuView());
                }
                break;
        }
        refreshDesc();
    }

    public synchronized void menuLeftOrRight(boolean isClickLeft){
        switch (MenuIndex){
            case 0:
                if(isClickLeft){
                    MenuIndex = 3;
                }else{
                    MenuIndex = 1;
                }
                break;
            case 1:
                if(isClickLeft){
                    MenuIndex = 0;
                }else{
                    MenuIndex = 2;
                }
                break;
            case 2:
                if(isClickLeft){
                    MenuIndex = 1;
                }else{
                    MenuIndex = 3;
                }
                break;
            case 3:
                if(isClickLeft){
                    MenuIndex = 2;
                }else{
                    MenuIndex = 0;
                }
                break;
        }
        initMenuStyle();
    }

    public synchronized void firstLevelTopOrBottom(boolean isClickTop,ListPop pop,int index,int level){
        if(isClickTop){
            if(index == 0){
                if(pop!=null){
                    index = pop.getMenuCount()-1;
                    pop.refreshStyle(index);
                }
            }else{
                index --;
                if(pop!=null){
                    pop.refreshStyle(index);
                }
            }
        }else{
            if(pop!=null){
                if(index == (pop.getMenuCount()-1)){
                    index = 0;
                    pop.refreshStyle(index);
                }else{
                    index++;
                    if(pop!=null){
                        pop.refreshStyle(index);
                    }
                }
            }
        }
        switch (level){
            case 1:
                FirstLevelMenuIndex = index;
                break;
            case 2:
                SecondLevelMenuIndex = index;
                break;
            case 3:
                ThirdLevelMenuIndex = index;
                break;
        }

    }

    public void initMenuStyle(){
        txtvLook.setSelected(false);
        txtvSetting.setSelected(false);
        txtvPrint.setSelected(false);
        txtvPreSetting.setSelected(false);
        switch (MenuIndex){
            case 0:
                txtvLook.setSelected(true);
                break;
            case 1:
                txtvSetting.setSelected(true);
                break;
            case 2:
                txtvPreSetting.setSelected(true);
                break;
            case 3:
                txtvPrint.setSelected(true);
                break;
        }
    }

    public View getMenuView(){
        View view = null;
        switch (MenuIndex){
            case 0:
                view = txtvLook;
                break;
            case 1:
                view = txtvSetting;
                break;
            case 2:
                view = txtvPreSetting;
                break;
            case 3:
                view = txtvPrint;
                break;
        }
        return view;
    }

    public void setFragment(){
        if(baseFragment!=null){
            if(FirstLevelMenuIndex != -1){
                if(firstLevelPop!=null){
                    firstLevelPop.dismiss();
                }
            }

            if(SecondLevelMenuIndex != -1){
                if(secondLevelPop!=null){
                    secondLevelPop.dismiss();
                }
            }

            if(ThirdLevelMenuIndex != -1){
                if(thirdLevelPop!=null){
                   thirdLevelPop.dismiss();
                }
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations( R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left,R.anim.slide_out_to_right);
            transaction.replace(R.id.frame_content, baseFragment).commit();
        }
    }

    public void removeFragment(){
        if(baseFragment!=null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations( R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left,R.anim.slide_out_to_right);
            transaction.remove(baseFragment).commit();
        }
        baseFragment = null;
        if(FirstLevelMenuIndex != -1){
            if(firstLevelPop!=null){
                firstLevelPop.showAsDropDown(getMenuView());
            }
        }

        if(SecondLevelMenuIndex != -1){
            if(secondLevelPop!=null){
                if(mDataProvider.getLevelData(firstLevelPop.getLevelTextForPosition(FirstLevelMenuIndex)).length>FirstLevelMenuIndex+2){
                    secondLevelPop.showAsDropDown(getMenuView(), firstLevelPop.getItemMaxWidth()+5,0);
                }else{
                    secondLevelPop.showAsDropDown(getMenuView(),firstLevelPop.getItemMaxWidth()+5,firstLevelPop.getItemHeight()*FirstLevelMenuIndex+10);
                }
            }
        }

        if(ThirdLevelMenuIndex != -1){
            if(thirdLevelPop!=null){
                if(mDataProvider.getLevelData(secondLevelPop.getLevelTextForPosition(SecondLevelMenuIndex)).length>SecondLevelMenuIndex+2){
                    thirdLevelPop.showAsDropDown(getMenuView(),firstLevelPop.getItemMaxWidth() + 5 + secondLevelPop.getItemMaxWidth() +5,0);
                }else{
                    thirdLevelPop.showAsDropDown(getMenuView(), firstLevelPop.getItemMaxWidth() + 5 + secondLevelPop.getItemMaxWidth() + 5, firstLevelPop.getItemHeight() * FirstLevelMenuIndex + secondLevelPop.getItemHeight() * SecondLevelMenuIndex + 10);
                }
            }
        }
    }

    public synchronized void fragmentLeftOrRight(boolean isLeft){
        String clsName = baseFragment.getClass().getSimpleName();
        switch (clsName){
            case "ViewPagerFragment":
                ViewPagerFragment viewPagerFragment = (ViewPagerFragment)baseFragment;
                if(isLeft){
                    viewPagerFragment.leftPage();
                }else{
                    viewPagerFragment.rightPage();
                }
                break;
            case "PasswordFragment":
                ((PasswordFragment) baseFragment).leftOrRight(isLeft);
                break;
            case "TimeSettingFragment":
                ((TimeSettingFragment)baseFragment).leftOrRight(isLeft);
                break;
            case "ThreeButtonDialogFragment":
                ((ThreeButtonDialogFragment)baseFragment).leftOrRight(isLeft);
                break;
            case "SettingViewPagerFragment":
                ((SettingViewPagerFragment)baseFragment).leftOrRight(isLeft);
                break;
            case "TwoButtonDialogFragment":
                ((TwoButtonDialogFragment)baseFragment).leftOrRight(isLeft);
                break;
            case "ShuZhiXingDingZhiFragment":
                ((ShuZhiXingDingZhiFragment)baseFragment).leftOrRight(isLeft);
                break;
        }
    }
    public synchronized void fragmentTopOrBottom(boolean isTop){
        String clsName = baseFragment.getClass().getSimpleName();
        switch (clsName){
            case "ViewPagerFragment":
                break;
            case "PasswordFragment":
                ((PasswordFragment)baseFragment).topOrBottom(isTop);
                break;
            case "TimeSettingFragment":
                ((TimeSettingFragment)baseFragment).topOrBottom(isTop);
                break;
            case "DeviceNumberFragment":
                ((DeviceNumberFragment)baseFragment).topOrBottom(isTop);
                break;
            case "DingZhiQuHaoFragment":
                ((DingZhiQuHaoFragment)baseFragment).topOrBottom(isTop);
                break;
            case "SettingViewPagerFragment":
                ((SettingViewPagerFragment)baseFragment).topOrBottom(isTop);
                break;
            case "ShuZhiXingDingZhiFragment":
                ((ShuZhiXingDingZhiFragment)baseFragment).topOrBottom(isTop);
                break;
        }
    }

    public synchronized void fragmentConfirm(){
        String clsName = baseFragment.getClass().getSimpleName();
        switch (clsName){
            case "PasswordFragment":
                if(((PasswordFragment)baseFragment).validatePassword()){
                    baseFragment = mDataProvider.getFragment(getCurrentLevelText()+"口令正确",MenuIndex);
                    setFragment();
                }
                break;
            case "TimeSettingFragment":
                break;
            case "DingZhiQuHaoFragment":
                baseFragment = mDataProvider.getFragment(getCurrentLevelText()+"修改确认",MenuIndex);
                setFragment();
                break;
            case "SettingViewPagerFragment":
                baseFragment = mDataProvider.getFragment(getCurrentLevelText()+"修改确认",MenuIndex);
                setFragment();
                break;
            case "ShuZhiXingDingZhiFragment":
                baseFragment = mDataProvider.getFragment(getCurrentLevelText()+"修改确认",MenuIndex);
                setFragment();
                break;
            case "NetPortSettingFragment":
                baseFragment = mDataProvider.getFragment(getCurrentLevelText()+"修改确认",MenuIndex);
                setFragment();
                break;

        }
    }

    public synchronized void refreshDesc(){
        if(baseFragment!=null){
            txtvDesc.setVisibility(View.GONE);
        }else if(ThirdLevelMenuIndex!=-1){
            txtvDesc.setVisibility(View.VISIBLE);
            if(thirdLevelPop!=null){
                txtvDesc.setText(mDataProvider.getDesc(thirdLevelPop.getLevelTextForPosition(ThirdLevelMenuIndex)));
            }
        }else if(SecondLevelMenuIndex!=-1){
            txtvDesc.setVisibility(View.VISIBLE);
            if(secondLevelPop!=null){
                txtvDesc.setText(mDataProvider.getDesc(secondLevelPop.getLevelTextForPosition(SecondLevelMenuIndex)));
            }
        }else if(FirstLevelMenuIndex!=-1){
            txtvDesc.setVisibility(View.VISIBLE);
            if(firstLevelPop!=null){
                txtvDesc.setText(mDataProvider.getDesc(firstLevelPop.getLevelTextForPosition(FirstLevelMenuIndex)));
            }
        }else {
            txtvDesc.setVisibility(View.GONE);
        }
    }

    public synchronized String getCurrentLevelText(){
        String levelText = "";
        if(ThirdLevelMenuIndex != -1){
            if(thirdLevelPop!=null){
                levelText = thirdLevelPop.getLevelTextForPosition(ThirdLevelMenuIndex);
            }
        }else if(SecondLevelMenuIndex != -1){
            if(secondLevelPop!=null){
                levelText = secondLevelPop.getLevelTextForPosition(SecondLevelMenuIndex);
            }
        }else if(FirstLevelMenuIndex != -1) {
            if (firstLevelPop != null) {
                levelText = firstLevelPop.getLevelTextForPosition(FirstLevelMenuIndex);
            }
        }
        return levelText;
    }
}
