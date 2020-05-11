package com.example.feame3.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.feame3.R;
import com.example.feame3.base.BaseActivity;
import com.example.feame3.base.BasePresenter;
import com.example.feame3.home.view.HomeActivity;
import com.example.feame3.login.bean.AffirmRegisterBean;
import com.example.feame3.login.contract.AffirmContart;
import com.example.feame3.login.presenter.AffirmRegisterPresenter;
import com.tencent.mmkv.MMKV;

public class AffirmRegisterActivity extends BaseActivity<AffirmRegisterPresenter> implements AffirmContart.IAffirmView {

    private EditText affreg_passward;
    private EditText affreg_affirmpassward;
    private Button arrirm_regbug;
    private String phoneMub;

    @Override
    protected AffirmRegisterPresenter initPresenter() {
        return new AffirmRegisterPresenter();
    }

    @Override
    public void initView() {

        affreg_passward = findViewById(R.id.affreg_passward);
        affreg_affirmpassward = findViewById(R.id.affreg_affirmpassward);
        arrirm_regbug = findViewById(R.id.arrirm_regbug);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        phoneMub = intent.getStringExtra("phoneNum");

    }

    @Override
    public void initLinstener() {
        arrirm_regbug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断两个密码是否相同。相同调用接口
                //手机号需要传过来
                String passw = affreg_passward.getText().toString();
                String affirmPass = affreg_affirmpassward.getText().toString();
                if (!TextUtils.isEmpty(passw) && !TextUtils.isEmpty(affirmPass)) {
                    //判断两个密码是否一样
                    if (passw.equals(affirmPass)) {
                        mPresenter.register(phoneMub, passw, affirmPass);

                    }

                } else
                    Toast.makeText(AffirmRegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                //判断密码长度是否大于6，两次密码输入是否相同
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_affirm_register;
    }

    @Override
    public void registerResult(AffirmRegisterBean affirmRegisterBean) {
        Log.i("TAG", "registerResult: 注册成功返回值" + affirmRegisterBean.toString());
        if (affirmRegisterBean.getCode() == 1) {
            Toast.makeText(this, "注册成功返回数据，且code等于1", Toast.LENGTH_SHORT).show();
            if (null != affirmRegisterBean.getData().getToken().getValue() && affirmRegisterBean.getData().getToken().getValue()!=""){
                MMKV mmkv = MMKV.defaultMMKV();
//                用户信息 在本储存了

                mmkv.encode("token",affirmRegisterBean.getData().getToken().getValue());
                mmkv.encode("expire_time",affirmRegisterBean.getData().getToken().getExpire_time());
                mmkv.encode("head_url",affirmRegisterBean.getData().getUser_info().getHead_url());
                mmkv.encode("nickname",affirmRegisterBean.getData().getUser_info().getNickname());
                mmkv.encode("mobile",affirmRegisterBean.getData().getUser_info().getMobile());


                Intent intent = new Intent(AffirmRegisterActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, affirmRegisterBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
