package amap.yun.utils;

import org.json.JSONObject;

/**
 * Created by druid on 2019/1/15.
 */

public class JSONUtils {

    public static String getFilePath(String result){
        String path="";
        try{
            JSONObject jsonObject=new JSONObject(result);
            if(jsonObject.has("linkurl")){
                path=jsonObject.optString("linkurl");
            }
        }catch (Exception ex){

        }
        return path;
    }
}
