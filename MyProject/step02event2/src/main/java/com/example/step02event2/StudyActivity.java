package com.example.step02event2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StudyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        // 필요한 UI 의 참조값 얻어오기
        Button registerBtn = findViewById(R.id.registerBtn);
        EditText inputWord = findViewById(R.id.inputWord);
        TextView result = findViewById(R.id.result);
        // 버튼을 눌렀을 때 실행할 함수 등록
        registerBtn.setOnClickListener(view -> {
            // 1. EditText에 입력한 문자열 읽어오기
            String word = inputWord.getText().toString();
            // 2. TextView 에 읽어온 문자열 출력하기
            result.setText(word);
            //result.setText(inputWord.getText());
            // 3. EditText 에 초기화
            inputWord.setText(" ");
            

        });
    }
}