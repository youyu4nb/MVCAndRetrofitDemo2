package com.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofittest.Bean.Phone;
import com.example.retrofittest.model.OnPhoneListener;
import com.example.retrofittest.model.PhoneModelImlp;

public class MainActivity extends AppCompatActivity implements OnPhoneListener {

    private TextView tvShow;
    private Button btn;
    private EditText phoneNum;
    private PhoneModelImlp phoneModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneModel = new PhoneModelImlp();
        initView();
    }

    public void initView(){
        tvShow = findViewById(R.id.tv_show);
        btn = findViewById(R.id.btn_request);
        phoneNum = findViewById(R.id.phone_number);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = phoneNum.getText().toString();
                phoneModel.getPhone(phone,MainActivity.this);
            }
        });
    }

    public void setView(Phone phone){
        tvShow.setText(phone.getResult().toString());
    }


    @Override
    public void onSuccess(Phone phone) {
        setView(phone);
    }

    @Override
    public void onError() {
        Toast.makeText(this, "出错了哦！", Toast.LENGTH_SHORT).show();
    }
}
