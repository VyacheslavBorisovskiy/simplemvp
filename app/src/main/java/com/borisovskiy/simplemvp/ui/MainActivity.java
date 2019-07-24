package com.borisovskiy.simplemvp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.borisovskiy.simplemvp.R;
import com.borisovskiy.simplemvp.contract.Contract;

public class MainActivity extends AppCompatActivity implements Contract.IHost {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }


    }


}