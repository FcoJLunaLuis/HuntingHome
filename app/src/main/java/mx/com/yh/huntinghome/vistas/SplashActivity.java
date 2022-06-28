package mx.com.yh.huntinghome.vistas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import mx.com.yh.huntinghome.LoginActivity;
import mx.com.yh.huntinghome.R;

public class SplashActivity extends AppCompatActivity {

    private static final long TIME_OUT_MILI = 3000;
    private SharedPreferences mAppPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //mAppPreferences = AppUtil.getAppPreferences(this);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (mAppPreferences.getBoolean("is_Logged_in", false)) {

                    startActivity(new Intent(SplashActivity.this, Home.class));

                } else {

                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));

                }
                finish();
            }
        }, TIME_OUT_MILI);
    }


}