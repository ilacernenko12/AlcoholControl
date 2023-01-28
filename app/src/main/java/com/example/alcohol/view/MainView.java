package com.example.alcohol.view;


import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface MainView extends MvpView{
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showAlertDialog();
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showFragment();
    @StateStrategyType(AddToEndSingleStrategy.class)
    void backToActivity();
}
