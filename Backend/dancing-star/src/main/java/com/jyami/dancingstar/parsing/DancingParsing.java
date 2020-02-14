package com.jyami.dancingstar.parsing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jyami on 2020/02/14
 */

public class DancingParsing {
    public static Integer getTotalScore(List<String> scoreList){
        return scoreList.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public static List<String> stringToStringList(String string){
        return Arrays.stream(string.split("\n"))
                .collect(Collectors.toList());
    }

    public static String stringListToString(List<String> strings){
        return strings.stream()
                .collect(Collectors.joining(","));
    }

    public static String getTimeFromPath(String path){
        return path.replace("images/image-frame","").replace(".jpg","");
    }

}
