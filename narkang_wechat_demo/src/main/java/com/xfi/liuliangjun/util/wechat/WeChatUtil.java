package com.xfi.liuliangjun.util.wechat;

import android.content.Context;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by 陈小康 on 2017/9/3.
 * 微信相关工具类封装
 */

public class WeChatUtil {

    public static final String appid = "wx720d48fb8baad057";

    public static final String secret = "d4415bb3e22d1cd836e803c69c69f501";

    private static IWXAPI api;

    public static void regTowx(Context context){
        api = WXAPIFactory.createWXAPI(context, appid, true);
        api.registerApp(appid);
    }

    public static IWXAPI getApi() {
        return api;
    }

    /**
     * 微信授权登陆
     */
    public static void accreditSign(){
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        api.sendReq(req);
    }


}
