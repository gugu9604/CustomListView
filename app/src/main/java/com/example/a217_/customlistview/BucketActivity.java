package com.example.a217_.customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class BucketActivity extends AppCompatActivity {
    //장바구니 데이터
    static  ArrayList<Myitem> BucketItems = new ArrayList<>();
    Button bucket_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket);

        MyBucketItemsAdapter myBucketItemsAdapter = new MyBucketItemsAdapter(this,BucketItems,R.layout.mybucket);
        ListView bucket_listview = findViewById(R.id.bucket_listView);
        bucket_listview.setAdapter(myBucketItemsAdapter);

        bucket_btn = findViewById(R.id.bucket_btn);

        bucket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplication(),MainActivity.class);
                startActivity(it);

                finish();
            }
        });

        /*MyListViewAdapter myListViewAdapter = new MyListViewAdapter(this,BucketItems,R.layout.myitem);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(myListViewAdapter);*/


    }
}
