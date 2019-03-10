package com.example.lenovo.test.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.test.MyTieziActivity;
import com.example.lenovo.test.R;
import com.example.lenovo.test.SettingActivity;
import com.example.lenovo.test.fatie.MyInfoActivity;
import com.example.lenovo.test.fatie.PostActivity;
import com.example.lenovo.test.fragment.Afragment;
import com.example.lenovo.test.fragment.Bfragment;
import com.example.lenovo.test.util.MytieziAdapter;

public class ListViewActivity extends AppCompatActivity {

    private ListView lv1;

    private ImageButton pop1;
    private PopupWindow popwindow1;

    private ImageButton pop2;
    private PopupWindow popwindow2;

    private ImageButton pop3;
    private PopupWindow popwindow3;


    private Button bu_fra_a;
    private Button bu_fra_b;

    private Afragment afra;
    private Bfragment bfra;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        //list
        lv1=findViewById(R.id.lv_1);
        lv1.setAdapter(new MyListAdapter(ListViewActivity.this));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,"你点击的是第"+position+"条信息",Toast.LENGTH_SHORT).show();
            }
        });


        //pop
        pop1=findViewById(R.id.Navigation);
        pop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=getLayoutInflater().inflate(R.layout.navigation_pop1,null);

                ImageButton im=view.findViewById(R.id.pop_im);
                im.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popwindow1.dismiss();
                        //do
                        Intent intent=new Intent(ListViewActivity.this,MyInfoActivity.class);
                        startActivity(intent);
                        Toast.makeText(ListViewActivity.this,"个人信息",Toast.LENGTH_SHORT).show();
                    }
                });

                TextView t1=view.findViewById(R.id.nav_tv_find);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popwindow1.dismiss();
                        Intent intent=new Intent(ListViewActivity.this,MyTieziActivity.class);
                        startActivity(intent);
                        //do
                        Toast.makeText(ListViewActivity.this,"test1",Toast.LENGTH_SHORT).show();
                    }
                });

                TextView t2=view.findViewById(R.id.nav_tv_lost);
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popwindow1.dismiss();
                        Intent intent=new Intent(ListViewActivity.this,MyTieziActivity.class);
                        startActivity(intent);
                        //do
                        Toast.makeText(ListViewActivity.this,"test2",Toast.LENGTH_SHORT).show();
                    }
                });

                TextView t3=view.findViewById(R.id.nav_tv_remind);
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popwindow1.dismiss();
                        //do
                        Toast.makeText(ListViewActivity.this,"test3",Toast.LENGTH_SHORT).show();
                    }
                });

                TextView t4=view.findViewById(R.id.nac_tv_record);
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popwindow1.dismiss();
                        //do
                        Toast.makeText(ListViewActivity.this,"test4",Toast.LENGTH_SHORT).show();
                    }
                });
                TextView t5=view.findViewById(R.id.nav_tv_setting);
                t5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popwindow1.dismiss();
                        Intent intent=new Intent(ListViewActivity.this,SettingActivity.class);
                        startActivity(intent);
                        //do
                        Toast.makeText(ListViewActivity.this,"test5",Toast.LENGTH_SHORT).show();
                    }
                });
                TextView t6=view.findViewById(R.id.nav_tv_change);
                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popwindow1.dismiss();
                        //do
                        Toast.makeText(ListViewActivity.this,"test6",Toast.LENGTH_SHORT).show();
                    }
                });

                popwindow1=new PopupWindow(view,400,ViewGroup.LayoutParams.WRAP_CONTENT);
                popwindow1.setOutsideTouchable(true);
                popwindow1.setFocusable(true);
                popwindow1.showAsDropDown(pop1);
            }
        });

        pop2=findViewById(R.id.QR);
        pop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=getLayoutInflater().inflate(R.layout.qr_pop,null);

                TextView t1=view.findViewById(R.id.QR_tv_scanning);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popwindow2.dismiss();
                        //do
                        Toast.makeText(ListViewActivity.this,"2test1",Toast.LENGTH_SHORT).show();
                    }
                });

                TextView t2=view.findViewById(R.id.QR_tv_my);
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popwindow2.dismiss();
                        //do
                        Toast.makeText(ListViewActivity.this,"2test2",Toast.LENGTH_SHORT).show();
                    }
                });

                popwindow2=new PopupWindow(view,pop2.getWidth(),ViewGroup.LayoutParams.WRAP_CONTENT);
                popwindow2.setOutsideTouchable(true);
                popwindow2.setFocusable(true);
                popwindow2.showAsDropDown(pop2);
            }
        });

        pop3=findViewById(R.id.gongneng);
        pop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=getLayoutInflater().inflate(R.layout.gongneng_pop,null);

                TextView t1=view.findViewById(R.id.GG_tv_fatie);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popwindow3.dismiss();
                        Intent intent=new Intent(ListViewActivity.this,PostActivity.class);
                        startActivity(intent);
                        //do
                        Toast.makeText(ListViewActivity.this,"3test1",Toast.LENGTH_SHORT).show();
                    }
                });

                TextView t2=view.findViewById(R.id.GG_tv_search);
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popwindow3.dismiss();
                        //do
                        Toast.makeText(ListViewActivity.this,"3test2",Toast.LENGTH_SHORT).show();
                    }
                });

                TextView t3=view.findViewById(R.id.te_3);
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popwindow3.dismiss();
                        //do
                        Toast.makeText(ListViewActivity.this,"3test3",Toast.LENGTH_SHORT).show();
                    }
                });

                popwindow3=new PopupWindow(view,pop3.getWidth(),ViewGroup.LayoutParams.WRAP_CONTENT);
                popwindow3.setOutsideTouchable(true);
                popwindow3.setFocusable(true);
                popwindow3.showAsDropDown(pop3);
            }
        });
        //
        bu_fra_a=findViewById(R.id.bu_fra_a);
        bu_fra_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(afra==null)
                {
                    afra=new Afragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fra_con,afra).commitNowAllowingStateLoss();
            }
        });

        bu_fra_b=findViewById(R.id.bu_fra_b);
        bu_fra_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bfra==null)
                {
                    bfra=new Bfragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fra_con,bfra).commitNowAllowingStateLoss();
            }
        });
        //fragment

        afra=new Afragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fra_con,afra).commitNowAllowingStateLoss();

    }
}
