package com.example.lenovo.test.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.test.MyTieziActivity;
import com.example.lenovo.test.R;
import com.example.lenovo.test.SettingActivity;
import com.example.lenovo.test.fatie.MyInfoActivity;
import com.example.lenovo.test.fatie.PostActivity;
import com.example.lenovo.test.fragment.Afragment;
import com.example.lenovo.test.fragment.Bfragment;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private DrawerLayout drawerLayout;
    private LinearLayout left;

    private ImageView my_im;

    private TextView my_tx1;
    private TextView my_tx2;
    private TextView my_tx3;
    private TextView my_tx4;
    private TextView my_tx5;
    private TextView my_tx6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        //此处final是为了tablayout可以修改
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(onMenuItemClick);
        //左边栏
        drawerLayout = findViewById(R.id.draw);
        left = findViewById(R.id.right_draw);

        //左边栏状态监听
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //滑动时
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                //打开时
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                //关闭时
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                //改变时
            }
        });

        mTabLayout =findViewById(R.id.tabLayout);
        mViewPager =findViewById(R.id.viewPager);
        //使用Tablayout的newTab()创建tab
        TabLayout.Tab tab1 = mTabLayout.newTab().setText("tab1");
        TabLayout.Tab tab2 = mTabLayout.newTab().setText("tab2");
        //TabLayout.Tab tab3 = mTabLayout.newTab().setText("tab3");
        //添加tab
        mTabLayout.addTab(tab1);
        mTabLayout.addTab(tab2);
        //mTabLayout.addTab(tab3);

        ArrayList<Fragment> fragments=new ArrayList<>();
        //将提前写好三个Fragment添加到集合中
        //fragments.add(new Afragment());
        fragments.add(new Afragment());
        fragments.add(new Bfragment());
        //创建适配器
        String[] mTabNames=new String[]{"失物","寻主"};
        TabPageAdapter pageAdapter = new TabPageAdapter(getSupportFragmentManager(), fragments,mTabNames);

        //设置ViewPager的适配器
        mViewPager.setAdapter(pageAdapter);

        //
        mTabLayout.setupWithViewPager(mViewPager);

        //设置tablayout监听
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //修改toolbartitle
                Toast.makeText(MainActivity.this, "选中的"+tab.getText(), Toast.LENGTH_SHORT).show();
                TextView textView =findViewById(R.id.toolbar_title);
                textView.setText(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //左边栏点击事件
        my_im=findViewById(R.id.im);
        my_im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "个人信息", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,MyInfoActivity.class);
                startActivity(intent);
            }
        });

        my_tx1=findViewById(R.id.tx1);
        my_tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "我的失物贴", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,MyTieziActivity.class);
                startActivity(intent);
            }
        });

        my_tx2=findViewById(R.id.tx2);
        my_tx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "我的寻主贴", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,MyTieziActivity.class);
                startActivity(intent);
            }
        });

        my_tx3=findViewById(R.id.tx3);
        my_tx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "消息提醒", Toast.LENGTH_SHORT).show();
                //Intent intent=new Intent(toolActivity.this,explainActivity.class);
                //startActivity(intent);
            }
        });

        my_tx4=findViewById(R.id.tx4);
        my_tx4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "浏览记录", Toast.LENGTH_SHORT).show();
                //Intent intent=new Intent(toolActivity.this,explainActivity.class);
                //startActivity(intent);
            }
        });

        my_tx5=findViewById(R.id.tx5);
        my_tx5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });

        my_tx6=findViewById(R.id.tx6);
        my_tx6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "切换/注销", Toast.LENGTH_SHORT).show();
                //Intent intent=new Intent(toolActivity.this,explainActivity.class);
                //startActivity(intent);
            }
        });


    }

    //连接option栏
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    //option栏监听
    //前三个是重设之前的
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_search:
                Log.i("haha", "toolbar_search");
                return true;
            case R.id.toolbar_action1:
                Log.i("haha", "toolbar_action1");
                return true;
            case R.id.toolbar_action2:
                Log.i("haha", "toolbar_action2");
                return true;
            case android.R.id.home:
                Toast.makeText(MainActivity.this, "左边栏", Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(left);
                return true;
        }
        return true;
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.toolbar_search:
                    msg += "扫一扫";
                    AndPermission.with(MainActivity.this)
                            .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                            .onGranted(new Action() {
                                @Override
                                public void onAction(List<String> permissions) {
                                    Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                                    /*ZxingConfig是配置类
                                     *可以设置是否显示底部布局，闪光灯，相册，
                                     * 是否播放提示音  震动
                                     * 设置扫描框颜色等
                                     * 也可以不传这个参数
                                     * */
                                    ZxingConfig config = new ZxingConfig();
                                    // config.setPlayBeep(false);//是否播放扫描声音 默认为true
                                    //  config.setShake(false);//是否震动  默认为true
                                    // config.setDecodeBarCode(false);//是否扫描条形码 默认为true
//                                config.setReactColor(R.color.colorAccent);//设置扫描框四个角的颜色 默认为白色
//                                config.setFrameLineColor(R.color.colorAccent);//设置扫描框边框颜色 默认无色
//                                config.setScanLineColor(R.color.colorAccent);//设置扫描线的颜色 默认白色
                                    config.setFullScreenScan(false);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
                                    intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                                    startActivityForResult(intent, 111);
                                }
                            })
                            .onDenied(new Action() {
                                @Override
                                public void onAction(List<String> permissions) {
                                    Uri packageURI = Uri.parse("package:" + getPackageName());
                                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                                    startActivity(intent);

                                    Toast.makeText(MainActivity.this, "没有权限无法扫描呦", Toast.LENGTH_LONG).show();
                                }
                            }).start();
                    break;
                case R.id.toolbar_action1:
                    msg += "搜索";
                    break;
                case R.id.toolbar_action2:
                    msg += "发帖";
                Intent intent=new Intent(MainActivity.this,PostActivity.class);
                    startActivity(intent);
                    break;
            }

            if(!msg.equals("")) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };
    }

