package com.borisovskiy.simplemvp.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.borisovskiy.simplemvp.R;
import com.borisovskiy.simplemvp.adapter.RecViewAdapter;
import com.borisovskiy.simplemvp.contract.Contract;
import com.borisovskiy.simplemvp.contract.Contract.IPresenter;
import com.borisovskiy.simplemvp.model.QuoteModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

public class MainFragment extends Fragment implements Contract.IView {

    private final RecViewAdapter recViewAdapter = new RecViewAdapter();
    @BindView(R.id.list)
    RecyclerView recyclerView;
    @Inject
    IPresenter presenter;
    @Inject
    QuoteModel quoteModel;
    private Unbinder unbinder;

    @Inject
    public MainFragment() {
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
//        presenter = new Presenter(this, new QuoteModel());
        System.out.println(quoteModel + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    private void initialiseRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recViewAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initialiseRecyclerView();
        return view;
    }

    @Override
    public void setData(List<String> items) {
        recViewAdapter.setItems(items);
    }


    @Override
    public void onStart() {
        super.onStart();
        presenter.onAttachUI();
    }

    @Override
    public void onStop() {
//        presenter.onDetachUI();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
