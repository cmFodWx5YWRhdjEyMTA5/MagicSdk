attribute vec4 position;
attribute vec4 inputTextureCoordinate;
attribute vec4 inputTemplateTextureCoordinate;
varying vec2 textureCoordinate;
varying vec2 NoRotateCoordinate;
varying vec2 LeftBlushNoRotateCoordinate;
varying vec2 RightBlushNoRotateCoordinate;
uniform vec2 left_blush_roi;
uniform vec2 right_blush_roi;
uniform vec2 left_blush_stretch;
uniform vec2 right_blush_stretch;
uniform vec2 Cos_Sin;
uniform vec2 negSin_Cos;
uniform vec2 RotateCenter;
void main(){
    gl_Position = position;
    textureCoordinate = inputTextureCoordinate.xy;
    vec2 tmp = inputTemplateTextureCoordinate.xy - RotateCenter;
    NoRotateCoordinate = RotateCenter + vec2(tmp.x, tmp.x)*Cos_Sin + vec2(tmp.y, tmp.y)*negSin_Cos;
    LeftBlushNoRotateCoordinate = (NoRotateCoordinate - left_blush_roi)*left_blush_stretch;
    RightBlushNoRotateCoordinate = (NoRotateCoordinate - right_blush_roi)*right_blush_stretch;
    LeftBlushNoRotateCoordinate.y = 1.0 - LeftBlushNoRotateCoordinate.y;
    RightBlushNoRotateCoordinate.y = 1.0 - RightBlushNoRotateCoordinate.y;
}