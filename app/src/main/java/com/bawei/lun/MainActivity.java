package com.bawei.lun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.lun.net.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    private Banner mBan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        MainPresenter mainPresenter = new MainPresenter(this);
        mainPresenter.ddshow();
    }

    private void initView() {
        mBan = (Banner) findViewById(R.id.ban);

    }

    @Override
    public void get(List<Catagory.DataBean> list) {
        String icon = list.get(0).getIcon();
        String icon1 = list.get(1).getIcon();
        String icon2 = list.get(2).getIcon();
        mBan.setImageLoader(new GlideImageLoader());
        List<String> img=new ArrayList<String>();
        img.add(icon);
        img.add(icon1);
        img.add(icon2);
        mBan.setImages(img);
        mBan.start();
    }
}
