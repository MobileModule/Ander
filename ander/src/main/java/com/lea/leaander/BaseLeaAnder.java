package com.lea.leaander;

import android.content.Context;

import amap.yun.entity.PoiEntity;
import amap.yun.task.UpdatePoiTask;

/**
 * Created by LeaAnder on 2018/3/28.
 */

public class BaseLeaAnder {
    protected Context context;

    public BaseLeaAnder(Context context) {
        this.context = context;
    }

    public void createPoi(PoiEntity poi) {
        UpdatePoiTask task = new UpdatePoiTask(poi);
        task.start();
    }

}

