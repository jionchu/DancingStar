package com.jyami.dancingstar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Created by jyami on 2020/02/11
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ranking {

    private Long id;        // PK

    private Long dancing_id; // FK
    private String nickName;
    private String userVideoPath;

    private LocalDateTime createdDate;

    // score
    private Integer faceScore;
    private Integer gazeScore;
    private Integer consistencyScore;
    private Integer accuracyScore;
    private Integer comboScore;
    private Integer totalScore;
}
