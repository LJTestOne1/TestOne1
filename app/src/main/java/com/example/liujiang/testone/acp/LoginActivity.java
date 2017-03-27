package com.example.liujiang.testone.acp;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liujiang.testone.R;
import com.example.liujiang.testone.view.TestDialog;

/**
 * Created by liujiang on 2017/3/24.
 * 登录页
 */

public class LoginActivity extends AppCompatActivity {
    // 输入姓名        输入密码
    private EditText edit_username, edit_password;
    //登录按钮         注册按钮
    private Button button_login, button_zhuce;
    private TestDialog td;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_login);
        init();
        td = new TestDialog(this, R.style.CustomDialog);
    }

    // 初始化控件   设置点击事件
    private void init() {
        edit_username = (EditText) findViewById(R.id.edit_name);
        edit_password = (EditText) findViewById(R.id.edit_password);
        button_login = (Button) findViewById(R.id.button_login);
        button_zhuce = (Button) findViewById(R.id.button_zhuce);
        //点击按钮跳转到注册界面
        button_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, null);
                startActivity(intent);
            }
        });
        //点击按钮如果登录成功跳转到主界面，如果失败，提示一下登录失败
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = edit_username.getText().toString();
                String password = edit_password.getText().toString();
                if (username.equals(123456) && password.equals(456789)) {
                    Intent intent = new Intent(LoginActivity.this, null);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT);
                    td.dismiss();
                } else {
                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                    td.dismiss();
                }
            }
        });

    }

}
