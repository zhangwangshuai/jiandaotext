package com.example.feame3.login.view;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.feame3.R;
import com.example.feame3.base.BaseActivity;
import com.example.feame3.login.bean.VerfiedBean;
import com.example.feame3.login.contract.RegisterMSMContract;
import com.example.feame3.login.presenter.RegisiterMSMPresenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterMSMCodeActivity extends BaseActivity <RegisiterMSMPresenter> implements RegisterMSMContract.IRegisterMSMView {
    private EditText reg_phone_num;
    private EditText reg_vdeified;
    private Button reg_send_vdeified;
    private Button reg_but;
    private String reg_edit_sms_code;
    private String reg_edit_phone_num;
    @Override
    protected RegisiterMSMPresenter initPresenter() {
        return new RegisiterMSMPresenter();
    }

    @Override
    public void initView() {
        reg_phone_num = findViewById(R.id.reg_phone_num);
        reg_vdeified = findViewById(R.id.reg_vdeified);
        reg_send_vdeified = findViewById(R.id.reg_send_vdeified);
        reg_but = findViewById(R.id.reg_but);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initLinstener() {
        //获取验证码
        reg_send_vdeified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = reg_phone_num.getText().toString();
                //判断手机号是否为空
                if (!TextUtils.isEmpty(phone) && isMobileNO(phone)) {
                    //发送验证码  type 1表示注册发送验证码
                    mPresenter.getVerifend(phone, "1");
                } else {
                    Toast.makeText(RegisterMSMCodeActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //注册
        reg_but.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                reg_edit_phone_num = reg_phone_num.getText().toString();
                reg_edit_sms_code = reg_vdeified.getText().toString();
                if (!TextUtils.isEmpty(reg_edit_phone_num)&& isMobileNO(reg_edit_phone_num)){
                    if (!TextUtils.isEmpty(reg_edit_sms_code)){
                        Pattern pattern = Pattern.compile("\\d{6}");
                        boolean matches = pattern.matcher(reg_edit_sms_code).matches();
                        if (matches) {
                            Log.i("TAG", "onClick: 验证码值"+reg_edit_sms_code);
//提交到服务器
                            mPresenter.checkSmsCode(reg_edit_phone_num, reg_edit_sms_code, "1");
                        }
                    }
                }
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_register_smscode;
    }
    //手机验证码工具类
    public static boolean isMobileNO(String mobiles) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9]))\\d{8}$");
            Matcher m = p.matcher(mobiles);
            flag = m.matches();
        } catch (Exception e) {
//            LOG.error("验证手机号码错误", e);
            Log.e("TAG", "手机号错误" + e.getMessage());
            flag = false;
        }
        return flag;
    }

    @Override
    public void getVeridied(VerfiedBean s) {
//返回验证码
        if (s.getCode()==1){
            Toast.makeText(this, "验证码发送成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "验证码发送失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getLoginResylt(String string) {
    }

    @Override
    public void checkSmsCodeResult(VerfiedBean verfiedBean) {
        if (verfiedBean.getCode()==1){
//挑战注册页面
            Intent intent = new Intent(this, AffirmRegisterActivity.class);
            intent.putExtra("phoneNum",reg_edit_phone_num);
            startActivity(intent);
        }
    }
}
