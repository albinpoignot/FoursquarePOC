package com.albinpoignot.foursquarepoc.network.entities;

/**
 * Created by Albin on 15/10/2015.
 */
public class FoursquareHour
{
    private String status;

    private Boolean isOpen;

    public Boolean getIsOpen()
    {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen)
    {
        this.isOpen = isOpen;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
