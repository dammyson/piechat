package com.voco.piechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.AddToCartEvent;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.ContentViewEvent;
import com.crashlytics.android.answers.CustomEvent;
import com.crashlytics.android.answers.LoginEvent;
import com.crashlytics.android.answers.SignUpEvent;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());
        setContentView(R.layout.activity_main);


    }

    public void forceCrash(View view) {
        Toast.makeText(this, "LOVe", Toast.LENGTH_SHORT).show();
        throw new RuntimeException("This is a crash");
    }



    public void send(View view) {
        Answers.getInstance().logAddToCart(new AddToCartEvent());

    }


    public void Redemption(View view) {
        Answers.getInstance().logCustom(new CustomEvent("Redemption")
                .putCustomAttribute("Another attribut", "My String")
                .putCustomAttribute("how much", 25));
    }

    public void Reg(View view) {
        Answers.getInstance().logSignUp(new SignUpEvent()
                .putMethod("Phone")
                .putSuccess(true));
    }

    public void Login(View view) {
        Answers.getInstance().logLogin(new LoginEvent()
                .putMethod("Phone")
                .putSuccess(true));
    }

    public void giveAway(View view) {
        Answers.getInstance().logCustom(new CustomEvent("GiveAway")
                .putCustomAttribute("Another attribut", "My String")
                .putCustomAttribute("how much", 75));
    }

    public void fiew(View view) {
        Answers.getInstance().logContentView(new ContentViewEvent()
                .putContentName("View Lockscreen!")
                .putContentType("picture")
                .putContentId("Now"));

    }

    public void Next(View view) {
        Intent intent = new Intent(MainActivity.this, secondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
