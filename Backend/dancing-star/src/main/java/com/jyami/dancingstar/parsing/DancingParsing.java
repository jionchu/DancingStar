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

    public static String getKey(String parsing){
        return parsing.split(":")[0];
    }

    public static String getValue(String parsing){
        return parsing.split(":")[1];
    }

    public static List<String> splitComma(String strings){
        return Arrays.stream(strings.split(","))
                .collect(Collectors.toList());
    }

    public static String getTimeFromPath(String path){
        return path.replace("images/image-frame","").replace(".jpg","");
    }

}
