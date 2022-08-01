
package com.dogsvscats.BackEndDogsVsCats.repository;

import com.dogsvscats.BackEndDogsVsCats.model.CatScore;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatScoreRepository extends JpaRepository<CatScore, Long> {
    List<CatScore> findByUrl(String url);
}
