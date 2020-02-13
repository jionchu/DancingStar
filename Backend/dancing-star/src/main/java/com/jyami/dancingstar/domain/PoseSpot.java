package com.jyami.dancingstar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * Created by jyami on 2020/02/13
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PoseSpot {

    private int poseSpotId;

    private int spotType;
    private String x;
    private String y;
    private String score;
}
