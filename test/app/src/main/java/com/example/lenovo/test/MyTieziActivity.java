package com.example.lenovo.test;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.test.util.MyLiveList;
import com.example.lenovo.test.util.MytieziAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyTieziActivity extends AppCompatActivity {

    private static final int MYLIVE_MODE_CHECK = 0;
    private static final int MYLIVE_MODE_EDIT = 1;
    private List<MyLiveList> mList = new ArrayList<>();
    private RecyclerView mRc_mytiezi;
    private TextView mTv_edite,mTv_selectednumber,mTv_selectall;
    private LinearLayout mLL_bottom;
    private Button mBt_delet;
    private MytieziAdapter mTieziAdapter=null;
    private int mEditMode = MYLIVE_MODE_CHECK;
    private boolean isSelectAll = false;
    private boolean editorStatus = false;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tiezi);
        mTieziAdapter=new MytieziAdapter(this);
        mRc_mytiezi= findViewById(R.id.mytiezi_rc);
        mTv_edite=findViewById(R.id.tv_editor);
        mLL_bottom=findViewById(R.id.Ln_bottom);
        mTv_selectednumber=findViewById(R.id.tv_select_num);
        mTv_selectall=findViewById(R.id.tv_select_all);
        mBt_delet=findViewById(R.id.btn_delete);
        setListener();
        mRc_mytiezi.setLayoutManager(new LinearLayoutManager(MyTieziActivity.this));
        mRc_mytiezi.setAdapter(mTieziAdapter);
        mRc_mytiezi.addItemDecoration(new Mydecoration());
        for (int i = 0; i < 30; i++) {
            MyLiveList myLiveList = new MyLiveList();
            myLiveList.setTitle("这是第" + i + "个条目");
            myLiveList.setSource("来源" + i);
            mList.add(myLiveList);
            mTieziAdapter.notifyAdapter(mList, false);
        }
    }

    private void setListener(){
        OnClick onClick=new OnClick();
        mTv_edite.setOnClickListener(onClick);
        mBt_delet.setOnClickListener(onClick);
        mTv_selectall.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_delete:
                    deleteVideo();
                    break;
                case R.id.tv_select_all:
                    selectAllMain();
                    break;
                case R.id.tv_editor:
                    updataEditMode();
                    break;
                default:
                    break;
            }
        }
    }
    /**
     * 全选和反选
     */
    private void selectAllMain() {
        if (mTieziAdapter == null) return;
        if (!isSelectAll) {
            for (int i = 0, j = mTieziAdapter.getMyLiveList().size(); i < j; i++) {
                mTieziAdapter.getMyLiveList().get(i).setSelect(true);
            }
            index = mTieziAdapter.getMyLiveList().size();
            mBt_delet.setEnabled(true);
            mTv_selectall.setText("取消全选");
            isSelectAll = true;
        } else {
            for (int i = 0, j = mTieziAdapter.getMyLiveList().size(); i < j; i++) {
                mTieziAdapter.getMyLiveList().get(i).setSelect(false);
            }
            index = 0;
            mBt_delet.setEnabled(false);
            mTv_selectall.setText("全选");
            isSelectAll = false;
        }
        mTieziAdapter.notifyDataSetChanged();
        setBtnBackground(index);
        mTv_selectednumber.setText(String.valueOf(index));
    }

    private  void deleteVideo(){

    }
    //点击编辑的时候显示,顺便调mAdapter.setEditMode(mEditMode);赋值
    private void updataEditMode() {
        mEditMode = mEditMode == MYLIVE_MODE_CHECK ? MYLIVE_MODE_EDIT : MYLIVE_MODE_CHECK;
        if (mEditMode == MYLIVE_MODE_EDIT) {
            mTv_edite.setText("取消");
            mLL_bottom.setVisibility(View.VISIBLE);
            editorStatus = true;
        } else {
            mTv_edite.setText("编辑");
            mLL_bottom.setVisibility(View.GONE);
            editorStatus = false;
            clearAll();
        }
        mTieziAdapter.setEditMode(mEditMode);
    }

    private void clearAll() {
        mTv_selectednumber.setText(String.valueOf(0));
        isSelectAll = false;
        mTv_selectall.setText("全选");
        setBtnBackground(0);
    }

    private void setBtnBackground(int size) {
        if (size != 0) {
            mBt_delet.setBackgroundResource(R.drawable.mytiezi_button_shape);
            mBt_delet.setEnabled(true);
            mBt_delet.setTextColor(Color.WHITE);
        } else {
            mBt_delet.setBackgroundResource(R.drawable.mytiezi_button_noclickable_shape);
            mBt_delet.setEnabled(false);
            mBt_delet.setTextColor(ContextCompat.getColor(this, R.color.color_b7b8bd));
        }
    }




    class Mydecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}
