package com.example.hrishitamavani.sensorlist;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @author netodevel
 */
public class MainActivity extends AppCompatActivity {

    private ShakeDetector shakeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildView();

        final ShakeOptions options = new ShakeOptions()
                .background(false)
                .interval(1000)
                .shakeCount(2)
                .sensibility(2.0f);

       shakeDetector = new ShakeDetector(options);
/*
Button call=(Button)findViewById(R.id.btncall);
Button torch=(Button)findViewById(R.id.btntorch);
Button msg=(Button)findViewById(R.id.btnmsg);
Button cam=(Button)findViewById(R.id.btncamera);*/
       /* call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
*/                shakeDetector.start(MainActivity.this, new ShakeCallback() {
                    @Override
                    public void onShake() {
                        final MediaPlayer mp =MediaPlayer.create(MainActivity.this,R.raw.song);
mp.start();
                     LinearLayout ll = (LinearLayout) findViewById(R.id.activity_main);
                        ll.setBackgroundColor(Color.RED);
                    //    int c=ll.getDrawingCacheBackgroundColor();
                      /*  int shak=options.getShakeCounts();
                        int i=0;
                        while ( i<10) {

                            if (shak == 2) {
                                ll.setBackgroundColor(Color.GREEN);
                            } else if (shak == 3) {
                                ll.setBackgroundColor(Color.BLUE);

                            } else if (shak == 4) {
                                ll.setBackgroundColor(Color.RED);
                            }
                            i++;
                        }*/
                    /*    if(c==Color.red(255)) {
                    *//*    Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:"+"8306790082"));
                        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }

                        startActivity(callIntent);
                        *//*
ll.setBackgroundColor(Color.green(255));
                        }
                        else if (c==Color.green(255))
                        {
                            ll.setBackgroundColor(Color.green(255));
                        }*/
                          // Toast.makeText(MainActivity.this, "call", Toast.LENGTH_SHORT).show();
                        //Log.d("event", "onShake");
                  //      shakeDetector.destroy(getBaseContext());

                    }
                });
      /*      }
        });*/


    /*    torch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "torch", Toast.LENGTH_SHORT).show();
                //shakeDetector.destroy(getBaseContext());

            }
        });
        msg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                shakeDetector.start(MainActivity.this, new ShakeCallback() {
                    @Override
                    public void onShake() {
                        //  shakeDetector.destroy(getBaseContext());
                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","8306790082","hello")));

                    }
                });
            }
             //   Toast.makeText(MainActivity.this, "msg", Toast.LENGTH_SHORT).show();
              //  shakeDetector.destroy(getBaseContext());


        });
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "cam", Toast.LENGTH_SHORT).show();
           //     shakeDetector.destroy(getBaseContext());

            }
        });*/
        //IF YOU WANT JUST IN BACKGROUND
        //this.shakeDetector = new ShakeDetector(options).start(this);
    }

    private void buildView() {
       // Button btnStopService = (Button) findViewById(R.id.btnStopService);
      /*  btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("destroy", "destroy service shake");
                Toast.makeText(MainActivity.this, "stop", Toast.LENGTH_SHORT).show();
                shakeDetector.stopShakeDetector(getBaseContext());
           }
        });*/
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        shakeDetector.destroy(getBaseContext());
        super.onDestroy();
    }



}
