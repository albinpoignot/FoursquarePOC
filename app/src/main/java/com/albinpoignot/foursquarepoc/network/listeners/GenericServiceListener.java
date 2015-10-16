package com.albinpoignot.foursquarepoc.network.listeners;

import com.albinpoignot.foursquarepoc.network.services.ServiceError;

/**
 * Generic service listener. Only handle errors.
 * Created by Albin POIGNOT on 15/10/15.
 */
public interface GenericServiceListener
{
    /**
     * Called when an error occurred during a service's operation.
     *
     * @param serviceError the ServiceError that occurred
     */
    void onError(ServiceError serviceError);
}
