package org.iii.tw.mylistv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class List2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String[] dataset = {"item1","item2","item3","item4","item5","item6"};
    private LinkedList<String>data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        data = new LinkedList<>();
        for(String s : dataset){
            data.add(s);
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclervuew);
    }
}
