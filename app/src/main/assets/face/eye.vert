attribute vec4 position;
attribute vec4 inputTextureCoordinate;
attribute vec4 inputTemplateTextureCoordinate;
varying vec2 textureCoordinate;
uniform float left_right_flip;
uniform vec2 level_orient_cos_sin;
varying vec2 level_oriented_coordinate;
uniform vec2 analyzing_frame_width_height_in_pixel;
void main(){
    gl_Position = position;
    textureCoordinate = inputTextureCoordinate.xy;
    float left_right_flipped_x = mix(inputTemplateTextureCoordinate.x, 1.0 - inputTemplateTextureCoordinate.x, left_right_flip);
    vec2 template_texture_coordinate_in_pixel = vec2(left_right_flipped_x, inputTemplateTextureCoordinate.y) * analyzing_frame_width_height_in_pixel.xy;
    level_oriented_coordinate.x = level_orient_cos_sin.x * template_texture_coordinate_in_pixel.x - level_orient_cos_sin.y * template_texture_coordinate_in_pixel.y;
    level_oriented_coordinate.y = level_orient_cos_sin.y * template_texture_coordinate_in_pixel.x + level_orient_cos_sin.x * template_texture_coordinate_in_pixel.y;
    level_oriented_coordinate.xy /= analyzing_frame_width_height_in_pixel.xy;
}