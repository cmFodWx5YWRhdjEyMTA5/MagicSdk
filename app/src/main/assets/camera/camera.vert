attribute vec4 position;
attribute vec2 inputTextureCoordinate;
varying vec2 textureCoordinate;
uniform mat4 transformMatrix;
void main()
{
    gl_Position =  position;
    textureCoordinate = (transformMatrix * vec4(inputTextureCoordinate.xy, 0.0, 1.0)).xy;
}
