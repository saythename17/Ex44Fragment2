package com.icandothisallday2020.ex44fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    //fragment 가 보여줄 view 를 만들어 return 해주는 callback method

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my,container,false);
        //container 를 쓰면 view 가 붙을 사이즈를 알 수 있음

        //setArguments()로 전달된 값 받기
        Bundle bundle=getArguments();
        String name=bundle.getString("Name");
        int age=bundle.getInt("Age",0);
        Toast.makeText(getActivity(), name+"("+age+")", Toast.LENGTH_SHORT).show();
        return view;
    }
}
