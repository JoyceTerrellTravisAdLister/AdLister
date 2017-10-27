package dao;

import models.Ad;

import java.util.List;

public interface Ads {
    List<Ad> getAllAds();
    List<Ad> getAdsByUser(long id);
    long insertAd(Ad ad);
    Ad getAdById(long id);
}
