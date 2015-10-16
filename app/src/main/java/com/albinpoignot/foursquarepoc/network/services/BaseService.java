package com.albinpoignot.foursquarepoc.network.services;

import com.albinpoignot.foursquarepoc.R;

import retrofit.RetrofitError;

/**
 * Base class for network Services
 * Created by Albin POIGNOT on 15/10/15.
 */
public abstract class BaseService
{
    /**
     * Returns an internal error depending of the HTTP error that occured
     *
     * @param kind the kind of error
     * @return
     */
    protected Integer getErrorResourceId(RetrofitError.Kind kind)
    {
        Integer resId;
        if (kind == RetrofitError.Kind.HTTP)
        {
            resId = R.string.network_http_error;
        }
        else if (kind == RetrofitError.Kind.NETWORK)
        {
            resId = R.string.network_no_connection;
        }
        else
        {
            resId = R.string.network_unknown_error;
        }
        return resId;
    }
}
