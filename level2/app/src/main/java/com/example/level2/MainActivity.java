package com.example.level2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {
    List<data> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取字段
        new Thread(()->{
            BufferedReader stringReader=null;
            HttpURLConnection connection=null;
            StringBuilder stringBuilder = null;
            try {
                URL url=new URL("https://www.wanandroid.com/article/list/0/json");
                connection=(HttpURLConnection)url.openConnection();
                InputStream in=connection.getInputStream();

                //获取流 获取对应网站的内容（json数据）
                stringReader =new BufferedReader(new InputStreamReader(in));
                stringBuilder =new StringBuilder();
                String line;
                while ((line=stringReader.readLine())!=null){
                    stringBuilder.append(line);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (connection!=null){
                    connection.disconnect();
                }
                if (stringReader!=null){
                    try {
                        stringReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            //对数据进行处理
            try {
                JSONObject jsonObject=new JSONObject(String.valueOf(stringBuilder));
                JSONObject data=jsonObject.getJSONObject("data");
                JSONArray datas=data.getJSONArray("datas");
                for (int i=0;i<datas.length();i++){
                    JSONObject datasJSONObject=datas.getJSONObject(i);
                    list.add(new data(datasJSONObject.getString("title"),
                            datasJSONObject.getString("shareUser"),
                            datasJSONObject.getString("link")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            show();

        }).start();
    }

    private void show() {
        runOnUiThread(()->{
            //将输入传入adapter
            adapter adapter1=new adapter(list);
            RecyclerView recyclerView=findViewById(R.id.Rec1);
            recyclerView.setLayoutManager(new GridLayoutManager(this,1));
            recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
            recyclerView.setAdapter(adapter1);
        });
    }
}
