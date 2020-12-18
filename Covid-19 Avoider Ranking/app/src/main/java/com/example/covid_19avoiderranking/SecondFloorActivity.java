package com.example.covid_19avoiderranking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondFloorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_floor);

        /*ボタンインスタンスの生成*/
        Button rankingButton = findViewById(R.id.yourPoint2);
        Button firstFloorButton = findViewById(R.id.firstFloor2);
        Button thirdFloorButton = findViewById(R.id.thirdFloor2);
        Button fourthFloorButton = findViewById(R.id.fourthFloor2);
        Button fifthFloorButton = findViewById(R.id.fifthFloor2);
        Button researchFirstFloorButton = findViewById(R.id.researchFirstFloor2);
        Button researchSecondFloorButton = findViewById(R.id.researchSecondFloor2);

        /*インテントインスタンス（画面遷移の処理を記述したインスタンス）の生成*/
        Intent rankingIntent = new Intent(this, RankingActivity.class);
        Intent firstFloorIntent = new Intent(this, FirstFloorActivity.class);
        Intent thirdFloorIntent = new Intent(this, ThirdFloorActivity.class);
        Intent fourthFloorIntent = new Intent(this, FourthFloorActivity.class);
        Intent fifthFloorIntent = new Intent(this, FifthFloorActivity.class);
        Intent researchFirstFloorIntent = new Intent(this, ResearchFirstFloorActivity.class);
        Intent researchSecondFloorIntent = new Intent(this, ResearchSecondFloorActivity.class);

        /* 画面遷移　RankingActivityへ */
        rankingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(rankingIntent);
            }
        });

        firstFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(firstFloorIntent);
            }
        });

        thirdFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(thirdFloorIntent);
            }
        });

        fourthFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(fourthFloorIntent);
            }
        });

        fifthFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(fifthFloorIntent);
            }
        });

        researchFirstFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(researchFirstFloorIntent);
            }
        });

        researchSecondFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(researchSecondFloorIntent);
            }
        });
    }
}