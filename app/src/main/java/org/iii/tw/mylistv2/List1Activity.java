package org.iii.tw.mylistv2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class List1Activity extends AppCompatActivity {
    private ListView list1;
    private MyAdapter adapter;

    private String[] dataset = {"item1","item2","item3","item4","item5","item6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1);

        list1 = (ListView)findViewById(R.id.list1);
        adapter = new MyAdapter();
        list1.setAdapter(adapter);
    }

    private class MyAdapter extends BaseAdapter{
        private LayoutInflater inflater;

        public MyAdapter() {
            inflater = LayoutInflater.from(List1Activity.this);
        }

        @Override
        public int getCount() {
            return dataset.length;
        }

        @Override
        public Object getItem(int position) {
            return dataset[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = inflater.inflate(R.layout.layout_itemv1,parent,false);
            }
            TextView title = (TextView) convertView.findViewById(R.id.itemv1_title);
            title.setText(dataset[position]);

            if (position%2 == 0){
                convertView.setBackgroundColor(Color.YELLOW);
                title.setTextColor(Color.CYAN);
            }else {
                convertView.setBackgroundColor(Color.BLUE);
                title.setTextColor(Color.GRAY);
            }

            return convertView;
        }
    }
}
