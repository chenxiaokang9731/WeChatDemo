package com.xfi.liuliangjun;

import android.app.Application;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.xfi.liuliangjun.icon.WeChatIconModule;
import com.xfi.liuliangjun.util.wechat.WeChatUtil;

/**
 * Created by 陈小康 on 2017/9/3.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Iconify.with(new FontAwesomeModule())
               .with(new WeChatIconModule());

        //注册微信相关应用
        WeChatUtil.regTowx(this);
    }

}
