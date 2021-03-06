package com.example.liujiang.testone.acp;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.liujiang.testone.R;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

/**
 * 开屏页
 */
public class MainActivity extends AppCompatActivity {
    //点击跳转      倒计时跳转
    private TextView textView, tv1;
    //设置常量  用途 代表时间
    private static final String SLEEP_TIME_KEY = "time";
    //设置常量  用途 代表秒数
    private static final long SLEEP_TIME = 1000;
    Handler handler = new Handler() {
        //        接受并处理接收到的消息
        public void handleMessage(Message msg) {
            String a = msg.getData().getString(SLEEP_TIME_KEY);
            tv1.setText(a + "s");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dianjitiaozhuan();
        shuimian();
        djs();
    }

    //点击textview跳转到登录页
    private void dianjitiaozhuan() {
        textView = (TextView) findViewById(R.id.jinru);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    //倒计时的方法
    private void djs() {
        tv1 = (TextView) findViewById(R.id.text_djs1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int x = 3; x > -1; x--) {
                    String a = String.valueOf(x);
                    //编辑需要发送的消息
                    Message msg = new Message();
                    Bundle data = new Bundle();
                    data.putString(SLEEP_TIME_KEY, a);
                    msg.setData(data);

                    //给handler发送消息

                    handler.sendMessage(msg);
                    try {
                        Thread.sleep(SLEEP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    //  开屏页 休眠方法
    private void shuimian() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    //从开平页跳转到登陆页
    private void init() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}

