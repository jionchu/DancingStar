package com.jyami.dancingstar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by jyami on 2020/02/13
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccuracySpot {
    private Long id;
    private String time;
    private List<PoseSpot> poseSpots;

}
