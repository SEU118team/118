package com.example.lenovo.test;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.test.util.ToastUtil;

public class SettingActivity extends AppCompatActivity {

    private Button mBt_setting_color,mBt_setting_about,mBt_setting_size,mBt_setting_clear;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mBt_setting_color= findViewById(R.id.setting_color);
        mBt_setting_about= findViewById(R.id.setting_about);
        mBt_setting_size= findViewById(R.id.setting_size);
        mBt_setting_clear= findViewById(R.id.setting_clear);
        OnClick onClick=new OnClick();
        mBt_setting_color.setOnClickListener(onClick);
        mBt_setting_about.setOnClickListener(onClick);
        mBt_setting_size.setOnClickListener(onClick);
        mBt_setting_clear.setOnClickListener(onClick);
    }
    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.setting_color:
                final String[] array1 = new String[]{"主题色1", "主题色2", "主题色3"};
                AlertDialog.Builder builder1 = new AlertDialog.Builder(SettingActivity.this);
                builder1.setTitle("选择主题色").setSingleChoiceItems(array1, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.showMSg(SettingActivity.this, array1[which]);
                        dialog.dismiss();
                    }
                }).setCancelable(false).show();
                    break;
                case R.id.setting_about:

                    AlertDialog.Builder builder2 = new AlertDialog.Builder(SettingActivity.this);
                    View view=LayoutInflater.from(SettingActivity.this).inflate(R.layout.acticity_setting_about,null);
                    builder2.setTitle("关于我们").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ;
                        }
                    }).setView(view).show();
                    break;
                case R.id.setting_size:
                    final String[] array3 = new String[]{"字体1", "字体2", "字体3"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(SettingActivity.this);
                    builder3.setTitle("选择字体大小").setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMSg(SettingActivity.this, array3[which]);
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.setting_clear:
                    AlertDialog.Builder builder4=new AlertDialog.Builder(SettingActivity.this);
                    builder4.setTitle("是否清楚缓存？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMSg(SettingActivity.this,"清除成功");
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ;
                        }
                    }).show();
                    break;
            }
        }
    }

}
