attribute vec4 position;
attribute vec4 inputTextureCoordinate;
attribute vec4 input_lipstick_texture_coordinate;
varying vec2 textureCoordinate;
varying vec2 lipstick_texture_coordinate;
uniform float center_x;
uniform float center_y;
uniform float background_image_width;
uniform float background_image_height;
uniform float lipstick_width;
uniform float lipstick_height;
void main(){
    gl_Position = position;
    textureCoordinate = inputTextureCoordinate.xy;
    lipstick_texture_coordinate.x = (input_lipstick_texture_coordinate.x - center_x) * background_image_width / lipstick_width + 0.5;
    lipstick_texture_coordinate.y = (input_lipstick_texture_coordinate.y - center_y) * background_image_height / lipstick_height + 0.5;
}