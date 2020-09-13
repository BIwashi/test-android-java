package com.example.qiita;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ボタンを設定
        Button button = findViewById(R.id.button);

        // TextView の設定
        textView = findViewById(R.id.text_view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // flagがtrueの時
                if (flag) {
                    textView.setText(R.string.hello);
                    flag = false;
                }
                // flagがfalseの時
                else {
                    textView.setText(R.string.world);
                    flag = true;
                }
            }
        });
    }
}