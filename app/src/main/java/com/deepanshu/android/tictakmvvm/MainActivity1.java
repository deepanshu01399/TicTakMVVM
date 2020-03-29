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

public class MainActivity1 extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();
    boolean PLAYER_X = true;
    boolean winner = false;
    String winnerName="";


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

    Button bReset;

    TextView tvInfo;

    int[][] boardStatus = new int[3][3];
    private int iswinnerFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        initializeBoardStatus();
        setPLAYER_XPostion();

    }


    private void initializeBoardStatus() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardStatus[i][j] = -1;
            }
        }
    }

    @Override
    public void onClick(View v) {

        boolean btnresetpressed = false;
        switch (v.getId()) {
            case R.id.b00:
                if (PLAYER_X) {
                    b00.setText("X");
                    boardStatus[0][0] = 1;

                } else {
                    b00.setText("0");
                    boardStatus[0][0] = 0;
                }
                b00.setEnabled(false);
                break;
            case R.id.b01:
                if (PLAYER_X) {
                    b01.setText("X");
                    boardStatus[0][1] = 1;
                } else {
                    b01.setText("0");
                    boardStatus[0][1] = 0;
                }
                b01.setEnabled(false);
                break;

            case R.id.b02:
                if (PLAYER_X) {
                    b02.setText("X");
                    boardStatus[0][2] = 1;
                } else {
                    b02.setText("0");
                    boardStatus[0][2] = 0;
                }
                b02.setEnabled(false);
                break;

            case R.id.b10:
                if (PLAYER_X) {
                    b10.setText("X");
                    boardStatus[1][0] = 1;
                } else {
                    b10.setText("0");
                    boardStatus[1][0] = 0;
                }
                b10.setEnabled(false);
                break;

            case R.id.b11:
                if (PLAYER_X) {
                    b11.setText("X");
                    boardStatus[1][1] = 1;
                } else {
                    b11.setText("0");
                    boardStatus[1][1] = 0;
                }
                b11.setEnabled(false);
                break;

            case R.id.b12:
                if (PLAYER_X) {
                    b12.setText("X");
                    boardStatus[1][2] = 1;
                } else {
                    b12.setText("0");
                    boardStatus[1][2] = 0;
                }
                b12.setEnabled(false);
                break;

            case R.id.b20:
                if (PLAYER_X) {
                    b20.setText("X");
                    boardStatus[2][0] = 1;
                } else {
                    b20.setText("0");
                    boardStatus[2][0] = 0;
                }
                b20.setEnabled(false);
                break;

            case R.id.b21:
                if (PLAYER_X) {
                    b21.setText("X");
                    boardStatus[2][1] = 1;
                } else {
                    b21.setText("0");
                    boardStatus[2][1] = 0;
                }
                b21.setEnabled(false);
                break;

            case R.id.b22:
                if (PLAYER_X) {
                    b22.setText("X");
                    boardStatus[2][2] = 1;
                } else {
                    b22.setText("0");
                    boardStatus[2][2] = 0;
                }
                b22.setEnabled(false);
                break;

            case R.id.bReset:
                btnresetpressed = true;
                break;

            default:
                break;
        }

        if (btnresetpressed) {
            resetBoard();
            initializeBoardStatus();
            enabledisablebtn(true);
        }
        if (nowOfBox==0){
            showwinnerDialog("None");
            resetBoard();
            enabledisablebtn(true);
        }

        checkWhoIsWinner();

        if (iswinnerFound == 1) {

            showwinnerDialog(winnerName);
            enabledisablebtn(false);

        } else
            nextPlayer();
    }

    private void showwinnerDialog(String winnerName) {

        new AlertDialog.Builder(MainActivity1.this)
                .setTitle("WINNER")
                .setMessage("Winner is: "+winnerName)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    private void checkWhoIsWinner() {
        if (boardStatus[0][0] == boardStatus[1][1] && boardStatus[1][1] == boardStatus[2][2]) {
            if (boardStatus[0][0] == 1) {
                winnerName="X";
                //Toast.makeText(this, "player 1 from firstdialog ", Toast.LENGTH_LONG).show();
                iswinnerFound = 1;
            }
            if (boardStatus[0][0] == 0) {
                winnerName="0";
                //Toast.makeText(this, "player 2 from firstdialog ", Toast.LENGTH_LONG).show();
                iswinnerFound = 1;
            }
        } else if (boardStatus[2][0] == boardStatus[1][1] && boardStatus[1][1] == boardStatus[0][2]) {
            if (boardStatus[2][0] == 1) {
                winnerName="X";
                //Toast.makeText(this, "player 1 from second dialog ", Toast.LENGTH_LONG).show();
                iswinnerFound = 1;
            }
            if (boardStatus[2][0] == 0) {
                winnerName="0";
                //Toast.makeText(this, "player 2 from secod dialog", Toast.LENGTH_LONG).show();
                iswinnerFound = 1;
            }
        } else {
            //for horizontal rows
            for (int i = 0; i < 3; i++) {

                if (boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][1] == boardStatus[i][2]) {
                    if (boardStatus[i][0] == 1) {
                        winnerName="X";
                        iswinnerFound = 1;
                        //Toast.makeText(this, "player 1 from  row " + i, Toast.LENGTH_LONG).show();
                        break;
                    }
                    if (boardStatus[i][0] == 0) {
                        winnerName="0";
                        //Toast.makeText(this, "player 2 from row  " + i, Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
            // for verticall rows
            for (int i = 0; i < 3; i++) {
                if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[1][i] == boardStatus[2][i]) {
                    if (boardStatus[0][i] == 1) {
                        winnerName="X";
                        iswinnerFound = 1;
                        //Toast.makeText(this, "player 1 from col  " + i, Toast.LENGTH_LONG).show();
                        break;
                    }
                    if (boardStatus[0][i] == 0) {
                        winnerName="0";
                        iswinnerFound = 1;
                        //Toast.makeText(this, "player 2 from  col " + i, Toast.LENGTH_LONG).show();
                        break;
                    }
                }

            }
        }
    }


    private void enabledisablebtn(Boolean value) {
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

    private void nextPlayer() {

        if (nowOfBox > 0) {
            if (PLAYER_X) {
                tvInfo.setText("X");
            } else
                tvInfo.setText("0");
            PLAYER_X = !PLAYER_X;
            nowOfBox = nowOfBox - 1;
        }

    }

    public void setPLAYER_XPostion() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardStatus[i][j] == 1) {
                    PLAYER_X = true;
                } else if (boardStatus[i][j] == 0)
                    PLAYER_X = false;
            }
        }
    }

    private void resetBoard() {
        b00.setText("");
        b01.setText("");
        b02.setText("");

        b10.setText("");
        b11.setText("");
        b12.setText("");

        b20.setText("");
        b21.setText("");
        b22.setText("");
        tvInfo.setText("");
        nowOfBox = 9;
        iswinnerFound=0;
        PLAYER_X=true;
        initializeBoardStatus();

    }
}