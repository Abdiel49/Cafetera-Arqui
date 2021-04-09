package com.UI.gui;

import java.awt.Color;

public enum Colors {
    SUCCESS (120,210,150),
    ERROR   (200,75,50),
    INACTIVE(222,222,222);

    private final int red, green, blue;

    Colors(int r, int g, int b){
        red = r;
        green = g;
        blue = b;
    }

    public Color getColor(){
        return new Color(red, green, blue);
    }
}
