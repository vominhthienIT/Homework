package com.example.new_de_gk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends ListActivity {
    Button btn_thoat;
    String []danhmuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_thoat = (Button)findViewById(R.id.btn_thoat);
        showList();
        clickThoat();
    }

    public void clickThoat() {
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                ListView listView = getListView();
                String itemSelected = "";
                for (int i = 0; i < listView.getCount(); i++){
                    if(listView.isItemChecked(i)){
                        itemSelected += "\n" + danhmuc[i];
                        intent.putExtra("danhmuc",itemSelected);
                        startActivity(intent);
                    }
                }
            }
        });
    }
    public void showList() {
        //hien thi danh muc san pham
        ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setTextFilterEnabled(true);
        danhmuc = getResources().getStringArray(R.array.thucdon);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,danhmuc));
        //hien thi mon chon thong qua Toast
        String itemSelected = "Selected items: \n";
        for (int i = 0; i < listView.getCount(); i++){
            if(listView.isItemChecked(i)){
                itemSelected += listView.getItemAtPosition(i) + "\n";
            }
        }
        Toast.makeText(this, itemSelected, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onListItemClick(ListView l, View v, final int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this, "You have selected " + danhmuc[position], Toast.LENGTH_SHORT).show();
    }

}
