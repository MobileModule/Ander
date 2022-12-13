package amap.yun.task;

import com.lea.leaander.utils.LeaLog;

import java.util.ArrayList;

import amap.yun.entity.PoiEntity;
import amap.yun.http.AmapHttpServer;
import amap.yun.utils.JSONUtils;

/**
 * Created by druid on 2019/1/15.
 */

public class UpdatePoiTask extends BaseTask {
    public static final String TAG = UpdatePoiTask.class.getName();
    private PoiEntity entity = null;

    public UpdatePoiTask(PoiEntity entity) {
        this.entity = entity;
    }

    @Override
    protected String doInBackground(Void... params) {
        String result = "";
        String _id = "";
        String img_name = entity.username + "_" + entity.mobile_info + ".jpeg";
        result = upload(entity.image, img_name);
        entity.image = null;
        String img_server = JSONUtils.getFilePath(result);
//        LeaLog.i(TAG, img_server);
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
//        LeaLog.i(TAG, s);
    }
}

