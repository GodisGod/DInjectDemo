package com.example.djumpannotation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.annotation.BindView;
import com.example.annotation.QJump;
import com.example.dcompiler.DInject;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.tv_name)
    TextView tvName;

    @QJump
    String name;

    @QJump
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        DInject.inject(this);

        QSecondActivity.inject(this);

        tvName.setText(name + "  " + value);

        FragmentTest fragmentTest = QFragmentTest.getInstance().setName("不错嘛").setValue(18).build();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fragmentTest);
        transaction.commitAllowingStateLoss();

        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("result", "喜欢你哦❤️");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }


}
