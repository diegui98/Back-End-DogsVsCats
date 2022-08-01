
package com.dogsvscats.BackEndDogsVsCats.service;

import com.dogsvscats.BackEndDogsVsCats.model.CatScore;
import com.dogsvscats.BackEndDogsVsCats.repository.CatScoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatScoreService implements ICatScoreService{

    @Autowired
    private CatScoreRepository catRepo;
    
    @Override
    public void saveCatScore(CatScore catScore) {
        catRepo.save(catScore);
    }

    @Override
    public List<CatScore> getCatScoreList() {
        List<CatScore>catScoreList = catRepo.findAll();
        return catScoreList;
    }

    @Override
    public List<CatScore> findCatScore(String url) {
        List<CatScore>catScoreListByUrl = catRepo.findByUrl(url);
        return catScoreListByUrl;
    }
    
}
