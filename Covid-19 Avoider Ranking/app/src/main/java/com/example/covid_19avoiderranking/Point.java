package com.example.covid_19avoiderranking;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Point {

   private  int point = 0;
   private String user;
    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(2, 4,
            60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());


   private final FirebaseFirestore db = FirebaseFirestore.getInstance();
   private Calendar calendar = new Calendar() {
       @Override
       protected void computeTime() {

       }

       @Override
       protected void computeFields() {

       }

       @Override
       public void add(int field, int amount) {

       }

       @Override
       public void roll(int field, boolean up) {

       }

       @Override
       public int getMinimum(int field) {
           return 0;
       }

       @Override
       public int getMaximum(int field) {
           return 0;
       }

       @Override
       public int getGreatestMinimum(int field) {
           return 0;
       }

       @Override
       public int getLeastMaximum(int field) {
           return 0;
       }
   };

    public void setup() {//データベースを使えるようにしている。
        // [START get_firestore_instance]
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        // [END get_firestore_instance]

        // [START set_firestore_settings]
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);
        // [END set_firestore_settings]
    }//データベースを使えるようにしている。

    public void setupCacheSize() {
        // [START fs_setup_cache]
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setCacheSizeBytes(FirebaseFirestoreSettings.CACHE_SIZE_UNLIMITED)
                .build();
        db.setFirestoreSettings(settings);
        // [END fs_setup_cache]
    }
    private int hour, minute, second, week;
    private static final String TAG = "Point";
    private int i=0;
    public int getPoint(){
        return point;
    }
public String getUser(){
        return user;
}
public void timeCalendar() {
    if (i >=10){
        point = point - 1;
    }else{
        point = point + 1;
    }

    hour = calendar.get(Calendar.HOUR_OF_DAY);
    minute = calendar.get(Calendar.MINUTE);
    second = calendar.get(Calendar.SECOND);
    week = calendar.get(Calendar.DAY_OF_WEEK);
    if (hour == 0 && minute == 0 && second == 0 && week == 2) {
        point = 0;
    }
}
public void user_pointadd() {
    Map<String, Object> pointData = new HashMap<>();
    pointData.put("user_point", "point");
    pointData.put("name", "user");

    db.collection("pointdb")//.document("ppoint")
            .add(pointData)
            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                }
            })
            .addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            Log.w(TAG, "Error adding document", e);
        }
    });
}
//ポイントのアップデート
 /*public void updateDocument() {
        DocumentReference washingtonRef = db.collection("pointdb").document("point");

        washingtonRef
                .update("user_point", true)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully updated!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error updating document", e);
                    }
                });
    }*/

    //return point;
}