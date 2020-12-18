package com.example.covid_19avoiderranking;

public class Ranking {

    DocumentReference PRef = db.collection("pointdb").document("ppoint")
    PRef.orderBy("user_point").limit(10);

db.collection("pointdb")
        .whereEqualTo("user_points", limit(10))
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