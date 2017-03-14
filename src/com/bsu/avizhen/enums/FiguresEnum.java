package com.bsu.avizhen.enums;

import java.util.Arrays;

/**
 * Created by Александр on 12.03.2017.
 */
public enum FiguresEnum {
    SEGMENT("segment"),
    RAY("ray"),
    LINE("line"),
    CIRCLE("circle"),
    POLYGON("polygon"),
    ELLIPSE("ellipse"),
    REGULAR_POLYGON("regular polygon"),
    SYMMETRIC_POLYGON("symmetric polygon"),
    RECTANGLE("rectangle"),
    TRIANGLE("triangle");

    private String name;

    FiguresEnum(String name) {
        this.name = name;
    }

    public static FiguresEnum getFigureByName(String s) {
        return Arrays.stream(FiguresEnum.values()).filter(f -> s.equalsIgnoreCase(f.name)).findFirst().get();
    }
}
