package com.bawei.lun.model;

import com.bawei.lun.Catagory;
import com.bawei.lun.net.OnNetListener;

/**
 * Created by DangByMySide on 2017/11/23.
 */

public interface IMainModel {
    public void geturl(OnNetListener<Catagory> onNetListener);
}
