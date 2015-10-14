package com.albinpoignot.foursquarepoc.network;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;

/**
 * Utils class generating services to connect to Foursquare API
 * Created by Albin on 14/10/2015.
 */
public class FoursquareServiceGenerator
{

    private static final String BASE_URL = "https://api.foursquare.com/v2/";

    // No need to instantiate this class.
    private FoursquareServiceGenerator() { }

    /**
     * Create a client for the given interface
     * @param serviceClass
     * @param <S>
     * @return
     */
    public static <S> S createService(Class<S> serviceClass)
    {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setClient(new OkClient(new OkHttpClient()));

        // TODO Remove the logging of every requests
        builder.setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog("Retrofit"));

        builder.setRequestInterceptor(new RequestInterceptor()
        {
            @Override
            public void intercept(RequestFacade request)
            {
                // TODO Put the credentials somewhere else

                // Add credentials
                request.addQueryParam("client_id", "JTPSFKFL10KHLGQS2ITTTOUSD0JMS1MBRJ0GVYSXHEGSBOKJ");
                request.addQueryParam("client_secret", "VXWOZEBI0KCKBWBKZ4GJPMDMPKI5EYEJOFR13450IR1X2KMC");
                request.addQueryParam("v", "20151014");
            }
        });

        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }

}
