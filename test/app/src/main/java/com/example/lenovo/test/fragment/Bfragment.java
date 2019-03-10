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
import com.example.lenovo.test.listview.MyListAdapter;
import com.example.lenovo.test.listview.MyListAdapter2;

public class Bfragment extends Fragment {

    private TextView b_te;
    private ListView lv1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_b,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        b_te=view.findViewById(R.id.b_fra_text);

        lv1=view.findViewById(R.id.b_list);
        lv1.setAdapter(new MyListAdapter2(this.getActivity()));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Bfragment.this.getActivity(),"寻主:你点击的是第"+position+"条信息",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
