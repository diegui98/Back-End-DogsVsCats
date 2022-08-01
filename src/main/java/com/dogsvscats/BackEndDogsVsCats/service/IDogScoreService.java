
package com.dogsvscats.BackEndDogsVsCats.service;

import com.dogsvscats.BackEndDogsVsCats.model.DogScore;
import java.util.List;


public interface IDogScoreService {
    
    public void saveDogScore(DogScore dogScore);
    
    public List<DogScore> getDogScoreList();
    
    public List<DogScore> findDogScore(String url);
    
}
