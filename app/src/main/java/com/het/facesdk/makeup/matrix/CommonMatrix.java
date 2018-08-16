package com.het.facesdk.makeup.matrix;

import com.het.facesdk.makeup.MakeUpEngine;

public abstract class CommonMatrix implements MakeUpEngine.IMatrix {

    private int mTextureId;

    public CommonMatrix(int mTextureId) {
        this.mTextureId = mTextureId;
    }

    @Override
    public int textureId() {
        return mTextureId;
    }
}
