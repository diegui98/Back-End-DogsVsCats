
package com.dogsvscats.BackEndDogsVsCats.repository;

import com.dogsvscats.BackEndDogsVsCats.model.DogScore;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogScoreRepository extends JpaRepository<DogScore, Long> {
    List<DogScore> findByUrl(String url);
}
