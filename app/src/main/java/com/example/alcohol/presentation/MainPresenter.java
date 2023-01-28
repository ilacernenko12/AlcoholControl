package com.example.alcohol.presentation;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.widget.Chronometer;

import com.example.alcohol.view.MainView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private static final String CHRONOMETER_FORMAT = "%d m %d d %s h %s m %s s";

    @SuppressLint("DefaultLocale")
    public void startChronometer(Chronometer chronometer) {
        chronometer.setOnChronometerTickListener(cArg -> {
            long time = SystemClock.elapsedRealtime() - cArg.getBase();
            int day = 0;
            int month = 0;
            int h = (int) (time / 3600000);
            int m = (int) (time - h * 3600000) / 60000;
            int s = (int) (time - h * 3600000 - m * 60000) / 1000;
            String hh = h < 10 ? "0" + h : h + "";
            String mm = m < 10 ? "0" + m : m + "";
            String ss = s < 10 ? "0" + s : s + "";

            if (h == 23 && m == 59 && s == 59) {
                day++;
            }
            if (day == 30) {
                month++;
            }
            cArg.setText(String.format(CHRONOMETER_FORMAT, month, day, hh, mm, ss));
        });
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
    }

    @SuppressLint("DefaultLocale")
    public void resetChronometer(Chronometer chronometer) {
        chronometer.stop();
        chronometer.setOnChronometerTickListener(cArg -> {
            long time = SystemClock.elapsedRealtime() - cArg.getBase();
            int day = 0;
            int month = 0;
            int h = (int) (time / 3600000);
            int m = (int) (time - h * 3600000) / 60000;
            int s = (int) (time - h * 3600000 - m * 60000) / 1000;
            String hh = h < 10 ? "0" + h : h + "";
            String mm = m < 10 ? "0" + m : m + "";
            String ss = s < 10 ? "0" + s : s + "";
            cArg.setText(String.format(CHRONOMETER_FORMAT, month, day, hh, mm, ss));
        });
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
    }

    public void showWelcomeDialog() {
        getViewState().showAlertDialog();
    }

    public void showStatisticsFragment(){
        getViewState().showFragment();
    }

    public void returnToActivity() {
        getViewState().backToActivity();
    }
}
