package com.albinpoignot.foursquarepoc.network;

import com.squareup.okhttp.OkHttpClient;

import java.util.Locale;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;

/**
 * Utils class generating services to connect to Foursquare API
 * Created by Albin on 14/10/2015.
 */
public class FoursquareClientGenerator
{
    /**
     * Base URL of the Foursquare API
     */
    private static final String BASE_URL = "https://api.foursquare.com/v2/";

    /**
     * Client ID request param key
     */
    private static final String CLIENT_ID_KEY = "client_id";

    /**
     * Client key request param key
     */
    private static final String CLIENT_SECRET_KEY = "client_secret";

    /**
     * Version request param key
     */
    private static final String VERSION_KEY = "v";

    /**
     * Accept-Language HTTP request's header key
     */
    private static final String LANGUAGE_HEADER_KEY = "Accept-Language";

    /**
     * Client ID value. Storing it here just in the context of this POC.
     */
    private static final String CLIENT_ID_VALUE = "JTPSFKFL10KHLGQS2ITTTOUSD0JMS1MBRJ0GVYSXHEGSBOKJ";

    /**
     * Client key value. Storing it here just in the context of this POC.
     */
    private static final String CLIENT_KEY_VALUE = "VXWOZEBI0KCKBWBKZ4GJPMDMPKI5EYEJOFR13450IR1X2KMC";

    /**
     * Value value. Storing it here just in the context of this POC.
     */
    private static final String VERSION_VALUE = "20151014";

    private FoursquareClientGenerator()
    {
    }

    /**
     * Create a client for the given interface
     *
     * @param serviceClass the Service interface
     * @param <S>          the Service interface
     * @return an instantiated Service, corresponding to the given interface
     */
    public static <S> S createClient(Class<S> serviceClass)
    {
        // Configuring basic builder with OkHttpClient
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setClient(new OkClient(new OkHttpClient()));

        // TODO Remove the logging of every requests
        builder.setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog("Retrofit"));

        // Intercept every requests to add authentication and locale information
        builder.setRequestInterceptor(new RequestInterceptor()
        {
            @Override
            public void intercept(RequestFacade request)
            {
                // Add credentials
                request.addQueryParam(CLIENT_ID_KEY, CLIENT_ID_VALUE);
                request.addQueryParam(CLIENT_SECRET_KEY, CLIENT_KEY_VALUE);
                request.addQueryParam(VERSION_KEY, VERSION_VALUE);

                // Set language of the response to the Locale's language
                request.addHeader(LANGUAGE_HEADER_KEY, Locale.getDefault().getLanguage());
            }
        });

        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }
}
