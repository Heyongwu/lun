package com.bawei.lun;

import com.bawei.lun.model.IMainModel;
import com.bawei.lun.model.MainModel;
import com.bawei.lun.net.OnNetListener;

import java.util.List;

/**
 * Created by DangByMySide on 2017/11/23.
 */

public class MainPresenter {
    private IMainActivity iMainActivity;
    private final IMainModel iMainModel;

    public MainPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        iMainModel = new MainModel();
    }
    public void ddshow(){
        iMainModel.geturl(new OnNetListener<Catagory>() {
            @Override
            public void onSuccess(Catagory catagory) {
                List<Catagory.DataBean> data = catagory.getData();
                iMainActivity.get(data);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

}
