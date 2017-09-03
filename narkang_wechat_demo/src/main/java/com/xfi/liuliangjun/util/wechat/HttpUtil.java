package com.xfi.liuliangjun.util.wechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 陈小康 on 2017/9/3.
 * http请求封装
 */
public class HttpUtil {

    public static void sendGetRequest(final String u, final DataGetSuccessListener dataGetSuccessListener){
        new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL(u);
                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                    BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuffer sb = new StringBuffer();
                    String line;
                    while ((line = inputStream.readLine()) != null){
                        sb.append(line);
                    }
                    dataGetSuccessListener.dataGetSuccess(sb.toString());

                    inputStream.close();
                    connection.disconnect();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
