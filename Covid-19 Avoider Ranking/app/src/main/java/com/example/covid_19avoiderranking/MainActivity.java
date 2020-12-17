package com.example.covid_19avoiderranking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

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


    }

}