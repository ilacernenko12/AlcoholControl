package com.example.alcohol.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alcohol.R;
import com.example.alcohol.presentation.StatisticsPresenter;
import com.example.alcohol.recyclerView.Information;
import com.example.alcohol.recyclerView.StatisticsAdapter;
import com.example.alcohol.view.StatisticsView;

import java.time.LocalDateTime;
import java.util.ArrayList;

import moxy.presenter.InjectPresenter;

public class StatisticsFragment extends Fragment implements StatisticsView {
    @InjectPresenter
    StatisticsPresenter presenter;
    private ArrayList<Information> infoList = new ArrayList<>();
    private RecyclerView recyclerView;

    private void init(){

        infoList.add(new Information(LocalDateTime.now(), "Вы бухнули", "Продержались 0 дней 1 месяц 3 часа 15 сек"));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        StatisticsAdapter adapter = new StatisticsAdapter(infoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getLayoutInflater().getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }
}