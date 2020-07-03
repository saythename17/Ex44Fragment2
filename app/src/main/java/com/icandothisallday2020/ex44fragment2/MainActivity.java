package com.icandothisallday2020.ex44fragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {

        manager=getSupportFragmentManager();
        //Transaction: rollback 기능이 있는 작업단위
        FragmentTransaction tran=manager.beginTransaction();//가상작업시작
        //Transaction 을 통해 작업 수행
        // --수행과정 중 오류가 발생하면 원상복귀됨
        MyFragment fragment=new MyFragment();
        //fragment 동적 추가시 데이터 전달
        Bundle bundle=new Bundle();
        bundle.putString("Name","PDH");
        bundle.putInt("Age",29);
        fragment.setArguments(bundle);
        tran.add(R.id.container,fragment);
        //※※R.id.container 인 LinearLayout 에 MyFragment 를 동적 추가※※
        //tran.remove(fragment);-제거/tran.replace(R.id.container,fragment2);-교체
        //fragment 를 BackStack 에 추가 ->뒤로가기를 눌러도 Activity 가 바로 꺼지지 않음
        tran.addToBackStack(null);//조각 생성/소멸//null:fragment 식별명
        tran.commit();//Transaction 이 완료됨을 명시하면 작업완료
    }
}











