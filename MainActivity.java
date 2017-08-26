package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText ;
import android.widget.Toast;

import com.example.myapplication.util.UserInfoUtil;

import java.util.Map;

public class MainActivity extends Activity implements View.OnClickListener {
    private EditText et_username;
    private EditText et_key;
    private CheckBox cb_rem;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        EditText et_username =  (EditText) findViewById(R.id.et_username);
        EditText et_key =  (EditText) findViewById(R.id.et_key);
        CheckBox cb_rem =  (CheckBox) findViewById(R.id.cb_rem);
        Button bt_login =  (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
        Map<String,String> map = UserInfoUtil.getUserInfo();
        if(map!=null){
            String username = map.get("username");
            String password = map.get("password");
            et_username.setText(username);
            et_key.setText(password);
        }
    }
    private void login(){
        String username = et_username.getText().toString().trim();
        String password = et_key.getText().toString().trim();
        boolean isrem = cb_rem.isChecked();
        if (TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            Toast.makeText(mContext,"用户名密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (isrem){
            boolean result = UserInfoUtil.saveUserInfo(username,password);
            if (result){
                Toast.makeText(mContext, "用户名密码保存成功！", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(mContext, "用户名密码保存失败！", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                login();
                break;

            default:

                break;

        }
    }
}


//ceshiyixiahascfhasujcvdshv
