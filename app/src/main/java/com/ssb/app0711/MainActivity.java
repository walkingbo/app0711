package com.ssb.app0711;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //액션 바 가져오기-show나 hide를 이용해서 보이게 하고 숨길 수 있습니다.
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.drawable.icon);


        imageView =(ImageView)findViewById(R.id.imageview);
        //imageView가 컨텍스트 메뉴를 사용할 수 있도록 설정
        registerForContextMenu(imageView);
    }

    //문자열을 받아서 토스트로 출력해주는 메소드
    private void toast(String message){
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
    }

    //컨텍스트 메뉴를 만들어주는 메소드를 재정의
    //두번 째 매개변수가 컨텍스트 메뉴를 사용하는 뷰
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.add(0,0,0,"서버전송");
        menu.add(0,1,0,"로컬에 저장");
        menu.add(0,2,0,"삭제");
    }

    //컨텍스트 메뉴를 눌렀을 때 호출될 메소드
    @Override
    public boolean onContextItemSelected(MenuItem item){
        //메뉴의 id를 이용해서 분기
        switch (item.getItemId()){
            case 0:
                toast("서버에 전송합니다.");
                break;
            case 1:
                toast("로컬에 저장합니다.");
                break;
            case 2:
                toast("삭제 합니다.");
                break;
        }

        return true;
    }

    //메뉴를 만들어주는 메소드
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mene_lab,menu);

        return true;
    }

    //메뉴를 선택했을 때 호출되는 메소드
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu1:
                toast("메뉴1 선택");
                break;
            case R.id.menu2:
                toast("메뉴2 선택");
                break;
            case R.id.sub1:
                toast("서브메뉴1 선택");
                break;
            case R.id.sub2:
                toast("서브메뉴2 선택");
                break;
        }
        return true;
    }


}
