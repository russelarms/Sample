package com.russelarms.sample.data.network;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.octo.android.robospice.persistence.CacheManager;
import com.octo.android.robospice.persistence.binary.InFileBitmapObjectPersister;
import com.octo.android.robospice.persistence.exception.CacheCreationException;
import com.octo.android.robospice.persistence.retrofit.GsonRetrofitObjectPersisterFactory;
import com.octo.android.robospice.persistence.string.InFileStringObjectPersister;
import com.octo.android.robospice.retrofit.RetrofitSpiceService;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

/**
 * Created by Ruslan on 09.01.2016.
 */
public abstract class RetrofitGsonSpiceService extends RetrofitSpiceService {

    @Override
    public CacheManager createCacheManager(Application application) throws CacheCreationException {
        CacheManager cacheManager = new CacheManager();
        cacheManager.addPersister(new GsonRetrofitObjectPersisterFactory(application, getConverter(), getCacheFolder(application)));
        // init
        InFileStringObjectPersister inFileStringObjectPersister = new InFileStringObjectPersister(application);
        InFileBitmapObjectPersister inFileBitmapObjectPersister = new InFileBitmapObjectPersister(application);

        cacheManager.addPersister(inFileStringObjectPersister);
        cacheManager.addPersister(inFileBitmapObjectPersister);
        return cacheManager;
    }

    @Override
    protected RestAdapter.Builder createRestAdapterBuilder() {
        OkHttpClient okClient = new OkHttpClient();
        okClient.networkInterceptors().add(new LoggingInterceptor());

        return new RestAdapter.Builder()
                .setClient(new OkClient(okClient))
                .setEndpoint(getServerUrl())
                .setConverter(getConverter());
    }

    @Override
    protected Converter createConverter() {
        Gson gson = new GsonBuilder()
//                .setExclusionStrategies(new AnnotationExclusionStrategy())
                .create();

        return  new GsonConverter(gson);
    }

    public File getCacheFolder(Application application) {
        return application.getCacheDir();
    }
}
