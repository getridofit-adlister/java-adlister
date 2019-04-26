package com.codeup.adlister.models;

public class UserAd {
    private User user;
    private Ad ad;

    public UserAd(User user, Ad ad) {
        this.user = user;
        this.ad = ad;
    }
    public UserAd(){}

    public User getUser() {
        return user;
    }

    public Ad getAd() {
        return ad;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}
