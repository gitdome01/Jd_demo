package chy.example.com.day_ofnews.Util;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 使用AsyncTask+HttpURLConnection请求数据
 * Created by e531 on 2017/10/12.
 */
public class MyTask extends AsyncTask<String,Void,String> {

    //申请一个接口类对象
    private  Icallbacks icallbacks;

    //将无参构造设置成私有的，使之在外部不能够调用
    private MyTask(){}

    //定义有参构造方法
    public MyTask(Icallbacks icallbacks) {
        this.icallbacks = icallbacks;
    }

    @Override
    protected String doInBackground(String... params) {
  String str="";

        try {
             //使用HttpUrlConnection
            URL url=new URL(params[0]);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);

            if(connection.getResponseCode()==200){
                InputStream inputStream=connection.getInputStream();
                //调用工具类中的静态方法
        str=StreamToString.streamTostring(inputStream,"utf-8");
                return str;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return str;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //解析，封装到bean,更新ui组件
        icallbacks.updateUiByjson(s);



    }
    //定义一个接口
    public interface Icallbacks{
        /**
         * 根据回传的json字符串，解析并更新页面组件
         * @param jsonstr
         */
        void updateUiByjson(String jsonstr);
    }
}
