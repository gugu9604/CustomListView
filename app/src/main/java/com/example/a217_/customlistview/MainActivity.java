package com.example.a217_.customlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button bucket_btn1 ;
    static ArrayList<Myitem> myItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 원하는 리스를 넣을수있다. MyItem객체가 들어가있다... 배열안에
        Myitem myItem1 = new Myitem(R.drawable.iphone, "아이폰 6S");
        myItems.add(myItem1); // 만들어 놓은 배열에 생성자를 넣어준다,
        Myitem myItem2 = new Myitem(R.drawable.samsung, "갤럭시");
        myItems.add(myItem2);
        Myitem myItem3 = new Myitem(R.drawable.windows, "윈도우 폰");
        myItems.add(myItem3);

        MyListViewAdapter myListViewAdapter = new MyListViewAdapter(this,myItems,R.layout.myitem);
        ListView listView = findViewById(R.id.listView); // 메인엑티비티에 있는 리스트뷰를 가져온다.
        listView.setAdapter(myListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(getApplicationContext(),SubActivity.class);
                //it.putExtra("positon",position);
                it.putExtra("name",myItems.get(position).itemName);
                it.putExtra("img_id",Integer.toString(myItems.get(position).itemImage));
                startActivity(it);
                finish();
            }
        });

        bucket_btn1 =findViewById(R.id.bucket_btn1);
        bucket_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplication(),BucketActivity.class);
                        startActivity(it);
                        finish();
            }
        });


    }
}
