package com.example.covid_19avoiderranking;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

import java.util.Collection;

public class MainActivity extends AppCompatActivity implements BeaconConsumer {
    private BeaconManager beaconManager;
    //iBeacon認識のためのフォーマット設定
    private static final String IBEACON_FORMAT ="m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24";
    private FirebaseFirestore db =FirebaseFirestore.getInstance();
    DocSnippets database = new DocSnippets(db);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        beaconManager = BeaconManager.getInstanceForApplication(this);
        // BeaconParseを設定
        beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout(IBEACON_FORMAT));
    }

    @Override
    protected void onResume(){
        super.onResume();
        beaconManager.bind(this);
    //サービス開始
    }

    @Override
    protected void onPause(){
        super.onPause();
        beaconManager.unbind(this);
        //サービス終了
    }

    @Override
    public void onBeaconServiceConnect() {

        final Region mRegion = new Region("iBeacon", null, null, null);

        beaconManager.addRangeNotifier(new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
                for(Beacon beacon:beacons){
                    Log.d("MyActivity","UUID:" + beacon.getId1() + ", major:"
                            + beacon.getId2() + ", minor;" + beacon.getId3() + ", RSSI:"
                            + beacon.getRssi() + ", TxPower:" + beacon.getTxPower() + ", Distance:"
                     + beacon.getDistance());
                }
            }
        });

        try{
            //Beaconの情報を監視を開始
            beaconManager.startRangingBeaconsInRegion(mRegion);
        }catch(RemoteException e){
            e.printStackTrace();
        }



        beaconManager.addMonitorNotifier(new MonitorNotifier() {

            @Override
            public void didEnterRegion(Region region) {
                //領域への入場を検知
                Log.d("iBeacon","Enter Region");
            }

            @Override
            public void didExitRegion(Region region) {
                //領域からの退場を検知
                Log.d("iBeacon","Enter Region");
            }

            @Override
            public void didDetermineStateForRegion(int i, Region region) {
                //領域への入退場のステータスを検知
                Log.d("MyActivity","Determine State " + i);
            }
        });

        try{
            //Beaconの情報を監視を開始
            beaconManager.startMonitoringBeaconsInRegion(mRegion);
        }catch(RemoteException e){
            e.printStackTrace();
        }

        /*ボタンインスタンスの生成*/
        Button rankingButton = findViewById(R.id.ranking);
        Button firstFloorButton = findViewById(R.id.firstFloor);
        Button secondFloorButton = findViewById(R.id.secondFloor);
        Button thirdFloorButton = findViewById(R.id.thirdFloor);
        Button fourthFloorButton = findViewById(R.id.fourthFloor);
        Button fifthFloorButton = findViewById(R.id.fifthFloor);
        Button researchFirstFloorButton = findViewById(R.id.researchFirstFloor);
        Button researchSecondFloorButton = findViewById(R.id.researchSecondFloor);

        /*インテントインスタンス（画面遷移の処理を記述したインスタンス）の生成*/
        Intent rankingIntent = new Intent(this, RankingActivity.class);
        Intent firstFloorIntent = new Intent(this, FirstFloorActivity.class);
        Intent secondFloorIntent = new Intent(this, SecondFloorActivity.class);
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


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}