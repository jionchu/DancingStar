package com.jyami.dancingstar.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by jyami on 2020/02/11
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SaveDanceReqDto {
    private String title;
    private String path;
    private List<String> accuracytTimeList;


}
