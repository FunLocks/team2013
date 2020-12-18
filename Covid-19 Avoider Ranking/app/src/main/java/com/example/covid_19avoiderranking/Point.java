package com.example.covid_19avoiderranking;

import java.util.Calendar;

public class Ranking {

   private  int point = 0;
   private Strng user;
    int hour, minute, second, week;

    public int getPoint(){
        return point;
    }
public String getUser(){
        return user;
}

    if(i => 10){
point = point - 1;
    }else{
        point = point + 1;
    }

    hour = calender.get(Calendar.HOUR_OF_DAY);
    minute = calendar.get(Calendar.MINUTE);
    second = calendar.get(Calendar.SECOND);
    week = calendar.get(Calendar.DAY_OF_WEEK);
 if(hour == 0 && minute == 0 && second == 0 && week == 2){
     point = 0;
    }

    Map<String, Object> pointData = new HashMap<>();
 pointData.put("user_point", "point");
 pointData.put("name", "user");

 db.collection("pointdb").document("ppoint")
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

    return point;
}