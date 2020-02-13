package com.jyami.dancingstar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jyami on 2020/02/13
 */
@Entity(name = "accuracy_spot")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccuracySpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String time;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "accuracy_spot")
    private List<PoseSpot> poseSpots;

}
