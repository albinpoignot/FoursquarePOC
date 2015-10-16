package com.albinpoignot.foursquarepoc.network.listeners;

/**
 * Generic service listener. Only handle errors.
 * Created by Albin POIGNOT on 15/10/15.
 */
public interface GenericServiceListener
{
    /**
     * Called when an error occured during a service's operation.
     *
     * @param resId the id of the String resources holding the message to display to the user
     */
    void onError(Integer resId);
}
