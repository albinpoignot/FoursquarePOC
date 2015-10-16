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
     * Returns an internal error depending of the network error that occured
     *
     * @param kind the kind of error
     * @return a ServiceError corresponding to the network error that occured
     */
    protected ServiceError getInternalError(RetrofitError.Kind kind)
    {
        ServiceError error;
        if (kind == RetrofitError.Kind.HTTP)
        {
            error = ServiceError.NETWORK_ERROR;
        }
        else if (kind == RetrofitError.Kind.NETWORK)
        {
            error = ServiceError.NO_NETWORK_ERROR;
        }
        else
        {
            error = ServiceError.UNKNOWN;
        }
        return error;
    }
}
