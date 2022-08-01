
package com.dogsvscats.BackEndDogsVsCats.service;

import com.dogsvscats.BackEndDogsVsCats.model.CatScore;
import java.util.List;


public interface ICatScoreService {
    
    public void saveCatScore(CatScore catScore);
    
    public List<CatScore> getCatScoreList();
    
    public List<CatScore> findCatScore(String url);
}
