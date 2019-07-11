package com.ssb.app0711;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class CustomActivity extends AppCompatActivity {
    //점의 좌표를 저장할 클래스
     class Vertex{
        float x;
        float y;
        boolean isDraw;

        Vertex(float x, float y, boolean isDraw){
            this.x =x;
            this.y=y;
            this.isDraw =isDraw;
        }
    }

    //점의 좌표를 저장할 리스트
    ArrayList<Vertex> list;

    //화면에서 터치를 하고 드래그 하면 선을 그려주는 뷰
    class MyCustomView extends View{
        //그리기 정보를 저장할 변수
        Paint paint;

        //생성자
        MyCustomView(Context context){
            //상위 클래스의 생성자 호출
            super(context);
            //그리기 정보를 저장할 객체를 생성하고 옵션설정
            paint = new Paint();
            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(10);
        }


        //화면에 보여질 때 호출되는 메소드 - 그림을 그립니다.
        @Override
        public void onDraw(Canvas canvas){
            /*
            //모든 점들을 순회하면서 홀수 번째 좌표에서 짝수 번째 좌표로 선을 그리면 된다.
            //isDraw 값을 확인해서 true인 경우 이전좌표에서 현재좌표까지 선을 그려도 된다.
            int len = list.size();
            for(int i =0; i<len;i=i+1){
                if(list.get(i).isDraw==true){
                    canvas.drawLine(list.get(i-1).x,list.get(i-1).y,list.get(i).x,list.get(i).y,paint);
                }
            }
            */
            /*
            //이미지 반대로 출력하기
            Paint paint = new Paint();
            //리소스로 추가한 image1.png 파일을 가지고 Bitmap 만들기
            Resources resources = getResources();
            Bitmap bit = BitmapFactory.decodeResource(resources,R.drawable.image1);
            //위의 비트맵 출력
            //canvas.drawBitmap(bit,10,10,null);

            //크기는 곱하기 1 좌표는 더하기 0 회전은 더하기 0
            Matrix matrix = new Matrix();
                matrix.setScale(0.5f,0.5f);
            Bitmap editBitmap = Bitmap.createBitmap(bit,0,0,bit.getWidth(),bit.getHeight(),matrix,false);
            canvas.drawBitmap(editBitmap,10,10,paint);

            paint.setStrokeWidth(10);
            paint.setStyle(Paint.Style.STROKE);
            //패스 만들기
            Path path = new Path();
            path.moveTo(10,800); //원점이동
            path.cubicTo(80,930,150,900,220,960);
            canvas.drawPath(path,paint);


            //패스위에 글자 출력
            paint.setTextSize(60);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath("글자를 패스위에 츨력",path,0,0,paint);
            */

            Paint paint = new Paint();
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.image1);
            //이미지 출력
            canvas.drawBitmap(bitmap,10,10,paint);

            //컬러필터 생성
            ColorFilter filter = new LightingColorFilter(0xff000,0x00000);
            paint.setColorFilter(filter);
            //이미지 출력
            canvas.drawBitmap(bitmap,10,10,paint);



         }


        //터치 이벤트가 발생했을 때 호출될 메소드
        @Override
        public boolean onTouchEvent(MotionEvent event){
            //터치가 시작된 경우 좌표만 저장
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                list.add(new Vertex(event.getX(),event.getY(),false));
                return true;
            }
            if(event.getAction()==MotionEvent.ACTION_MOVE){
                list.add(new Vertex(event.getX(),event.getY(),true));
                //다시 출력하도록 초기화
                invalidate();
                return  true;
            }

            return false;
        }

    }


    class MyView extends View {
        //기본 생성자가 없기 때문에 생성자를 만들어서 상위 클래스의 생성자를 직접호출해야 합니다.
        public MyView(Context context){
            super(context);
        }
        @Override
        public void onDraw(Canvas canvas){
            //그림을 그릴 때는 그리기 정보를 저장할 Paint 객체가 필요
            Paint paint = new Paint();
            paint.setColor(Color.YELLOW);
            canvas.drawCircle(200,200,100,paint);
        }
    }
    Button button;
    LinearLayout linearLayout1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_custom);
        /*
        MyView view = new MyView(CustomActivity.this);
        setContentView(view);
        */

        MyCustomView customView = new MyCustomView(CustomActivity.this);
        setContentView(customView);
        list= new ArrayList<>();

    }




}
