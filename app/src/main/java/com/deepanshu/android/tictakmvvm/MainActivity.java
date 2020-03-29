package com.deepanshu.android.tictakmvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, viewInterface {

    private final static String TAG = MainActivity.class.getSimpleName();
    boolean PLAYER_X = true;
    boolean winner = false;
    String winnerName = "";


    int nowOfBox = 9;
    Button b00;
    Button b01;
    Button b02;

    Button b10;
    Button b11;
    Button b12;

    Button b20;
    Button b21;
    Button b22;
    Presenter1 presenter1;
    Button bReset;

    TextView tvInfo;

    private int iswinnerFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter1 = new Presenter1(this);
        b00 = (Button) findViewById(R.id.b00);
        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);

        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);

        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);



        bReset = (Button) findViewById(R.id.bReset);
        tvInfo = (TextView) findViewById(R.id.tvInfo);

        bReset.setOnClickListener((View.OnClickListener) this);

        b00.setOnClickListener(this);
        b01.setOnClickListener(this);
        b02.setOnClickListener(this);

        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);

        b20.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);

        presenter1.initializeBoardStatus();
        presenter1.setPLAYER_XPostion();

    }


    @Override
    public void onClick(View v) {
        presenter1.onclickonGamecubes(v);

    }

    @Override
    public void showwinnerDialog(String winnerName) {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("WINNER")
                .setMessage("Winner is: " + winnerName)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    @Override
    public void setresult(String tvinfo) {
        tvInfo.setText(tvinfo);
    }

    @Override
    public void setPlayerstep(String X_or_0) {
        tvInfo.setText(X_or_0);
    }

    @Override
    public void setdbtn00(String oo) {
        b00.setText(oo);
        b00.setEnabled(false);
    }

    @Override
    public void setdbtn01(String o1) {
        b01.setText(o1);
        b01.setEnabled(false);
    }

    @Override
    public void setdbtn02(String o2) {
        b02.setText(o2);
        b02.setEnabled(false);
    }

    @Override
    public void setdbtn10(String o0) {
        b10.setText(o0);
        b10.setEnabled(false);
    }

    @Override
    public void setdbtn11(String oo) {
        b11.setText(oo);
        b11.setEnabled(false);
    }

    @Override
    public void setdbtn12(String oo) {
        b12.setText(oo);
        b12.setEnabled(false);
    }

    @Override
    public void setdbtn20(String oo) {
        b20.setText(oo);
        b20.setEnabled(false);
    }

    @Override
    public void setdbtn21(String oo) {
        b21.setText(oo);
        b21.setEnabled(false);
    }

    @Override
    public void setdbtn22(String oo) {
        b22.setText(oo);
        b22.setEnabled(false);
    }

    @Override
    public void enabledisablebtn(Boolean value) {
        b00.setEnabled(value);
        b01.setEnabled(value);
        b02.setEnabled(value);
        b10.setEnabled(value);
        b11.setEnabled(value);
        b12.setEnabled(value);
        b20.setEnabled(value);
        b21.setEnabled(value);
        b22.setEnabled(value);
    }


}