package com.example.level3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List <Date> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Thread(()->{
            HttpURLConnection connection=null;
            BufferedReader reader=null;
            StringBuilder stringBuilder=new StringBuilder();

            //抓异常
            try {
                URL url=new URL("https://www.wanandroid.com/article/list/0/json");
                connection=(HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(8000);
                connection.setReadTimeout(8000);
                connection.setRequestMethod("GET");
                InputStream in=connection.getInputStream();

                //读取输出流
                reader=new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line= reader.readLine()) !=null){
                    stringBuilder.append(line);
                }


                //对json数据进行解析

                //解析jsonobject 抓取数组
                JSONObject jsonObject=new JSONObject(String.valueOf(stringBuilder));
                JSONObject data=jsonObject.getJSONObject("data");
                JSONArray dates=data.getJSONArray("datas");

                //对数组内容进行抓取
                for (int i=0 ; i < dates.length() ; i++){
                    JSONObject  array=dates.getJSONObject(i);
                    list.add(new Date( array.getString("title") ,
                            array.getString("shareUser")
                            , array.getString("link") ));
                }

                show();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection!=null){
                    connection.disconnect();
                }if (reader!=null){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }




    private void show() {
        runOnUiThread(()->{
            adapter adapter1=new adapter(list);
            RecyclerView recyclerView=findViewById(R.id.Rec1);
            recyclerView.setAdapter(adapter1);
            recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
            recyclerView.addItemDecoration(new DividerItemDecoration(
                    this,DividerItemDecoration.VERTICAL
            ));
        });
    }
}