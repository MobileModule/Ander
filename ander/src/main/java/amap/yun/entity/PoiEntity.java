package amap.yun.entity;

import java.io.Serializable;

/**
 * Created by druid on 2019/1/15.
 */

public class PoiEntity implements Serializable {
    public String username;//用户名
    public String mobile_info;//手机型号
    public String pwd;//密码
    public String userid;//用户Id
    public String img_server;//截屏图片
    public String appversion="";//软件版本
    public byte[] image;
}
