package com.nmbb.vlc.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.nmbb.vlc.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListviewActivity extends Activity {

//    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView mLv = (ListView)findViewById(R.id.lv_show);

//        adapter=new MyAdapter(this, mlist,R.layout.item_list);
        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.item_list,
                new String[]{"title","info","img"},
                new int[]{R.id.title,R.id.info,R.id.img});

        mLv.setAdapter(adapter);

//        mLv.setDivider(new ColorDrawable(Color.parseColor("#30F0F0F0")));
//        mLv.setDividerHeight(1);
        mLv.setOnItemClickListener(new MyOnItemClickListener());
    }

    private class MyOnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
            Map<String,Object> map =  (Map<String, Object>) parent.getItemAtPosition(position);
            Toast.makeText(ListviewActivity.this,"点击" + map.get("title").toString(),Toast.LENGTH_SHORT).show();
        }
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "G1");
        map.put("info", "google 1");
        map.put("img", R.drawable.img01);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G2");
        map.put("info", "google 2");
        map.put("img", R.drawable.img01);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G3");
        map.put("info", "google 3");
        map.put("img", R.drawable.img01);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G4");
        map.put("info", "google 4");
        map.put("img", R.drawable.img01);
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("title", "G5");
        map.put("info", "google 5");
        map.put("img", R.drawable.img01);
        list.add(map);

        for(int i=6;i<25;i++){
            map = new HashMap<String, Object>();
            map.put("title", "G" + i);
            map.put("info", "google " + i);
            map.put("img", R.drawable.img01);
            list.add(map);
        }

        return list;
    }

}
