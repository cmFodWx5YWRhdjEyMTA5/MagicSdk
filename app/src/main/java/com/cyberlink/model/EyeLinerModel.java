package com.cyberlink.model;


/**
 * 眼线Model
 *
 * @Galis
 */
public class EyeLinerModel extends EyeModel {

    public String name;
    public int color;
    public int compress;
    public int layers;
    public byte[][] src;


    public EyeLinerModel(String name, int w, int h, String[] bitmapPath) {
        this.name = name;
        if (bitmapPath == null) {
            return;
        }
        this.width = w;
        this.height = h;
        layers = bitmapPath.length;
        src = new byte[layers][];


    }


}
