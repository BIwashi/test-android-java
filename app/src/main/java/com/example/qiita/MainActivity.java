package com.example.qiita;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // リニアレイアウトの設定
        LinearLayout layout = new LinearLayout(this); // 動的に変化可能なlayoutインスタンス作成

        // layoutのいろいろな設定. xmlに書いてたやつ
        // orientationは垂直方向
        layout.setOrientation(LinearLayout.VERTICAL);
        // Layoutの横・縦幅の指定
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        // レイアウト中央寄せ
        layout.setGravity(Gravity.CENTER);

        setContentView(layout); // 作成した動的なlayoutインスタンスをviewメソッドに設定

        // テキスト設定
        textView = new TextView(this); // インスタンス作成
        textView.setText(R.string.hello); // 作成したインスタンスにstring.xmlで設定したtextを入れる

        // テキストサイズ
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,30);
        // テキストカラー
        textView.setTextColor(Color.rgb(0x0,0x0,0x0));

        // xmlで書いてた詳細
        // text用のlayoutインスタンスの作成
        LinearLayout.LayoutParams textLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        textView.setLayoutParams(textLayoutParams); // 作成したtext用layoutインスタンスを設定
        layout.addView(textView);

        // ボタンの設定
        Button button = new Button(this); // インスタンス作成
        button.setText(R.string.button); // 作成したインスタンスにstring.xmlで設定したtextを入れる

        // dp単位を取得
        float scale = getResources().getDisplayMetrics().density; // 100?
        int buttonWidth = (int)(150 * scale);
        // 横幅 150dp, 縦　100dp　に設定
        // xmlで書いてた詳細
        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(
                buttonWidth, // 横幅
                LinearLayout.LayoutParams.WRAP_CONTENT); // 縦幅

        // マージン　20dp に設定
        int margins = (int)(20 * scale);
        buttonLayoutParams.setMargins(margins,margins,margins,margins);

        button.setLayoutParams(buttonLayoutParams);
        layout.addView(button);

        // リスナーをボタンに登録
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

//        setContentView(R.layout.activity_main);
//
//        // ボタンを設定
//        Button button = findViewById(R.id.button);
//
//        // TextView の設定
//        textView = findViewById(R.id.text_view);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // flagがtrueの時
//                if (flag) {
//                    textView.setText(R.string.hello);
//                    flag = false;
//                }
//                // flagがfalseの時
//                else {
//                    textView.setText(R.string.world);
//                    flag = true;
//                }
//            }
//        });
    }
}