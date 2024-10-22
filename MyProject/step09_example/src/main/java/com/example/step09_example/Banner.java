package com.example.step09_example;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*
    [ Custom View 만들기 ]
    1. View 클래스를 상속받는다.
    2. 생성자를 정의하기
    3. onDraw() 메소드를 오버라이드해서 화면을 구성한다.
 */

public class Banner extends View {//1.

    //필드
    int x=10;
    Paint p;
    int length;
    int height;
    int w;
    String bannerText;
    int y;

    // layout xml 없이 단독으로 화면 전체를 채울 떄 사용한다.
    public Banner(Context context) {//2.
        super(context);

    }

    // layout xml 에서 사용하려면 아래의 생성자가 필요하다.
    public Banner(Context context, @Nullable AttributeSet attrs) {//3.
        super(context, attrs);

    }

    Handler handler=new Handler(){
        //Handler 객체에 메세지가 도착하면 호출되는 메소드
        @Override
        public void handleMessage(@NonNull Message msg) {
            x++;
            //만일 글자의 x 좌표가 w 보다 커지면
            if(x>w){
                // x 좌표를 -length 로 변경하기
                x = -length;
            }
            invalidate();
            handler.sendEmptyMessageDelayed(0, 10);
        }
    };
    //초기화 하는 메소드
    public void init(String bannerText){
        //매개변수에 전달된 문자열을 필드에 저장
        this.bannerText=bannerText;
        //Handler 객체에 10/1000 초 이후에 빈 메세지 보내기
        handler.sendEmptyMessageDelayed(0, 10);
        //글자 출력하기
        p = new Paint();
        p.setColor(Color.RED);
        p.setTextSize(100);

        // 글자의 길이 알아내기
        length = (int)p.measureText(bannerText);

        

    }

    //매개 변수로 전달되는 Canvas 객체를 이용해서 그림을 그리면 그린 내용이 화면에 나타난다.
    // 그림 => 글자, 도형, 페인트, 로딩한 이미지 등등...
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        canvas.drawColor(Color.YELLOW);

        canvas.drawText(bannerText, x, y, p);

    }
    // View 가 최초 화면에 출력될 때 호출되고 View 의 크기가 변경될 떄 다시 호출된다.
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.w=w;
        //글자의 y축 좌표를 계산에서 필드에 대입하기
        y = h/2 + 100/2;

    }
}
