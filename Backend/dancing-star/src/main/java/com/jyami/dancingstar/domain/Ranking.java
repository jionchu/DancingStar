package com.jyami.dancingstar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by jyami on 2020/02/11
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ranking {
    private Long id;        // PK
    private Long dancingId; // FK
    private String nickName;
    private String userVideoPath;
    private String registerTime;    // Register Time

    // score
    private Integer faceScore;
    private Integer gazeScore;
    private Integer consistencyScore;
    private Integer accuracyScore;
    private Integer comboScore;
    private Integer totalScore;
}
