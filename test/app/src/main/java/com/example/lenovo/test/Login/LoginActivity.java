package com.example.lenovo.test.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.test.MainActivity.MainActivity;
import com.example.lenovo.test.R;
import com.example.lenovo.test.MainActivity.ListViewActivity;

public class LoginActivity extends AppCompatActivity {

    private Button mBt_login;
    private Button mBt_socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mBt_login=findViewById(R.id.login_login);
        mBt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
