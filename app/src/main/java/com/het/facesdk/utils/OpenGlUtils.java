/*
 * Copyright (C) 2012 CyberAgent
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.het.facesdk.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.hardware.Camera.Size;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class OpenGlUtils {
    private static final String TAG = OpenGlUtils.class.getSimpleName();
    public static final int NO_TEXTURE = -1;

    public static int loadTexture(final Bitmap img, final int usedTexId) {
        return loadTexture(img, usedTexId, true);
    }

    public static int loadTexture(final Bitmap img, final int usedTexId, final boolean recycle) {
        int textures[] = new int[1];
        if (usedTexId == NO_TEXTURE) {
            GLES30.glGenTextures(1, textures, 0);
            GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, textures[0]);
            useTexParameter();
            GLUtils.texImage2D(GLES30.GL_TEXTURE_2D, 0, img, 0);
        } else {
            GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, usedTexId);
            GLUtils.texSubImage2D(GLES30.GL_TEXTURE_2D, 0, 0, 0, img);
            textures[0] = usedTexId;
        }
        if (recycle) {
            img.recycle();
        }
        return textures[0];
    }

    public static int loadTexture(final IntBuffer data, final Size size, final int usedTexId) {
        int textures[] = new int[1];
        if (usedTexId == NO_TEXTURE) {
            GLES30.glGenTextures(1, textures, 0);
            GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, textures[0]);
            useTexParameter();
            GLES30.glTexImage2D(GLES30.GL_TEXTURE_2D, 0, GLES30.GL_RGBA, size.width, size.height,
                    0, GLES30.GL_RGBA, GLES30.GL_UNSIGNED_BYTE, data);
        } else {
            GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, usedTexId);
            GLES30.glTexSubImage2D(GLES30.GL_TEXTURE_2D, 0, 0, 0, size.width,
                    size.height, GLES30.GL_RGBA, GLES30.GL_UNSIGNED_BYTE, data);
            textures[0] = usedTexId;
        }
        return textures[0];
    }

    public static int loadTextureAsBitmap(final IntBuffer data, final Size size, final int usedTexId) {
        Bitmap bitmap = Bitmap
                .createBitmap(data.array(), size.width, size.height, Config.ARGB_8888);
        return loadTexture(bitmap, usedTexId);
    }

    public static void useTexParameter() {
        //设置缩小过滤为使用纹理中坐标最接近的一个像素的颜色作为需要绘制的像素颜色
        GLES30.glTexParameterf(GLES30.GL_TEXTURE_2D, GLES30.GL_TEXTURE_MIN_FILTER, GLES30.GL_NEAREST);
        //设置放大过滤为使用纹理中坐标最接近的若干个颜色，通过加权平均算法得到需要绘制的像素颜色
        GLES30.glTexParameterf(GLES30.GL_TEXTURE_2D, GLES30.GL_TEXTURE_MAG_FILTER, GLES30.GL_LINEAR);
        //设置环绕方向S，截取纹理坐标到[1/2n,1-1/2n]。将导致永远不会与border融合
        GLES30.glTexParameterf(GLES30.GL_TEXTURE_2D, GLES30.GL_TEXTURE_WRAP_S, GLES30.GL_CLAMP_TO_EDGE);
        //设置环绕方向T，截取纹理坐标到[1/2n,1-1/2n]。将导致永远不会与border融合
        GLES30.glTexParameterf(GLES30.GL_TEXTURE_2D, GLES30.GL_TEXTURE_WRAP_T, GLES30.GL_CLAMP_TO_EDGE);
    }

    public static int loadShader(final String strSource, final int iType) {
        int[] compiled = new int[1];
        int iShader = GLES30.glCreateShader(iType);
        GLES30.glShaderSource(iShader, strSource);
        GLES30.glCompileShader(iShader);
        GLES30.glGetShaderiv(iShader, GLES30.GL_COMPILE_STATUS, compiled, 0);
        if (compiled[0] == 0) {
            Log.d("GLES#Load Shader Failed", "Compilation\n" + GLES30.glGetShaderInfoLog(iShader));
            return 0;
        }
        return iShader;
    }

    public static int loadProgram(final String strVSource, final String strFSource) {
        int iVShader;
        int iFShader;
        int iProgId;
        int[] link = new int[1];
        iVShader = loadShader(strVSource, GLES30.GL_VERTEX_SHADER);
        if (iVShader == 0) {
            Log.d("GLES#Load Program", "Vertex Shader Failed");
            return 0;
        }
        iFShader = loadShader(strFSource, GLES30.GL_FRAGMENT_SHADER);
        if (iFShader == 0) {
            Log.d("GLES#Load Program", "Fragment Shader Failed");
            return 0;
        }

        iProgId = GLES30.glCreateProgram();

        GLES30.glAttachShader(iProgId, iVShader);
        GLES30.glAttachShader(iProgId, iFShader);

        GLES30.glLinkProgram(iProgId);

        GLES30.glGetProgramiv(iProgId, GLES30.GL_LINK_STATUS, link, 0);
        if (link[0] <= 0) {
            Log.d("GLES#Load Program", "Linking Failed");
            return 0;
        }
        GLES30.glDeleteShader(iVShader);
        GLES30.glDeleteShader(iFShader);
        return iProgId;
    }

    public static int genVAO(float[] vertexs) {
        int[] vao = new int[1];
        int[] vbo = new int[1];
        GLES30.glGenVertexArrays(1, vao, 0);
        GLES30.glBindVertexArray(vao[0]);

        FloatBuffer vertexBuffer = ByteBuffer.allocateDirect(vertexs.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        vertexBuffer.put(vertexs);
        vertexBuffer.position(0);
        GLES30.glGenBuffers(1, vbo, 0);
        GLES30.glBindBuffer(GLES30.GL_ARRAY_BUFFER, vbo[0]);
        GLES30.glBufferData(GLES30.GL_ARRAY_BUFFER, vertexs.length * 4, vertexBuffer, GLES30.GL_STATIC_DRAW);
        GLES30.glVertexAttribPointer(0, 2, GLES30.GL_FLOAT, false, 16, 0);
        GLES30.glEnableVertexAttribArray(0);
        GLES30.glVertexAttribPointer(1, 2, GLES30.GL_FLOAT, false, 16, 8);
        GLES30.glEnableVertexAttribArray(1);


        int error = GLES30.glGetError();
        if (error != GLES30.GL_NO_ERROR) {
            Log.d(TAG, error + "");
            return -1;
        }

        GLES30.glBindVertexArray(0);
        return vao[0];
    }

    public static float rnd(final float min, final float max) {
        float fRandNum = (float) Math.random();
        return min + (max - min) * fRandNum;
    }

    private static Resources mRes;

    public static void setUpRes(Resources res) {
        mRes = res;
    }

    public static String file2Glsl(String path) {
        assert (mRes != null);
        StringBuilder result = new StringBuilder();
        try {
            InputStream is = mRes.getAssets().open(path);
            int ch;
            byte[] buffer = new byte[1024];
            while (-1 != (ch = is.read(buffer))) {
                result.append(new String(buffer, 0, ch));
            }
        } catch (Exception e) {
            return null;
        }
        return result.toString().replaceAll("\\r\\n", "\n");
    }

    public static void texImage2D(String path) {
        try {
            GLUtils.texImage2D(GLES30.GL_TEXTURE_2D, 0, BitmapFactory.decodeStream(mRes.getAssets().open(path)), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static float[] vertexRotate(float[] fArr, int rotateDegrees, int curRotation) {
        if (rotateDegrees == (curRotation + 90) % 360) {
            return new float[]{fArr[4], fArr[5], fArr[0], fArr[1], fArr[6], fArr[7], fArr[2], fArr[3]};
        } else if (rotateDegrees == (curRotation + 180) % 360) {
            return new float[]{fArr[6], fArr[7], fArr[4], fArr[5], fArr[2], fArr[3], fArr[0], fArr[1]};
        } else if (rotateDegrees == (curRotation + 270) % 360) {
            return new float[]{fArr[2], fArr[3], fArr[6], fArr[7], fArr[0], fArr[1], fArr[4], fArr[5]};
        } else {
            return new float[]{fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]};
        }
    }
}
