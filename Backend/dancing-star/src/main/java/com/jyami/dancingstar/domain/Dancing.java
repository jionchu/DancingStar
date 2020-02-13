package com.jyami.dancingstar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by jyami on 2020/02/11
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Dancing {

    private Long dancingId;
    private String title;
    private String artist;
    private String albumImage = null; // 일단은 Null
    private String videoPath;

    private List<DancingSpot> dancingSpots;

    private List<AccuracySpot> accuracySpots;


}
