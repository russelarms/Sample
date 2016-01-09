package com.russelarms.sample.data.managers;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.request.listener.RequestListener;
import com.russelarms.sample.data.model.PxResponse;
import com.russelarms.sample.data.network.RobospiceRequests;

/**
 * Created by Ruslan on 09.01.2016.
 */
public class DataManager {

    private static DataManager INSTANCE = new DataManager();

    public static DataManager getInstance() {
        return INSTANCE;
    }

    public void getPhotos(int page, RequestListener<PxResponse> listener, SpiceManager sm) {
        RobospiceRequests.GetApiPhotos request = new RobospiceRequests.GetApiPhotos(page);
        sm.execute(request, listener);
    }
}
