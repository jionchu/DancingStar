package com.jyami.dancingstar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Created by jyami on 2020/02/13
 */
@Entity(name = "pose_spot")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PoseSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int poseSpotId;

    private int spotType;
    private String x;
    private String y;
    private String score;
}
