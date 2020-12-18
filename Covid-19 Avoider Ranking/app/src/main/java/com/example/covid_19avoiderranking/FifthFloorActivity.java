package com.example.covid_19avoiderranking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FifthFloorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_floor);

        /*ボタンインスタンスの生成*/
        Button rankingButton = findViewById(R.id.yourPoint5);
        Button firstFloorButton = findViewById(R.id.firstFloor5);
        Button secondFloorButton = findViewById(R.id.secondFloor5);
        Button thirdFloorButton = findViewById(R.id.thirdFloor5);
        Button fourthFloorButton = findViewById(R.id.fourthFloor5);
        Button researchFirstFloorButton = findViewById(R.id.researchFirstFloor5);
        Button researchSecondFloorButton = findViewById(R.id.researchSecondFloor5);

        /*インテントインスタンス（画面遷移の処理を記述したインスタンス）の生成*/
        Intent rankingIntent = new Intent(this, RankingActivity.class);
        Intent firstFloorIntent = new Intent(this, FirstFloorActivity.class);
        Intent secondFloorIntent = new Intent(this, SecondFloorActivity.class);
        Intent thirdFloorIntent = new Intent(this, ThirdFloorActivity.class);
        Intent fourthFloorIntent = new Intent(this, FourthFloorActivity.class);
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

        secondFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(secondFloorIntent);
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