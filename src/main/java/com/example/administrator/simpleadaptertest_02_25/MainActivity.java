package com.example.administrator.simpleadaptertest_02_25;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ActionBarActivity {

    private String[] names = new String[]{"虎头","弄玉","李清照","李白",};
    private String[] descs = new String[]{"可爱的小孩","一个擅长音乐的女孩","一个擅长文学的女性","浪漫主义诗人",};
    private int [] imageIds=new int[]{R.drawable.tiger,R.drawable.nongyu,R.drawable.qingzhao,R.drawable.libai};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> listItems=new ArrayList<>();
        for(int i=0;i<names.length;i++){
            Map<String,Object> listItem = new HashMap<>();
            listItem.put("header",imageIds[i]);
            listItem.put("personName",names[i]);
            listItem.put("desc",descs[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.simple_item,new String[]{"personName","header","desc"},
                new int[]{R.id.name,R.id.header,R.id.desc});
        ListView list = (ListView)findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
//为ListView的列表项的单击事件绑定时间监听器
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position]+"被单击了");
            }
        });
        ////为ListView的列表项的选中事件绑定时间监听器
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position]+"被选中了");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
