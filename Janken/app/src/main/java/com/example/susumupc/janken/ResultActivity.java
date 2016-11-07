package com.example.susumupc.janken;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    final int JANKEN_GU = 0;
    final int JANKEN_CHOKI = 1;
    final int JANKEN_PAR = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int myHand;

        Intent intent = getIntent();
        int id = intent.getIntExtra("MY_HAND", 0);
        ImageView myHandImageView = (ImageView) findViewById(R.id.my_hand_image);

        switch (id){
            case R.id.gu:
                myHandImageView.setImageResource(R.drawable.guu);
                myHand = JANKEN_GU;
                break;

            case R.id.pa:
                myHandImageView.setImageResource(R.drawable.paa);
                   myHand = JANKEN_PAR;
                break;
            case R.id.choki:
                myHandImageView.setImageResource(R.drawable.choki);
                myHand = JANKEN_CHOKI;
                break;
            default:
                myHand = JANKEN_GU;
                break;
        }

            //コンピュータが出すものを決める
        int comHand = (int) (Math.random() * 3);
        ImageView comHandImageView = (ImageView)findViewById(R.id.com_hand_image);
        switch (comHand){
            case JANKEN_GU:
                comHandImageView.setImageResource(R.drawable.guucom);
                break;

            case JANKEN_CHOKI:
                comHandImageView.setImageResource(R.drawable.chokicom);
                break;
            case JANKEN_PAR:
                comHandImageView.setImageResource(R.drawable.paacom);
                break;
        }

        TextView resultLabel = (TextView)findViewById(R.id.result_label);
        int gameResult = (comHand - myHand +3) % 3;
        switch(gameResult){
            case 0 :
                resultLabel.setText(R.string.result_draw);
                break; //あいこの場合
            case 1: resultLabel.setText(R.string.result_win);
                break;//勝った場合
            case 2:
                resultLabel.setText(R.string.result_lose);
                break;
        }

    }

    public void onBackButtonTapped(View view){
        finish();
    }


}
