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
	private static final String BASE_URL = "https://api.foursquare.com/v2/";

	private static final String CLIENT_ID_KEY = "client_id";

	private static final String CLIENT_SECRET_KEY = "client_secret";

	private static final String VERSION_KEY = "v";

	private static final String LANGUAGE_HEADER_KEY = "Accept-Language";

	private FoursquareClientGenerator()
	{
	}

	/**
	 * Create a client for the given interface
	 * @param serviceClass
	 * @param <S>
	 * @return
	 */
	public static <S> S createClient(Class<S> serviceClass)
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
				request.addQueryParam(CLIENT_ID_KEY, "JTPSFKFL10KHLGQS2ITTTOUSD0JMS1MBRJ0GVYSXHEGSBOKJ");
				request.addQueryParam(CLIENT_SECRET_KEY, "VXWOZEBI0KCKBWBKZ4GJPMDMPKI5EYEJOFR13450IR1X2KMC");
				request.addQueryParam(VERSION_KEY, "20151014");

				// Force language to the locale
				request.addHeader(LANGUAGE_HEADER_KEY, Locale.getDefault().getLanguage());
			}
		});

		RestAdapter adapter = builder.build();

		return adapter.create(serviceClass);
	}
}
