package com.example.a217_.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyBucketItemsAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<Myitem> myitems;
    LayoutInflater inflater;

    public MyBucketItemsAdapter(Context context, ArrayList<Myitem> myitems, int layout){
            this.context = context;
            this.layout = layout;
            this.myitems = myitems;
            this.inflater  = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

    @Override
    public int getCount() {
        return myitems.size();
    }

    @Override
    public Object getItem(int position) {
        return myitems.get(position).itemName;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(layout,parent,false);    //true 값이 들어가면 튕김
        }
        ImageView iv = convertView.findViewById(R.id.bucketImage);
        iv.setImageResource(myitems.get(position).itemImage);
        TextView tv = convertView.findViewById(R.id.bucketName);
        tv.setText(myitems.get(position).itemName);

        Button btn = convertView.findViewById(R.id.bucketbtn);
        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Toast.makeText(context,myitems.get(position).itemName +"장바구니에서 삭제 합니다",Toast.LENGTH_SHORT).show();

                BucketActivity.BucketItems.remove(myitems.get(position));
                notifyDataSetChanged();
            }

        });

        return convertView;
    }
}
