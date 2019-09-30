package com.example.new_de_gk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_loai,btn_luu;
    EditText maso;
    TextView danhmuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect();
        OnclickLoaiThucUong();
        try {
            String data = getIntent().getExtras().getString("danhmuc");
            danhmuc.setText("Danh Mục Mà Bạn Đã Chọn Là :"+"\n"+data);
        }catch (Exception e){
            e.printStackTrace();
        }
        OnclickLuuFile();

    }

    public void OnclickLuuFile() {
        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maban = maso.getText().toString();
                String danhmuc_luu = danhmuc.getText().toString();
                String thongtin ="Mã Bàn:"+""+maban +""+"Danh sách thức uống"+""+ danhmuc_luu;
                try {
                    //Internal Storage
                    FileOutputStream fout = openFileOutput(thongtin, Context.MODE_PRIVATE);
                    fout.write(thongtin.toString().getBytes());
                    fout.close();
                    Toast.makeText(MainActivity.this, "Save file successfully!", Toast.LENGTH_SHORT).show();
                    xoatrang();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error save file !", Toast.LENGTH_SHORT).show();
                    xoatrang();
                }
            }
        });

    }

    public void OnclickLoaiThucUong() {
        btn_loai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    public void connect() {
        btn_loai = (Button)findViewById(R.id.btn_loai);
        btn_luu = (Button)findViewById(R.id.btn_luu);
        maso = (EditText)findViewById(R.id.maso);
        danhmuc =(TextView)findViewById(R.id.danhmuc);
    }
    public void xoatrang(){
        maso.setText("");
        danhmuc.setText("");
    }

}
