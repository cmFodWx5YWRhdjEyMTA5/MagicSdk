#version 300 es
in highp vec2 textureCoordinate;

uniform sampler2D maskTexture;
uniform sampler2D inputImageTexture;

uniform highp float intensity;
out lowp vec4 out_color;
//lookup table 为大小为512*512，个数为8*8的格子表
void main(){
    highp vec4 textureColor = texture(inputImageTexture, textureCoordinate);
    //根据当前颜色的蓝色通道查找所在格子
    highp float blueColor = textureColor.b * 63.0;
    highp vec2 quad1;
    quad1.y = floor(floor(blueColor) / 8.0);
    quad1.x = floor(blueColor) - (quad1.y * 8.0);

    highp vec2 quad2;
    quad2.y = floor(ceil(blueColor) / 8.0);
    quad2.x = ceil(blueColor) - (quad2.y * 8.0);
    highp vec2 texPos1;
    texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);
    texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);
    highp vec2 texPos2;
    texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);
    texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);
    lowp vec4 newColor1 = texture(maskTexture, texPos1);
    lowp vec4 newColor2 = texture(maskTexture, texPos2);
    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));
    out_color = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);
}