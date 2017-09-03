package com.xfi.liuliangjun.wxapi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.xfi.liuliangjun.util.wechat.DataGetSuccessListener;
import com.xfi.liuliangjun.util.wechat.HttpUtil;
import com.xfi.liuliangjun.util.wechat.WeChatUtil;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by narkang on 2017/9/3.
 * 对于微信相关的业务操作，目前就只是支持原生操作
 */

public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WeChatUtil.getApi().handleIntent(getIntent(), this);
    }

    //微信请求第三方应用的回调
    @Override
    public void onReq(BaseReq baseReq) {

    }

    //微信响应第三方应用的回调
    @Override
    public void onResp(BaseResp baseResp) {
        String code = ((SendAuth.Resp)baseResp).code;
        //获取access_token
        StringBuilder sb = new StringBuilder();
        sb.append("https://api.weixin.qq.com/sns/oauth2/access_token?")
          .append("appid=")
          .append(WeChatUtil.appid)
          .append("&secret=")
          .append(WeChatUtil.secret)
          .append("&code=")
          .append(code)
          .append("&grant_type=authorization_code");
        HttpUtil.sendGetRequest(sb.toString(), new DataGetSuccessListener() {
            @Override
            public void dataGetSuccess(String date) {
                System.out.println("获取token----------->>>>>"+date);
                try {
                    JSONObject jsonObject = new JSONObject(date);
                    String access_token = jsonObject.getString("access_token");
                    String openid = jsonObject.getString("openid");
                    //获取用户信息
                    StringBuffer sb = new StringBuffer();
                    sb.append("https://api.weixin.qq.com/sns/userinfo?access_token=")
                       .append(access_token)
                       .append("&openid=")
                       .append(openid);
                    HttpUtil.sendGetRequest(sb.toString(), new DataGetSuccessListener() {
                        @Override
                        public void dataGetSuccess(String date) {
                            System.out.println("获取用户信息----->>>"+date);

                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
