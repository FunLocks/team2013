package com.example.covid_19avoiderranking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        /*ボタンインスタンスの生成*/
        Button firstFloorButton = findViewById(R.id.firstFloorR);
        Button secondFloorButton = findViewById(R.id.secondFloorR);
        Button thirdFloorButton = findViewById(R.id.thirdFloorR);
        Button fourthFloorButton = findViewById(R.id.fourthFloorR);
        Button fifthFloorButton = findViewById(R.id.fifthFloorR);
        Button researchFirstFloorButton = findViewById(R.id.researchFirstFloorR);
        Button researchSecondFloorButton = findViewById(R.id.researchSecondFloorR);

        /*インテントインスタンス（画面遷移の処理を記述したインスタンス）の生成*/
        Intent firstFloorIntent = new Intent(this, FirstFloorActivity.class);
        Intent secondFloorIntent = new Intent(this, SecondFloorActivity.class);
        Intent thirdFloorIntent = new Intent(this, ThirdFloorActivity.class);
        Intent fourthFloorIntent = new Intent(this, FourthFloorActivity.class);
        Intent fifthFloorIntent = new Intent(this, FifthFloorActivity.class);
        Intent researchFirstFloorIntent = new Intent(this, ResearchFirstFloorActivity.class);
        Intent researchSecondFloorIntent = new Intent(this, ResearchSecondFloorActivity.class);

        /* 画面遷移 */
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

        researchSecondFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(researchSecondFloorIntent);
            }
        });

        /*TextView name1 = findViewById(R.id.Name1);
        Sort(name1);*/
    }
        /*private final FirebaseFirestore db = FirebaseFirestore.getInstance();
        private static final String TAG = "Ranking";
        public void Sort(TextView t) {
        CollectionReference PRef = db.collection("pointdb");
        PRef.orderBy("user_point").limit(10);
        String fieldname = "user_point";
        db.collection("pointdb")
                .whereEqualTo(fieldname, PRef).limit(10)
                transration.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                t.setText((CharSequence) document.getData());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                })
    }*/
}