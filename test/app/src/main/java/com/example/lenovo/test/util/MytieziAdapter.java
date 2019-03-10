package com.example.lenovo.test.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.lenovo.test.R;

import java.util.ArrayList;
import java.util.List;

public class MytieziAdapter extends RecyclerView.Adapter <MytieziAdapter.LinearViewHolder>{

    private static final int MYLIVE_MODE_CHECK = 0;
    int mEditMode = MYLIVE_MODE_CHECK;

    private Context mContext;
    private List<MyLiveList> mMyLiveList;

    public  MytieziAdapter(Context context){
        this.mContext=context;
    }

    @Override
    public MytieziAdapter.LinearViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.layout_my_tiezi,viewGroup,false);
        LinearViewHolder  holder=new LinearViewHolder(view);
        return holder;
    }

    public void notifyAdapter(List<MyLiveList> myLiveList,boolean isAdd){
        if (!isAdd){
            this.mMyLiveList=myLiveList;
        }else {
            this.mMyLiveList.addAll(myLiveList);
        }
        notifyDataSetChanged();
    }

    public List<MyLiveList> getMyLiveList(){
        if (mMyLiveList == null)  {
            mMyLiveList =new ArrayList<>();
        }
        return  mMyLiveList;
    }
    public interface OnItemClickListener {
        void onItemClickListener(int pos, List<MyLiveList> myLiveList);
    }
    public void setEditMode(int editMode) {
        mEditMode = editMode;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder( MytieziAdapter.LinearViewHolder linearViewHolder, int i) {
        final MyLiveList myLive=mMyLiveList.get(linearViewHolder.getAdapterPosition());
        linearViewHolder.textView1.setText("这是标题");
        linearViewHolder.textView2.setText("2019-3-3");
        if(mEditMode==MYLIVE_MODE_CHECK){
            linearViewHolder.mIm_check.setVisibility(View.GONE);
        }else{
            linearViewHolder.mIm_check.setVisibility(View.VISIBLE);

            if (myLive.isSelect()) {
                linearViewHolder.mIm_check.setImageResource(R.mipmap.ic_checked);
            } else {
                linearViewHolder.mIm_check.setImageResource(R.mipmap.ic_uncheck);
            }
        }
    }


    @Override
    public int getItemCount() {
        return 20;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView textView1,textView2;
        private ImageView mIm_check;
        public LinearViewHolder( View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.my_tiezi_title);
            textView2=itemView.findViewById(R.id.my_tiezi_time);
            mIm_check=itemView.findViewById(R.id.check_box);
        }
    }


}
