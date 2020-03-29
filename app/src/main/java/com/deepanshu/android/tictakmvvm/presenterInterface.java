package com.deepanshu.android.tictakmvvm;

import android.view.View;

public interface presenterInterface {
    void initializeBoardStatus();
    void setPLAYER_XPostion();
    void checkWhoIsWinner();
    void onclickonGamecubes(View v);
    void resetBoard();
    void nextPlayer();
}
