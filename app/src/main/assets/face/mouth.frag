precision mediump float;
varying vec2 textureCoordinate;
varying vec2 lipstick_texture_coordinate;
uniform sampler2D inputImageTexture;
uniform sampler2D lipstick_texture;
uniform sampler2D reflection_texture;
uniform sampler2D blend_weight_texture;
uniform sampler2D level_map_texture;
uniform vec3 lipstick_color;
uniform float gloss_contrast_scale;
uniform float gloss_contrast_shift;
uniform float force_bright_threshold;
float HardLight(float color, float layer){
    if (color < 0.5){
        color = 2.0 * layer * color;
    }else{
        color = 1.0 - 2.0 * (1.0 - layer) * (1.0 - color);
    }
    return color;
}
void main(){
    vec3 source = texture2D(inputImageTexture, textureCoordinate).rgb;
    if (any(greaterThan(abs(lipstick_texture_coordinate - vec2(0.5)), vec2(0.5)))){
        gl_FragColor = vec4(source, 1.0);
    }else{
        float alpha = texture2D(lipstick_texture, lipstick_texture_coordinate).r;
        float gloss = max(texture2D(reflection_texture, lipstick_texture_coordinate).r - 0.5, 0.0) * 2.0;
        float gray = 0.299 * source.r + 0.587 * source.g + 0.114 * source.b;
        float contrast_mask = min(texture2D(reflection_texture, lipstick_texture_coordinate).r, 0.5) * 2.0 * alpha;
        float contrast = ((gray * gloss_contrast_scale + gloss_contrast_shift) * contrast_mask + 0.5 * (1.0 - contrast_mask));
        float blend_weight = texture2D(blend_weight_texture, vec2(gray, 0)).r;
        float level_weight = texture2D(level_map_texture, vec2(gray, 0)).r * alpha;
        vec3 color = mix(lipstick_color * source, lipstick_color , blend_weight);
        vec3 dst_color = mix(source, color, level_weight);
        float diff = max(gray - force_bright_threshold, 0.0) * alpha;
        dst_color = vec3(1.0) - (vec3(1.0) - dst_color) * vec3(1.0 - diff);
        dst_color.r = HardLight(dst_color.r, contrast);
        dst_color.g = HardLight(dst_color.g, contrast);
        dst_color.b = HardLight(dst_color.b, contrast);
        dst_color = vec3(1.0) - (vec3(1.0) - dst_color) * vec3(1.0 - gloss);
        gl_FragColor = vec4(dst_color, 1.0);
    }
}

