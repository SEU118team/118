package com.example.lenovo.test.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.test.R;

public class MyListAdapter2 extends BaseAdapter {

    private Context mcontext;
    private LayoutInflater minflater;

    public MyListAdapter2(Context context) {
        this.mcontext = context;
        minflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHoder{
        private ImageView im;
        private TextView te_1;
        private TextView te_2;
        private TextView te_3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder holder=null;
        if(convertView==null) {
            convertView = minflater.inflate(R.layout.list_item, null);
            holder=new ViewHoder();
            holder.im=convertView.findViewById(R.id.im);
            holder.te_1=convertView.findViewById(R.id.text_1);
            holder.te_2=convertView.findViewById(R.id.text_2);
            holder.te_3=convertView.findViewById(R.id.text_3);
            convertView.setTag(holder);
        }
        else{
            holder=(ViewHoder) convertView.getTag();
        }
        //fuzhi
        holder.te_1.setText("这是一个寻主帖子");
        //holder.im.setImageDrawable(Drawable.createFromPath("@drawable/person.png"));
        return convertView;
    }
}
