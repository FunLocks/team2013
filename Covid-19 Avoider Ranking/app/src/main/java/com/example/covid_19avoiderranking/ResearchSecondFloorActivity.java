package com.example.covid_19avoiderranking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResearchSecondFloorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research_second_floor);

        /*ボタンインスタンスの生成*/
        Button rankingButton = findViewById(R.id.yourPointR2);
        Button firstFloorButton = findViewById(R.id.firstFloorR2);
        Button secondFloorButton = findViewById(R.id.secondFloorR2);
        Button thirdFloorButton = findViewById(R.id.thirdFloorR2);
        Button fourthFloorButton = findViewById(R.id.fourthFloorR2);
        Button fifthFloorButton = findViewById(R.id.fifthFloorR2);
        Button researchFirstFloorButton = findViewById(R.id.researchFirstFloorR2);

        /*インテントインスタンス（画面遷移の処理を記述したインスタンス）の生成*/
        Intent rankingIntent = new Intent(this, RankingActivity.class);
        Intent firstFloorIntent = new Intent(this, FirstFloorActivity.class);
        Intent secondFloorIntent = new Intent(this, SecondFloorActivity.class);
        Intent thirdFloorIntent = new Intent(this, ThirdFloorActivity.class);
        Intent fourthFloorIntent = new Intent(this, FourthFloorActivity.class);
        Intent fifthFloorIntent = new Intent(this, FifthFloorActivity.class);
        Intent researchFirstFloorIntent = new Intent(this, ResearchFirstFloorActivity.class);

        /* 画面遷移 */
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

    }
}