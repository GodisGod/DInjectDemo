package com.example.djumpannotation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.annotation.BindView;
import com.example.annotation.ClickEvent;
import com.example.annotation.QtInject;
import com.example.dcompiler.AndJump;
import com.example.dcompiler.DInject;

//@QtInject
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_test)
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DInject.inject(this);
    }

    @ClickEvent(R.id.tv_test)
    public void onClickTest() {
        tvTest.setText("点击测试");

        QSecondActivity.getInstance().setName("小玲").setValue(16).start(MainActivity.this, 0x05);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0x05 && resultCode == RESULT_OK) {
            tvTest.setText("返回的结果是 = " + data.getStringExtra("result"));
        }
    }

}
