package com.example.step09gameview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {
    //사운드 매니저 객체
    SoundManager sManager;
    //사운드의 종류별로 상수 정의하기 //static final 함수는 관례상 대문자로 만든다.
    public static final int SOUND_LAZER=1;
    public static final int SOUND_SHOOT=2;
    public static final int SOUND_BIRDDIE=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //GameView 객체를 생성해서
        GameView gView = new GameView(this);
        //GameView 로 화면을 모두 채운다.
        setContentView(gView);
        //SoundManager 객체를 생성해서 참조값을 필드에 넣어주고
        sManager=new SoundManager(this);
        //GameView 객체에도 전달한다
        gView.setSoundManager(sManager);

    }

    //액티비티가 최초 활성화 될 때 onCreate() 다음으로 호출된다
    //액티비티가 비활성화 될 때 onStop() 이 호출되는데 onStop() 이후에 다시 활성화 될 때 호출된다.
    @Override
    protected void onStart() {
        super.onStart();
        //효과음 미리 로딩하기
        sManager.addSound(SOUND_LAZER, R.raw.laser1);
        sManager.addSound(SOUND_SHOOT, R.raw.shoot1);
        sManager.addSound(SOUND_BIRDDIE, R.raw.birddie);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


}