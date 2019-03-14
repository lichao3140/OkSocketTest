package com.lichao.oksockettest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.lichao.oksockettest.androidsocket.MySocketClient;


/**
 * Created by ChaoLi on 2019/3/14 0014 - 23:06
 * Email: lichao3140@gmail.com
 * Version: v1.0
 */
public class AndroidSocketActivity extends AppCompatActivity {
    final AndroidSocketActivity self = this;

    private EditText mSendET;
    private Button mSendBtn;

    private MySocketClient mySocketClient;

    protected MySocketClient getMySocketClient() {
        if (this.mySocketClient == null) {
            this.mySocketClient = new MySocketClient();
        }
        return this.mySocketClient;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMySocketClient().connect();

        mSendET = findViewById(R.id.et_send);
        mSendBtn = findViewById(R.id.btn_send);
        setListener();
    }

    private void setListener() {
        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg ="\n" + mSendET.getText().toString() + "\n";
                if (TextUtils.isEmpty(msg.trim())) {
                    return;
                }

                mySocketClient.getLocalSocketClient().sendString(msg);
                mSendET.setText("");
            }
        });
    }
}
