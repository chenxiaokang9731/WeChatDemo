package com.xfi.liuliangjun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xfi.liuliangjun.util.wechat.WeChatUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void wechat_login(View view){
        WeChatUtil.accreditSign();
    }
}
