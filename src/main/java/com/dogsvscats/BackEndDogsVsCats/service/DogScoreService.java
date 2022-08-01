
package com.dogsvscats.BackEndDogsVsCats.service;

import com.dogsvscats.BackEndDogsVsCats.model.DogScore;
import com.dogsvscats.BackEndDogsVsCats.repository.DogScoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogScoreService implements IDogScoreService{

    @Autowired
    private DogScoreRepository dogRepo;
    
    @Override
    public void saveDogScore(DogScore dogScore) {
        dogRepo.save(dogScore);
    }

    @Override
    public List<DogScore> getDogScoreList() {
        List<DogScore>dogScoreList = dogRepo.findAll();
        return dogScoreList;
    }

    @Override
    public List<DogScore> findDogScore(String url) {
        List<DogScore>DogScoreListByUrl = dogRepo.findByUrl(url);
        return DogScoreListByUrl;
    }
    
}
