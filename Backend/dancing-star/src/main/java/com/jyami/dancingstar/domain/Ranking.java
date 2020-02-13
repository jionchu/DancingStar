package com.jyami.dancingstar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by jyami on 2020/02/11
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ranking")
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        // PK

    private Long dancing_id; // FK
    private String nickName;
    private String userVideoPath;

    @CreatedDate
    private LocalDateTime createdDate;

    // score
    private Integer faceScore;
    private Integer gazeScore;
    private Integer consistencyScore;
    private Integer accuracyScore;
    private Integer comboScore;
    private Integer totalScore;
}
