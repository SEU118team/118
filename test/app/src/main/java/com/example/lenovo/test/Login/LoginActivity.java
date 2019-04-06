package com.example.lenovo.test.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.test.MainActivity.MainActivity;
import com.example.lenovo.test.R;
import com.example.lenovo.test.MainActivity.ListViewActivity;

public class LoginActivity extends AppCompatActivity {

    public static LoginActivity instance;

    private Button mBt_login;
    private Button mBt_socket;

    private TextView mTv_zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance=this;
        setContentView(R.layout.activity_login);
        mBt_login=findViewById(R.id.login_login);
        mBt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            LoginActivity.instance.finish();
            }
        });

        mTv_zhuce=findViewById(R.id.login_tv_no_id);
        mTv_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
