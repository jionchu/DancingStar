package com.jyami.dancingstar.domain;

import java.util.List;

/**
 * Created by jyami on 2020/02/11
 */
public class DancingSpots {
        private Long id;
        private String time;
        private List<PoseSpot> poseSpots;

        public class PoseSpot {
                private SPOT_TYPE spotType;
                private String x;
                private String y;
                private String score;
        }
}
