package com.borisovskiy.simplemvp.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.borisovskiy.simplemvp.R;
import com.borisovskiy.simplemvp.contract.MainContract;
import com.borisovskiy.simplemvp.contract.MainContract.MainPresenter;
import com.borisovskiy.simplemvp.model.QuoteImpl;
import com.borisovskiy.simplemvp.presenter.MainPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.quotes_tv)
    TextView quotesTextView;
    private MainPresenter presenter;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        presenter = new MainPresenterImpl(this, new QuoteImpl());

        button.setOnClickListener(v -> presenter.onButtonClick());
    }

    @Override
    public void setQuote(String string) {
        quotesTextView.setText(string);
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        presenter.onDestroy();
        super.onDestroy();
    }
}