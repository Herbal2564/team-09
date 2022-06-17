package com.app.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // 宣告Fragment物件
    private FirstFragment mFirstFragment;
    private SecondFragment mSecondFragment;
    private ThirdFragment mThirdFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 把建立的Fragment物件存起來
        mFirstFragment = new FirstFragment();
        mSecondFragment = new SecondFragment();
        mThirdFragment = new ThirdFragment();

        // 把Fragment物件放入FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLay, mFirstFragment, "First Fragment")
                .add(R.id.frameLay, mSecondFragment, "Second Fragment")
                .add(R.id.frameLay, mThirdFragment, "Third Fragment")
                .hide(mSecondFragment)
                .hide(mThirdFragment)
                .commit();
    }

    // 呼叫這個方法就會顯示第二頁，把第一頁蓋住
    public void showSecondFragment() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.trans_in_from_right, R.anim.no_anim)
                .show(mSecondFragment)
                .commit();
    }

    // 呼叫這個方法就會隱藏第二頁，露出第一頁
    public void showFirstFragment() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.no_anim, R.anim.trans_out_to_right)
                .hide(mSecondFragment)
                .hide(mThirdFragment)
                .commit();
    }
    public void showThirdFragment() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.trans_in_from_right, R.anim.no_anim)

                .show(mThirdFragment)
                .commit();
    }
}
