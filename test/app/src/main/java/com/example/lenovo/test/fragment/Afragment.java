package com.example.lenovo.test.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.test.R;
import com.example.lenovo.test.listview.ListViewActivity;
import com.example.lenovo.test.listview.MyListAdapter;

public class Afragment extends Fragment {

    private TextView a_te;
    private ListView lv1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_a,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        a_te=view.findViewById(R.id.a_fra_text);
        lv1=view.findViewById(R.id.a_list);
        lv1.setAdapter(new MyListAdapter(this.getActivity()));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Afragment.this.getActivity(),"失物:你点击的是第"+position+"条信息",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
