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

public class MyListViewAdapter extends BaseAdapter {

    Context context;    // 현제엑티비티를 가리키는 역활!
    int layout;         // 만들어 놓은 xml을 연결한다.
    ArrayList<Myitem> myitems;  //메인에서 만들어놨었던 리소를 배열에 넣어준다.
    LayoutInflater inflater;    // 클릭하면 해당되는 부분만 보여준다.

    public MyListViewAdapter(Context context,ArrayList<Myitem> myitems,int layout){
                                            // 보여줄부분                    어떻게 보여주는지
            this.context = context;
            this.layout = layout;
            this.myitems = myitems;
            this.inflater  = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

    @Override
    public int getCount() {
        return myitems.size();
    } // 보여질 갯수!

    @Override
    public Object getItem(int position) {
        return myitems.get(position).itemName;  // 아이템의 이름값으로 리턴해준다.

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // 보여주는 부분!! 으로 제일중요하다.
        if(convertView == null){    // 객체가 없을때는 만들어준다!
            convertView = inflater.inflate(layout,parent,false);    //true 값이 들어가면 튕김
        }
        ImageView iv = convertView.findViewById(R.id.itemImage);
        iv.setImageResource(myitems.get(position).itemImage);
        TextView tv = convertView.findViewById(R.id.itemName);
        tv.setText(myitems.get(position).itemName);

        Button btn = convertView.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Toast.makeText(context,myitems.get(position).itemName +"장바구니에 넣었습니다",Toast.LENGTH_SHORT).show();

                BucketActivity.BucketItems.add(myitems.get(position));

            }

        });

        return convertView;
    }
}
