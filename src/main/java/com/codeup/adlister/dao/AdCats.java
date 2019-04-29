package com.codeup.adlister.dao;

public interface AdCats {
    String insert(long adId, long catid);

    String delete(long adId);
}
