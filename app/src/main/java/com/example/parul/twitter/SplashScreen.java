package com.example.parul.twitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class SplashScreen extends Activity {
    private View mLayout;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_screen);
            mLayout = findViewById(R.id.splash_layout);

            Thread timerThread = new Thread(){
                public void run(){
                    try{

                        if (!Login.isLoginEnabled(SplashScreen.this)) {
                            Intent i = new Intent(SplashScreen.this, Login.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                            finish();
                        }
                        else {
                            Intent i = new Intent(SplashScreen.this,Twitter.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                            finish();
                        }
                        sleep(50000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            timerThread.start();
        }

        @Override
        protected void onPause() {
            super.onPause();
            finish();
        }

    }





