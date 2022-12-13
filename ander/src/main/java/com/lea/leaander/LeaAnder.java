package com.lea.leaander;

import android.content.Context;

import com.lea.leaander.utils.StringUtils;

import amap.yun.entity.PoiEntity;


/**
 * Created by LeaAnder on 2018/3/28.
 */

public class LeaAnder extends BaseLeaAnder {
    static LeaAnder instance;
    public LeaAnder(Context context) {
         super(context);
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new LeaAnder(context);
        }
    }

    public static LeaAnder instance() {
        return instance;
    }
}
