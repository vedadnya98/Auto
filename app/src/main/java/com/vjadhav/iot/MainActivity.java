package com.vjadhav.iot;

import android.support.v4.widget.SearchViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference reference;
    private boolean isLivingRoomLightOn;
    private boolean isBedRoomLightOn;
    private boolean isTerraceLightOn;
    private boolean isKitchenLightOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference("/siesgst");
        reference.child("/LR/value").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() !=null){
                    String value = dataSnapshot.getValue(String.class);
                    if(value.equals("1")) {
                        isLivingRoomLightOn = true;
                    }
                    else {
                        isLivingRoomLightOn = false;
                     }
                    ImageView livingRoomLight = (ImageView) findViewById(R.id.room1);
                    livingRoomLight.setImageResource(isLivingRoomLightOn ? R.drawable.bulbon : R.drawable.bulboff);

                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        reference.child("/BR/value").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() !=null){
                    String value = dataSnapshot.getValue(String.class);
                    if(value.equals("1")) {
                        isBedRoomLightOn = true;
                    }
                    else {
                        isBedRoomLightOn = false;
                    }
                    ImageView bedRoomLight = (ImageView) findViewById(R.id.room2);
                    bedRoomLight.setImageResource(isBedRoomLightOn ? R.drawable.bulbon : R.drawable.bulboff);

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        reference.child("/K/value").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() !=null){
                    String value = dataSnapshot.getValue(String.class);
                    if(value.equals("1")) {
                        isKitchenLightOn = true;
                    }
                    else {
                        isKitchenLightOn = false;
                    }
                    ImageView kitchenLight = (ImageView) findViewById(R.id.room3);
                    kitchenLight.setImageResource(isKitchenLightOn ? R.drawable.bulbon : R.drawable.bulboff);

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        reference.child("/T/value").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() !=null) {
                    String value = dataSnapshot.getValue(String.class);
                    if (value.equals("1")) {
                        isTerraceLightOn = true;
                    } else {
                        isTerraceLightOn = false;
                    }
                    ImageView terraceLight = (ImageView) findViewById(R.id.room4);
                    terraceLight.setImageResource(isTerraceLightOn ? R.drawable.bulbon : R.drawable.bulboff);

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        LinearLayout livingroom = (LinearLayout) findViewById(R.id.LivingRoom);
        livingroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.child("/LR/value").setValue(isLivingRoomLightOn ? "0" : "1");
            }
        });
        LinearLayout bedroom = (LinearLayout) findViewById(R.id.BedRoom);
        bedroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.child("/BR/value").setValue(isBedRoomLightOn ? "0" : "1");
            }
        });
        LinearLayout terrace = (LinearLayout) findViewById(R.id.Terrace);
        terrace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.child("/T/value").setValue(isTerraceLightOn ? "0" : "1");
            }
        });
        LinearLayout kitchen = (LinearLayout) findViewById(R.id.Kitchen);
        kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.child("/K/value").setValue(isKitchenLightOn ? "0" : "1");
            }
        });

    }
        @Override
    protected void onStart() {
        super.onStart();
        Log.d("IOT","Good going");
     }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("IOT","Good going again");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("IOT","Well Played");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("IOT","Why would you do that!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("IOT","So rude");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("IOT","Welcome back");
    }

    @Override
    public void onLocalVoiceInteractionStarted() {
        super.onLocalVoiceInteractionStarted();
    }
}
