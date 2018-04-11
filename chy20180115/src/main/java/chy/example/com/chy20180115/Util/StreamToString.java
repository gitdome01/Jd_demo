package chy.example.com.chy20180115.Util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by 卿为谁人醉 on 2018/1/10.
 */

public class StreamToString {
    public static String streamTostring(InputStream inputStream, String chartset){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,chartset));
            String str;
            while ((str = reader.readLine())!=null){
                stringBuilder.append(str);
            }
            reader.close();
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
