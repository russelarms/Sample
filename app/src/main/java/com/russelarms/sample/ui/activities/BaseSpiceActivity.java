package com.russelarms.sample.ui.activities;

import android.support.v7.app.AppCompatActivity;

import com.octo.android.robospice.SpiceManager;
import com.russelarms.sample.data.network.RetrofitSpiceService;

/**
 * Created by Ruslan on 09.01.2016.
 */
public abstract class BaseSpiceActivity extends AppCompatActivity {
    private SpiceManager spiceManager = new SpiceManager(RetrofitSpiceService.class);

    @Override
    protected void onStart() {
        spiceManager.start(this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        spiceManager.shouldStop();
        super.onStop();
    }

    public SpiceManager getSpiceManager() {
        return spiceManager;
    }
}
