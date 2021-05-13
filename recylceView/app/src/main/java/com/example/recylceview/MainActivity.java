package com.example.recylceview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_view;
    private MyAdapter adapter;
    private ArrayList<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 準備資料，塞50個項目到ArrayList裡
        for(int i = 0; i < 50; i++) {
            mData.add("項目"+i);
        }

        // 連結元件
        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        // 設置RecyclerView為列表型態
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        // 設置格線
        recycler_view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        Button btnAdd = findViewById(R.id.btnAdd);

//        recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
// Grid型態，第二個參數控制一列顯示幾項
        recycler_view.setLayoutManager(new GridLayoutManager(this, 2));
        recycler_view.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        // 將資料交給adapter
        adapter = new MyAdapter(mData);
        // 設置adapter給recycler_view
        recycler_view.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 新增一個項目
                adapter.addItem("New Item");
            }
        });
    }
}