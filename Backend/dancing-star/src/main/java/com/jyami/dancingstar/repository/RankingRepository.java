package com.jyami.dancingstar.repository;

import com.jyami.dancingstar.domain.Ranking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jyami on 2020/02/12
 */
@Repository
public interface RankingRepository extends MongoRepository<Ranking, String> {
}
