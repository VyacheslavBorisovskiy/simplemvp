package com.borisovskiy.simplemvp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.borisovskiy.simplemvp.R;
import com.borisovskiy.simplemvp.adapter.RecViewAdapter;
import com.borisovskiy.simplemvp.contract.Contract;
import com.borisovskiy.simplemvp.contract.Contract.IPresenter;
import com.borisovskiy.simplemvp.model.QuoteModel;
import com.borisovskiy.simplemvp.presenter.Presenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements Contract.IView {

    @Inject
    QuoteModel quoteModel;
    private final RecViewAdapter recViewAdapter = new RecViewAdapter();
    @BindView(R.id.list)
    RecyclerView recyclerView;
    private IPresenter presenter;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        presenter = new Presenter(quoteModel, this);
        initialiseRecyclerView();
    }

    private void initialiseRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recViewAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onAttachUI();
    }

    @Override
    public void setData(List<String> items) {
        recViewAdapter.setItems(items);
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        presenter.onDetachUI();
        super.onDestroy();
    }
}