package com.example.alcohol.ui;


import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.alcohol.R;
import com.example.alcohol.databinding.ActivityMainBinding;
import com.example.alcohol.databinding.DialogWelcomeBinding;
import com.example.alcohol.fragment.StatisticsFragment;
import com.example.alcohol.presentation.MainPresenter;
import com.example.alcohol.view.MainView;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @InjectPresenter
    MainPresenter mainPresenter;
    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("HUI", "onCreate");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mainPresenter.startChronometer(binding.chronometer);
        setListeners();
        mainPresenter.showWelcomeDialog();
    }

    private void setListeners() {
        binding.btnDrink.setOnClickListener(view -> {
            mainPresenter.resetChronometer(binding.chronometer);
            long time = binding.chronometer.getBase()/1000;
            binding.textView.setText(String.valueOf(time));
            System.out.println();
        });

        binding.btnMiniDrink.setOnClickListener(view -> {
            mainPresenter.resetChronometer(binding.chronometer);
        });

        binding.btnShowStatistics.setOnClickListener(view -> {
            mainPresenter.showStatisticsFragment();
        });

        binding.btnHideStatistics.setOnClickListener(view -> {
            mainPresenter.returnToActivity();
        });
    }

    @Override
    public void showAlertDialog() {
        DialogWelcomeBinding dialogWelcomeBinding = DialogWelcomeBinding.inflate(getLayoutInflater(), null, false);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogWelcomeBinding.getRoot())
                .setCancelable(false)
                .create();
        dialog.show();

        dialogWelcomeBinding.btnStart.setOnClickListener(view -> {
            dialog.cancel();
        });
    }

    @Override
    public void showFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.layoutForFragment, StatisticsFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
        binding.btnHideStatistics.setVisibility(View.VISIBLE);
        binding.btnShowStatistics.setVisibility(View.GONE);
    }

    @Override
    public void closeFragment() {
        getSupportFragmentManager().popBackStack();

        binding.btnShowStatistics.setVisibility(View.VISIBLE);
        binding.btnHideStatistics.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("HUI", "onDestroy");
        binding = null;
    }
}
