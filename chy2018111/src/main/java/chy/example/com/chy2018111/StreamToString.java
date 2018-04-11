package chy.example.com.chy2018111;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by e531 on 2017/10/12.
 */
public class StreamToString {

    public static String streamToStr(InputStream inputStream,String chartSet){

        StringBuilder builder=new StringBuilder();
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream,chartSet));
            String con;
            while ((con=br.readLine())!=null){
                builder.append(con);
            }

            br.close();
            return builder.toString();


        } catch (Exception e) {
            e.printStackTrace();
        }


        return "";
    }
}
