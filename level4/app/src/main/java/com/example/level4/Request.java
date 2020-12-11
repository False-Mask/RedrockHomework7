package com.example.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

public class Request {

    static Thread Request;

    //post请求
    static void PostNetRequest(String post, HashMap<String,String> hashMap){
        Request=new Thread(() -> {
            HttpURLConnection connection = null;
            StringBuilder stringBuilder;
            try {
                URL url=new URL(post);
                connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(8000);
                connection.setReadTimeout(8000);
                connection.setDoInput(true);
                connection.setDoOutput(true);

                stringBuilder=new StringBuilder();
                for (String key:hashMap.keySet()){
                    stringBuilder.append(key).append("=")
                            .append(hashMap.get(key)).append("&");
                }

                connection.connect();
                OutputStream out=connection.getOutputStream();
                out.write(stringBuilder.substring(0,stringBuilder.length()-1).getBytes());

                InputStream in=connection.getInputStream();
                StreamToString(in);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (connection!=null){
                    connection.disconnect();
                }
            }

        });
        Request.start();
    }

    //GET请求
    static void getNetRequest(String urladdress,HashMap<String,String>hashMap){
        new Thread(()->{
            try {
                URL url=new URL(urladdress);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setConnectTimeout(8000);
                connection.setReadTimeout(8000);
                connection.setRequestMethod("GET");
                InputStream in=connection.getInputStream();
                StreamToString(in);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }

    //对InputStream进行读取
    static String StreamToString(InputStream in){
        StringBuilder stringBuilder=new StringBuilder();
        String line;
        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        while (true){
            try {
                if ((line = reader.readLine()) == null) break;
                stringBuilder.append(line);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        MainActivity.result=stringBuilder.toString();
        return stringBuilder.toString();
    }

}
