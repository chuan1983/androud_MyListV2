package org.iii.tw.mylistv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

import io.github.codefalling.recyclerviewswipedismiss.SwipeDismissRecyclerViewTouchListener;

public class List2Activity extends AppCompatActivity {

    private RecyclerView recycler;
    private String[] dataset = {"item1","item2","item3","item4","item5","item6"};
    private LinkedList<String>data;
    private LinearLayoutManager mLayoutManager;
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        data = new LinkedList<>();
        for(String s : dataset){
            data.add(s);
        }

        recycler = (RecyclerView) findViewById(R.id.recyclerview);

        mLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        adapter = new MyAdapter();
        recycler.setAdapter(adapter);

        SwipeDismissRecyclerViewTouchListener listener = new SwipeDismissRecyclerViewTouchListener.Builder(
                recycler,
                new SwipeDismissRecyclerViewTouchListener.DismissCallbacks() {
                    @Override
                    public boolean canDismiss(int position) {
                        return true;
                    }

                    @Override
                    public void onDismiss(View view) {
                        // Do what you want when dismiss
                        int p = recycler.getChildPosition(view);
                        data.remove(p);
                        adapter.notifyDataSetChanged();
                    }
                })
                .setIsVertical(false)
                .setItemTouchCallback(
                        new SwipeDismissRecyclerViewTouchListener.OnItemTouchCallBack() {
                            @Override
                            public void onTouch(int index) {
                                // Do what you want when item be touched
                            }
                        })
                .setItemClickCallback(new SwipeDismissRecyclerViewTouchListener.OnItemClickCallBack() {
                    @Override
                    public void onClick(int position) {
                        // Do what you want when item be clicked                    }
                    }})
                .setBackgroundId(R.drawable.android, R.drawable.android)
                .create();

        recycler.setOnTouchListener(listener);
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextView;
            public MyViewHolder(View v) {
                super(v);
                mTextView = (TextView) v.findViewById(R.id.itemv2_title);
            }

        }
//        public MyAdapter() {
//        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // brad
            View view = View.inflate(List2Activity.this,
                    R.layout.layout_itemv2,null);

            // google
//            View view = LayoutInflater.from(List2Activity.this)
//                    .inflate(R.layout.layout_itemv2, parent, false);

            MyViewHolder holder = new MyViewHolder(view);

            return holder;
        }


        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.mTextView.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

}
