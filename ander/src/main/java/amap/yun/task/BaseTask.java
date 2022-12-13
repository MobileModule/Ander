package amap.yun.task;

import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import amap.yun.Key;
import amap.yun.http.AmapHttpServer;

/**
 * Created by druid on 2019/1/15.
 */

public class BaseTask extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... params) {
        return null;
    }

    public static String upload(byte[] imgPath,String filename) {
        String result="";
        try {
            final String newLine = "\r\n";
            final String boundaryPrefix = "--";
            final String boundary = String.format("=========%s",System.currentTimeMillis());
            URL url = new URL(AmapHttpServer.UploadTieTuImg());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Charsert", "UTF-8");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            OutputStream out = new DataOutputStream(conn.getOutputStream());
            String keyValue = "Content-Disposition: form-data; name=\"%s\"\r\n\r\n%s\r\n";
            byte[] parameterLine= (boundaryPrefix+boundary+newLine).getBytes();

            Map<String,String> map=new HashMap<>();
            map.put("Token", Key.PHOTO_TOKEN);
            if(map!=null&&map.size()>0){
                for (Map.Entry<String, String> e : map.entrySet()) {
                    byte[] keyValueBytes = String.format(keyValue,e.getKey(),e.getValue()).getBytes();
                    out.write(parameterLine);
                    out.write(keyValueBytes);
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(boundaryPrefix);
            sb.append(boundary);
            sb.append(newLine);

            sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + filename + "\"" + newLine);
            sb.append("Content-Type:application/octet-stream");

            sb.append(newLine);
            sb.append(newLine);

            out.write(sb.toString().getBytes());
            DataOutputStream ds = new DataOutputStream(conn.getOutputStream());
//            FileInputStream fStream = new FileInputStream(imgPath);
//            int bufferSize = 1024;
//            byte[] buffer = new byte[bufferSize];
//            int length = -1;
//            while ((length = fStream.read(buffer)) != -1) {
//                ds.write(buffer, 0, length);
//            }
//            fStream.close();
            ds.write(imgPath,0,imgPath.length);
            ds.flush();
            out.write(newLine.getBytes());
            byte[] end_data = (newLine + boundaryPrefix + boundary + boundaryPrefix + newLine).getBytes();
            out.write(end_data);
            out.flush();
            out.close();

            // 定义BufferedReader输入流来读取URL的响应
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (inputStream != null) {
                    byte[] data = new byte[1024];
                    int len = 0;
                    while ((len = inputStream.read(data)) != -1) {
                        data.toString();
                        byteArrayOutputStream.write(data, 0, len);
                    }
                    result = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                }
            }

        } catch (Exception e) {
        }
        return result;
    }

    public void start() {
        executeOnExecutor(Executors.newCachedThreadPool());
    }
}
