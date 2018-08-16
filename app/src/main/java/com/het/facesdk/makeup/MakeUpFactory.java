package com.het.facesdk.makeup;

import com.het.facesdk.makeup.matrix.BiMatrix;
import com.het.facesdk.makeup.matrix.CameraMatrix;
import com.het.facesdk.makeup.matrix.WindowMatrix;

public class MakeUpFactory {

    public static final int CAMERA = 0;
    public static final int BALTILE = CAMERA + 1;
    public static final int WINDOW = BALTILE + 1;


    public static MakeUpEngine.IMatrix create(int type, int id) {
        switch (type) {
            case CAMERA:
                return new CameraMatrix(id);
            case BALTILE:
                return new BiMatrix(id);
            case WINDOW:
                return new WindowMatrix(id);
        }
        return null;
    }


}
