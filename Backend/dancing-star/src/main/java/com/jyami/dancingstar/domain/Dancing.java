package com.jyami.dancingstar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by jyami on 2020/02/11
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "dancing")
public class Dancing {
    @Id
    private String id;
    private String title;
    private String artist;
    private String albumImage = null; // 일단은 Null
    private String videoPath;
    private List<DancingSpots> accuracySpots;
    private List<DancingSpots> consistencySpots;


}
