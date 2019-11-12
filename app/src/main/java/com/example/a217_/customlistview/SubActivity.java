package com.example.a217_.customlistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SubActivity extends Activity {


    ImageView detail_img;
    TextView detail_name;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        detail_img = findViewById(R.id.detail_img);
        detail_name = findViewById(R.id.detail_name);

        Intent it = getIntent();
        String name = it.getStringExtra("name");
        int Img = Integer.parseInt(it.getStringExtra("img_id"));

        detail_img.setImageResource(Img);
        detail_name.setText(name);


    }
}
