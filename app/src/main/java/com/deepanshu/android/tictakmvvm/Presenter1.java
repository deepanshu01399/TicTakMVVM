package com.deepanshu.android.tictakmvvm;

import android.view.View;

public class Presenter1 implements presenterInterface {
    int[][] boardStatus = new int[3][3];
    private int iswinnerFound;
    boolean PLAYER_X = true;
    boolean winner = false;
    String winnerName = "";
    int nowOfBox = 9;
    viewInterface viewInterface;

    public Presenter1(viewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Override
    public void initializeBoardStatus() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardStatus[i][j] = -1;
            }
        }
    }

    @Override
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

    @Override
    public void checkWhoIsWinner() {
        if (boardStatus[0][0] == boardStatus[1][1] && boardStatus[1][1] == boardStatus[2][2]) {
            if (boardStatus[0][0] == 1) {
                winnerName = "X";
                //Toast.makeText(this, "player 1 from firstdialog ", Toast.LENGTH_LONG).show();
                iswinnerFound = 1;
            }
            if (boardStatus[0][0] == 0) {
                winnerName = "0";
                //Toast.makeText(this, "player 2 from firstdialog ", Toast.LENGTH_LONG).show();
                iswinnerFound = 1;
            }
        } else if (boardStatus[2][0] == boardStatus[1][1] && boardStatus[1][1] == boardStatus[0][2]) {
            if (boardStatus[2][0] == 1) {
                winnerName = "X";
                //Toast.makeText(this, "player 1 from second dialog ", Toast.LENGTH_LONG).show();
                iswinnerFound = 1;
            }
            if (boardStatus[2][0] == 0) {
                winnerName = "0";
                //Toast.makeText(this, "player 2 from secod dialog", Toast.LENGTH_LONG).show();
                iswinnerFound = 1;
            }
        } else {
            //for horizontal rows
            for (int i = 0; i < 3; i++) {

                if (boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][1] == boardStatus[i][2]) {
                    if (boardStatus[i][0] == 1) {
                        winnerName = "X";
                        iswinnerFound = 1;
                        //Toast.makeText(this, "player 1 from  row " + i, Toast.LENGTH_LONG).show();
                        break;
                    }
                    if (boardStatus[i][0] == 0) {
                        winnerName = "0";
                        iswinnerFound = 1;

                        //Toast.makeText(this, "player 2 from row  " + i, Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
            // for verticall rows
            for (int i = 0; i < 3; i++) {
                if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[1][i] == boardStatus[2][i]) {
                    if (boardStatus[0][i] == 1) {
                        winnerName = "X";
                        iswinnerFound = 1;
                        //Toast.makeText(this, "player 1 from col  " + i, Toast.LENGTH_LONG).show();
                        break;
                    }
                    if (boardStatus[0][i] == 0) {
                        winnerName = "0";
                        iswinnerFound = 1;
                        //Toast.makeText(this, "player 2 from  col " + i, Toast.LENGTH_LONG).show();
                        break;
                    }
                }

            }
        }
    }


    @Override
    public void onclickonGamecubes(View v) {
        boolean btnresetpressed = false;
        switch (v.getId()) {
            case R.id.b00:
                if (PLAYER_X) {
                    viewInterface.setdbtn00("X");
                    boardStatus[0][0] = 1;

                } else {
                    viewInterface.setdbtn00("0");
                    boardStatus[0][0] = 0;
                }

                break;
            case R.id.b01:
                if (PLAYER_X) {
                    viewInterface.setdbtn01("X");
                    boardStatus[0][1] = 1;
                } else {
                    viewInterface.setdbtn01("0");
                    boardStatus[0][1] = 0;
                }
                break;

            case R.id.b02:
                if (PLAYER_X) {
                    viewInterface.setdbtn02("X");
                    boardStatus[0][2] = 1;
                } else {
                    viewInterface.setdbtn02("0");
                    boardStatus[0][2] = 0;
                }

                break;

            case R.id.b10:
                if (PLAYER_X) {
                    viewInterface.setdbtn10("X");
                    boardStatus[1][0] = 1;
                } else {
                    viewInterface.setdbtn10("0");
                    boardStatus[1][0] = 0;
                }
                break;

            case R.id.b11:
                if (PLAYER_X) {
                    viewInterface.setdbtn11("X");
                    boardStatus[1][1] = 1;
                } else {
                    viewInterface.setdbtn11("0");
                    boardStatus[1][1] = 0;
                }
                break;

            case R.id.b12:
                if (PLAYER_X) {
                    viewInterface.setdbtn12("X");
                    boardStatus[1][2] = 1;
                } else {
                    viewInterface.setdbtn12("0");
                    boardStatus[1][2] = 0;
                }
                break;

            case R.id.b20:
                if (PLAYER_X) {
                    viewInterface.setdbtn20("X");
                    boardStatus[2][0] = 1;
                } else {
                    viewInterface.setdbtn20("0");
                    boardStatus[2][0] = 0;
                }
                break;

            case R.id.b21:
                if (PLAYER_X) {
                    viewInterface.setPlayerstep("X");
                    viewInterface.setdbtn21("X");
                    boardStatus[2][1] = 1;
                } else {
                    viewInterface.setdbtn21("0");
                    boardStatus[2][1] = 0;
                }

                break;

            case R.id.b22:
                if (PLAYER_X) {
                    viewInterface.setdbtn22("X");
                    boardStatus[2][2] = 1;
                } else {
                    viewInterface.setdbtn22("0");
                    boardStatus[2][2] = 0;
                }

                break;

            case R.id.bReset:
                btnresetpressed = true;
                break;

            default:
                break;
        }

        if (btnresetpressed) {
            resetBoard();
            viewInterface.setresult("");
            viewInterface.enabledisablebtn(true);
        }
        if (nowOfBox == 0) {
            viewInterface.showwinnerDialog("None");
            resetBoard();
            viewInterface.setresult("");
            viewInterface.enabledisablebtn(true);
        }

        checkWhoIsWinner();

        if (iswinnerFound == 1) {
            viewInterface.showwinnerDialog(winnerName);
            viewInterface.setresult("");
            viewInterface.enabledisablebtn(false);
        } else{
            nextPlayer();
        }
    }

    @Override
    public void resetBoard() {
        viewInterface.setdbtn00("");
        viewInterface.setdbtn01("");
        viewInterface.setdbtn02("");

        viewInterface.setdbtn10("");
        viewInterface.setdbtn11("");
        viewInterface.setdbtn12("");

        viewInterface.setdbtn20("");
        viewInterface.setdbtn21("");
        viewInterface.setdbtn22("");
        viewInterface.setresult("");
        nowOfBox = 9;
        iswinnerFound = 0;
        PLAYER_X = true;
        initializeBoardStatus();


    }


    @Override
    public void nextPlayer() {
        if (nowOfBox > 0) {
            if (PLAYER_X) {
                viewInterface.setresult("X");
            } else
                viewInterface.setresult("0");
            PLAYER_X = !PLAYER_X;
            nowOfBox = nowOfBox - 1;
        }

    }

}
