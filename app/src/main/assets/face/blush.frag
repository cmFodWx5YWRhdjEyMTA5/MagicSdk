precision mediump float;
uniform sampler2D inputImageTexture;
uniform sampler2D left_blush_texture;
uniform sampler2D right_blush_texture;
varying vec2 textureCoordinate;
varying vec2 NoRotateCoordinate;
varying vec2 LeftBlushNoRotateCoordinate;
varying vec2 RightBlushNoRotateCoordinate;
uniform float blush_strength;
uniform vec3 blush_color;
uniform float Mid_X_of_left_right;
void main(){
    float alpha_left = texture2D(left_blush_texture, LeftBlushNoRotateCoordinate).a;
    float alpha_right = texture2D(right_blush_texture, RightBlushNoRotateCoordinate).a;
    float alpha = blush_strength * mix(alpha_left, alpha_right, step(Mid_X_of_left_right, NoRotateCoordinate.x));
    vec3 color = mix(texture2D(inputImageTexture, textureCoordinate).rgb, blush_color, alpha);
    gl_FragColor = vec4(color, 1.0);
}