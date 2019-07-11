package com.ssb.app0711;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

public class SpriteActivity extends AppCompatActivity {
    class MyView extends View {
        //사용자 정의 뷰 클래스
        //생성자를 재정의 해서 상위 클래스의 생성자를 호출해 주어야 합니다.
        //onDraw메소드에 화면에 출력할 코드를 작성
        public MyView(Context context){
            super(context);
        }
        //화면이 보여질 때 화면에 그리는 메소드
        public void onDraw(Canvas canvas){
            //Paint객체 생성
            Paint paint = new Paint();
            canvas.drawColor(Color.YELLOW);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.img);
            //drawBitmap메소드느 여러 형태로 오버로딩되어 있어서
            //원하는 만큼 잘라서 원하는 크기록 출력하는 메소드도 소유하고 있습니다.
            //이런 메소드들을 이용하면 이미지를 잘러서 출력할 수 있습니다.
            canvas.drawBitmap(bitmap,new Rect(0,0,400,400),new Rect(0,0,200,200),paint);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(SpriteActivity.this);
        setContentView(myView);
    }
}
