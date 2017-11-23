package com.bawei.lun.model;

import android.os.Handler;
import android.os.Looper;

import com.bawei.lun.Catagory;
import com.bawei.lun.net.Api;
import com.bawei.lun.net.HttpUtils;
import com.bawei.lun.net.OnNetListener;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by DangByMySide on 2017/11/23.
 */

public class MainModel implements IMainModel{
Handler handler=new Handler(Looper.getMainLooper());
    @Override
    public void geturl(final OnNetListener<Catagory> onNetListener) {
        HttpUtils.getHttpUtils().doGet(Api.CLASS, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String string = response.body().string();
                final Catagory catagory = new Gson().fromJson(string, Catagory.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(catagory);
                    }
                });
            }
        });
    }
}
