package com.jyami.dancingstar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jyami on 2020/02/11
 */

@Entity(name = "dancing")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Dancing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dancingId;
    private String title;
    private String artist;
    private String albumImage = null; // 일단은 Null
    private String videoPath;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "dancing")
    private List<DancingSpot> dancingSpots;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "dancing")
    private List<AccuracySpot> accuracySpots;


}
