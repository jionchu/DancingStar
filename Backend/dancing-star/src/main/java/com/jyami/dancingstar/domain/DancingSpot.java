package com.jyami.dancingstar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jyami on 2020/02/11
 */
@Entity(name = "dancing_spot")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DancingSpot {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String time;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "dancing_spot")
        private List<PoseSpot> poseSpots;

}
