package com.example.student.vmt_cau1a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText taikhoan, matkhau;
    CheckBox luu;
    Button dangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect();
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(luu.isChecked()){
                    ShowSave();
                }
                else
                    ShowNotSave();
            }
        });
    }
    public void connect(){
        taikhoan  = (EditText)findViewById(R.id.taikhoan);
        matkhau  = (EditText)findViewById(R.id.matkhau);
        luu = (CheckBox)findViewById(R.id.luu);
        dangnhap = (Button)findViewById(R.id.dangnhap);
    }
    public void ShowSave(){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Chú ý");
        alertBuilder.setMessage("Chào mừng bạn đăng nhập hệ thống, thông tin của bạn đã được lưu");
        alertBuilder.show();
    }
    public void ShowNotSave(){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Chú ý");
        alertBuilder.setMessage("Chào mừng bạn đăng nhập hệ thống, thông tin của bạn không được lưu");
        alertBuilder.show();
    }

}
