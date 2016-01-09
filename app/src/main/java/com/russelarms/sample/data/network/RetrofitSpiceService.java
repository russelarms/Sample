package com.russelarms.sample.data.network;


/**
 * Created by Ruslan on 09.01.2016.
 */
public class RetrofitSpiceService extends RetrofitGsonSpiceService {

    private final static String BASE_URL = "https://api.500px.com/v1";

    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(PxAPI.class);
        createConverter();
    }

    @Override
    protected String getServerUrl() {
        return BASE_URL;
    }

}
