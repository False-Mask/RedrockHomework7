package com.example.level1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取布局的组件
        textView=findViewById(R.id.T1);
        imageView=findViewById(R.id.I1);

        //包装message并将分支线程切换道主线程
        MyHandler myHandler=new MyHandler();
        new Thread(()->{
            for (int i=29;i>=-1;i--){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //发送信息
                Message message=new Message();
                message.obj=i;
                myHandler.sendMessage(message);
            }
        }).start();



    }


    private class MyHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            int x=(Integer)msg.obj;
            if (x!=-1){
                textView.setText(x+"");
            }
            else {
                textView.setText("");
                imageView.setImageResource(R.drawable.diandaoweizhi);
            }
        }
    }
}