package com.albinpoignot.foursquarepoc.network;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

/**
 * Created by Albin POIGNOT on 15/10/15.
 */
public class GenericErrorHandler implements ErrorHandler
{
	@Override
	public Throwable handleError(RetrofitError cause)
	{
		// Every all non-200 http codes
		//cause.getKind() == RetrofitError.Kind.HTTP;

		// IO error while contacting the server
		//cause.getKind() == RetrofitError.Kind.NETWORK;
		return null;
	}
}
