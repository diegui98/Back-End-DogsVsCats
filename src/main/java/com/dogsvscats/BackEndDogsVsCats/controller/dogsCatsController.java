
package com.dogsvscats.BackEndDogsVsCats.controller;

import com.dogsvscats.BackEndDogsVsCats.DTO.CatDTO;
import com.dogsvscats.BackEndDogsVsCats.DTO.DogDTO;
import com.dogsvscats.BackEndDogsVsCats.model.CatScore;
import com.dogsvscats.BackEndDogsVsCats.model.DogScore;
import com.dogsvscats.BackEndDogsVsCats.service.ICatScoreService;
import com.dogsvscats.BackEndDogsVsCats.service.IDogScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class dogsCatsController {
    
    @Autowired
    private IDogScoreService interDog;
    
    @Autowired
    private ICatScoreService interCat;
    
    @GetMapping("dogscats/dog/{url}")
    public DogDTO findDogScore(@PathVariable String url){
        
        DogDTO dogData = new DogDTO();
        dogData.setDogWins(interDog.getDogScoreList().size());
        
        List<DogScore> dogScoreByUrl = interDog.findDogScore(url);
        dogData.setDogRating(Math.round(dogScoreByUrl.stream().mapToInt(dog -> dog.getScore()).average().orElse(0) * 100.0) / 100.0);
        
        List<DogScore> dogScoreList = interDog.getDogScoreList();
        dogData.setDogAvg(Math.round(dogScoreList.stream().mapToInt(dog -> dog.getScore()).average().orElse(0) * 100.0) / 100.0);
        
        return dogData;
        
    }
    
    @PostMapping("dogscats/dog/create")
    public String saveDogScore(@RequestBody DogScore dogScore){
        interDog.saveDogScore(dogScore);
        return "Dog Score Saved";
    }
    
    @GetMapping("dogscats/cat/{url}")
    public CatDTO findCatScore(@PathVariable String url){
        
        CatDTO catData = new CatDTO();
        catData.setCatWins(interCat.getCatScoreList().size());
        
        List<CatScore> catScoreByUrl = interCat.findCatScore(url);
        catData.setCatRating(Math.round(catScoreByUrl.stream().mapToInt(cat -> cat.getScore()).average().orElse(0) * 100.0) / 100.0);
        
        List<CatScore> catScoreList = interCat.getCatScoreList();
        catData.setCatAvg(Math.round(catScoreList.stream().mapToInt(cat -> cat.getScore()).average().orElse(0) * 100.0) / 100.0);
        return catData;
    }
    
    @PostMapping("dogscats/cat/create")
    public String saveCatScore(@RequestBody CatScore catScore){
        interCat.saveCatScore(catScore);
        return "Cat Score Saved";
    }
}
