package com.gwtravel.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.gwtravel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ModifyPswActivity extends BaseActivity {

    @BindView(R.id.et_old_psw)
    EditText et_old_psw;//原始密码
    @BindView(R.id.et_new_psw)
    EditText et_new_psw;//新密码
    @BindView(R.id.et_new_psw_re)
    EditText et_new_psw_re;
    private String old_psw,new_psw,new_psw_re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_psw);
        ButterKnife.bind(this);
        init();

    }

    private void init() {

    }


    @OnClick({R.id.btn_back,R.id.btn_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;

            case R.id.btn_sure:
                //  上传修改信息
                old_psw=et_old_psw.getText().toString().trim();
                new_psw=et_new_psw.getText().toString().trim();
                new_psw_re=et_new_psw_re.getText().toString().trim();
                if(!old_psw.equals("") && !new_psw.equals("") && !new_psw_re.equals("")){
                    if(old_psw.equals(new_psw)){
//                        ToastUtils.ToastUtils(ModifyPswActivity.this, "新密码不能和旧密码一致，请重新输入");
                    }else {
                        if (new_psw.equals(new_psw_re) && (new_psw.length()>5 && new_psw.length()<13) && (new_psw_re.length()>5 && new_psw_re.length()<13) ) {

                            modifyPsw();

                        } else {

                        }
                    }
                }else{

                }

                break;

        }
    }

    private void modifyPsw() {


    }

}
