package com.example.covid_19avoiderranking;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Ranking {
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "Ranking";
    public void Sort() {
        CollectionReference PRef = db.collection("pointdb");
        PRef.orderBy("user_point").limit(10);
        String fieldname = "user_point";
        db.collection("pointdb")
                .whereEqualTo(fieldname,PRef). limit(10)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });


    }
}