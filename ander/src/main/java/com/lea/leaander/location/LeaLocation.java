package com.lea.leaander.location;

import java.io.Serializable;

/**
 * Created by LeaAnder on 2018/3/28.
 */

public class LeaLocation implements Serializable {
    public double lat = -200;
    public double lng = -200;
    public String address = "";
    public String provider = "";
    public String cityName = "";
    public float accuracy = 0;
}
