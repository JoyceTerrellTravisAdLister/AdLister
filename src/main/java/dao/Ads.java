package dao;

import models.Ad;

public interface Ads {
    Ads getAllAds();
    Ads getAdsByUser(long id);
    Ads insertAd(Ad ad);
}
