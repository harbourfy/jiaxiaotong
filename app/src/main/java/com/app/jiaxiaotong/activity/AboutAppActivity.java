package com.app.jiaxiaotong.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.app.jiaxiaotong.R;
import com.app.jiaxiaotong.utils.ToolBarUtils;

public class AboutAppActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ToolBarUtils.initToolBar(this,"关于软件");
    }


}
