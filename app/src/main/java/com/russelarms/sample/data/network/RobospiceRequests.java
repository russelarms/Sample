package com.russelarms.sample.data.network;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;
import com.russelarms.sample.data.model.PxResponse;
import com.russelarms.sample.utils.Constants;


/**
 * Created by Ruslan on 09.01.2016
 */
public class RobospiceRequests {

    public static final String TAG = "RobospiceRequests";

    public static class GetApiPhotos extends RetrofitSpiceRequest<PxResponse, PxAPI> {

        private int page;

        public GetApiPhotos(int page) {
            super(PxResponse.class, PxAPI.class);
            setRetryPolicy(null);
            this.page = page;
        }

        @Override
        public PxResponse loadDataFromNetwork() {
            return getService().getPhotos(Constants.CONSUMER_KEY, Constants.FEATURE_POPULAR, page, Constants.MAX_IMAGE_SIZE);
        }
    }

}
