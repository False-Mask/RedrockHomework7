package com.example.level4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class MainActivity3 extends AppCompatActivity {
    HashMap<String,String> hashMap=new HashMap<>();
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //注册的输入框
        EditText editText3=findViewById(R.id.Ed1);
        EditText editText4=findViewById(R.id.Ed2);
        EditText editText5=findViewById(R.id.Ed3);

        //对Button获取以及点击处理
        Button button2=findViewById(R.id.B2);
        button2.setOnClickListener(v -> {

            //获取内容
            String ed3=editText3.getText().toString();
            String ed4=editText4.getText().toString();
            String ed5=editText5.getText().toString();

            hashMap.put("username",ed3);
            hashMap.put("password",ed4);
            hashMap.put("repassword",ed5);

            //发送post请求
            Request.PostNetRequest("https://www.wanandroid.com/user/register",hashMap);

            try {
                Request.Request.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //接受post结果
            result=MainActivity.result;

            //调用解析函数
            Object object=MainActivity.Json.Json(result);
            if (MainActivity.Json.flag){
                TheRightDataAfterPost rightDataAfterPost;
                rightDataAfterPost=(TheRightDataAfterPost)object;
                Toast.makeText(MainActivity3.this,"注册成功",Toast.LENGTH_LONG).show();

            }else {
                TheWrongDataAfterPost wrongDataAfterPost;
                wrongDataAfterPost=(TheWrongDataAfterPost)object;
                Toast.makeText(MainActivity3.this,wrongDataAfterPost.getErrorMsg(),Toast.LENGTH_LONG).show();
            }
        });

    }

}