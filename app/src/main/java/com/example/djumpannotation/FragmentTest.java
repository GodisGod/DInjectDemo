package com.example.djumpannotation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.annotation.BindView;
import com.example.annotation.QJump;
import com.example.dcompiler.DInject;

public class FragmentTest extends Fragment {

    @BindView(R.id.tv_name_value)
    TextView tvNameAndValue;

    @QJump
    String name;

    @QJump
    int value;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_fragment, container, false);
        DInject.inject(this, view);

        getContext();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        QFragmentTest.inject(this);

        tvNameAndValue.setText(name + "  年龄: " + value);


    }

}
