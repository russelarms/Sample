package com.russelarms.sample.data.network;

import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.russelarms.sample.utils.Lg;

/**
 * Created by Ruslan on 09.01.2016
 */
public abstract class AbstractRequestListener<T> implements RequestListener<T> {
    public static final String TAG = "AbstractRequestListener";

    @Override
    public void onRequestFailure(SpiceException spiceException) {
        if (spiceException.getCause() != null)
            Lg.e(TAG, "request failure " + " | " + spiceException.getCause().toString());
        else
            Lg.e(TAG, "request failure " + " | " + spiceException.toString());

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement s : stackTrace) {
            Lg.e(TAG, s.toString());
        }
    }
}

