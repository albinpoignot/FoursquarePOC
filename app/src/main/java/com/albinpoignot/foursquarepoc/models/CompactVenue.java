package com.albinpoignot.foursquarepoc.models;

import java.util.List;

/**
 * Created by Albin on 14/10/2015.
 */
public class CompactVenue {

    private String id;

    private String name;

    private Contact contact;

    private Location location;

    private List<Category> categories;

    private String verified;

    private Stats stats;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "CompactVenue{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contact=" + contact +
                ", location=" + location +
                ", categories=" + categories +
                ", verified='" + verified + '\'' +
                ", stats=" + stats +
                '}';
    }
}
