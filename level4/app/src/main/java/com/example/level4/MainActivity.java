package com.example.level4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {
    HashMap<String,String> hashMap=new HashMap<>();
    static String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//实例化变量
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //文本实例
        TextView textView=findViewById(R.id.T2);
        TextView textView1=findViewById(R.id.T1);


        //登陆按钮
        Button button2=findViewById(R.id.B1);


        //editView对象
        //登陆的输入框
        EditText editText1=findViewById(R.id.E1);
        EditText editText2=findViewById(R.id.E2);



        //登陆点击的处理
        button2.setOnClickListener(v -> {
            //获取editview的内容
            String ed1=editText1.getText().toString();
            String ed2=editText2.getText().toString();


            //存储到hash表内
            hashMap.put("username",ed1);
            hashMap.put("password",ed2);


            //发送post请求
            Request.PostNetRequest("https://www.wanandroid.com/user/login",hashMap);
            try {
                Request.Request.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //调用解析 获取解析数据
            Object Dates=Json.Json(result);
            if (Json.flag){
                TheRightDataAfterPost rightDataAfterPost;
                rightDataAfterPost=(TheRightDataAfterPost)Dates;
                Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"即将跳转",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this
                        ,MainActivity4.class);

               // intent.putExtra("importantData", (Bundle) Dates);
                startActivity(intent);

            }else {
                TheWrongDataAfterPost wrongDataAfterPost;
                wrongDataAfterPost=(TheWrongDataAfterPost)Dates;
                Toast.makeText(MainActivity.this,wrongDataAfterPost.getErrorMsg(),Toast.LENGTH_LONG).show();
            }
        });



        //对注册和忘记密码的点击进行监听(同时进行页面跳转)
        textView.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        });
        textView1.setOnClickListener(v->{
                    Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(intent);
        });
    }



    static class Json{
        //解析json字段
        static boolean flag=true;
        static Object Json(String result){
            //利用多态向上和向下转型
            Object dataAfterPost = null;

            try {
                JSONObject jsonObject=new JSONObject(result);
                JSONObject jsonObject1 = null;
                try {
                    jsonObject1=jsonObject.getJSONObject("data");
                }catch (JSONException e){
                    jsonObject1=null;
                }
                if (jsonObject1==null){
                    dataAfterPost=new TheWrongDataAfterPost(null,-1
                            ,jsonObject.getString("errorMsg"));
                    flag=false;
                }


                else {
                    JSONArray jsonArray=jsonObject1.getJSONArray("chapterTops");
                    JSONArray jsonArray1=jsonObject1.getJSONArray("collectIds");
                    List<Object> list1,list2;
                    list1=new ArrayList<>();
                    list2=new ArrayList<>();
                    for (int i=0;i<jsonArray.length();i++){
                        list1.add(jsonArray.get(i));
                    }for (int i=0;i<jsonArray1.length();i++){
                        list2.add(jsonArray1.get(i));
                    }


                    dataAfterPost=new TheRightDataAfterPost(jsonObject1.getBoolean("admin")
                            ,list1
                            ,jsonObject1.getInt("coinCount")
                            ,list2
                            ,jsonObject1.getString("email")
                            ,jsonObject1.getString("icon")
                            ,jsonObject1.getInt("id")
                            ,jsonObject1.getString("nickname")
                            ,jsonObject1.getString("password")
                            ,jsonObject1.getString("publicName")
                            ,jsonObject1.getString("token")
                            ,jsonObject1.getInt("type")
                            ,jsonObject1.getString("username"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return dataAfterPost;
        }

    }


}