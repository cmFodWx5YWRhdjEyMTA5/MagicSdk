
#ifdef GL_FRAGMENT_PRECISION_HIGH
precision highp float;
#else
precision mediump float;
#endif
varying vec2 textureCoordinate;varying vec2 level_oriented_coordinate;uniform sampler2D inputImageTexture;uniform sampler2D eyeshadow_texture;uniform sampler2D eyeliner_texture;uniform sampler2D eyelash_texture;uniform float frame_to_template_y_remapping_factor;uniform lowp float target_eye_lower_lid_luma;uniform vec2 oriented_upper_lid_center;uniform vec2 oriented_lower_lid_center;uniform vec2 similarity_origin;uniform vec2 similarity_shift;uniform float similarity_scale;uniform vec4 top_spline_transform_src_dst_center;uniform vec4 top_left_spline_transform_src_dst_aligned_parabolic_coeff;uniform vec4 top_right_spline_transform_src_dst_aligned_parabolic_coeff;uniform vec4 bottom_spline_transform_src_dst_center;uniform vec4 bottom_left_spline_transform_src_dst_aligned_parabolic_coeff;uniform vec4 bottom_right_spline_transform_src_dst_aligned_parabolic_coeff;uniform lowp vec3 eyeliner_template_color;uniform lowp vec3 eyelash_template_color;const lowp vec3 rgb_to_y = vec3(0.299, 0.587, 0.114);const lowp float flt_epsilon = 0.001;uniform lowp int enable_eyeshadow;uniform lowp int enable_eyeliner;uniform lowp int enable_eyelash;uniform vec4 roi;uniform lowp vec2 environment_luma;uniform lowp float eyeshadow_multiply_correction;uniform float upper_lid_eyelash_y_scale_adjuster;uniform lowp float shimmer_model_scale;uniform lowp float environment_brightest;uniform lowp float environment_compress;uniform sampler2D bright0_texture;uniform sampler2D glitter0_texture;uniform sampler2D bright1_texture;uniform sampler2D glitter1_texture;float FindRadiusFromAlignedParabolic(vec2 aligned_parabolic_coeff, vec2 cosine_sine){float curve_radius = 0.0;vec3 solve_radius_coeff = vec3(aligned_parabolic_coeff.x * cosine_sine.x * cosine_sine.x, -1.0 * cosine_sine.y, aligned_parabolic_coeff.y);
#ifdef GL_FRAGMENT_PRECISION_HIGH
if (abs(solve_radius_coeff.x) < 0.01)
#else
if (abs(solve_radius_coeff.x) < 0.1)
#endif
{curve_radius = -1.0 * solve_radius_coeff.z / solve_radius_coeff.y;}else{float solve_radius_delta = sqrt(max(0.0, solve_radius_coeff.y * solve_radius_coeff.y - solve_radius_coeff.x * solve_radius_coeff.z * 4.0));curve_radius = (-1.0 * solve_radius_coeff.y + sign(solve_radius_coeff.x) * solve_radius_delta) / (2.0 * solve_radius_coeff.x);}return curve_radius;}vec4 ParabolicPolarTransform(vec2 level_oriented_src, vec2 spline_transform_src_center, vec2 spline_transform_dst_center, vec2 spline_transform_src_aligned_parabolic_coeff, vec2 spline_transform_dst_aligned_parabolic_coeff, float similarity_scale, float top_bottom_lid_selector){vec2 shift_point = level_oriented_src - spline_transform_src_center;float radius = length(shift_point);vec2 cosine_sine = shift_point / radius;float src_curve_radius = FindRadiusFromAlignedParabolic(spline_transform_src_aligned_parabolic_coeff, cosine_sine);float dst_curve_radius = FindRadiusFromAlignedParabolic(spline_transform_dst_aligned_parabolic_coeff, cosine_sine);float dst_radius = dst_curve_radius + (radius - src_curve_radius) * similarity_scale;vec2 dst_aligned_position = dst_radius * cosine_sine;vec2 dst_position = dst_aligned_position + spline_transform_dst_center;float away_boundary = min(1.0, (dst_curve_radius - dst_radius) / spline_transform_dst_aligned_parabolic_coeff.y);float dst_y_position_for_eyeslash = spline_transform_dst_center.y+ dst_aligned_position.y+ (1.0 - upper_lid_eyelash_y_scale_adjuster) * mix(1.0, 0.7, away_boundary)* (dst_aligned_position.y - (spline_transform_dst_aligned_parabolic_coeff.x * dst_aligned_position.x * dst_aligned_position.x + spline_transform_dst_aligned_parabolic_coeff.y));dst_y_position_for_eyeslash = mix(dst_y_position_for_eyeslash, dst_position.y, top_bottom_lid_selector);return vec4(dst_position, (radius / src_curve_radius) - 1.0, dst_y_position_for_eyeslash);}vec3 RGBtoHCV(vec3 rgb){vec4 p = (rgb.g < rgb.b) ? vec4(rgb.bg, -1.0, 0.66666667) : vec4(rgb.gb, 0.0, -0.33333333);vec4 q = (rgb.r < p.x) ? vec4(p.xyw, rgb.r) : vec4(rgb.r, p.yzx);float c = q.x - min(q.w, q.y);float h = abs((q.w - q.y) / (6.0 * c + flt_epsilon) + q.z);return vec3(h, c, q.x);}vec3 RGBtoHSL(vec3 rgb){vec3 hcv = RGBtoHCV(rgb);float l = hcv.z - hcv.y * 0.5;float s = hcv.y / (1.0 - abs(l * 2.0 - 1.0) + flt_epsilon);return vec3(hcv.x, s, l);}vec3 HSLtoRGB(vec3 hsl){vec3 rgb;float x = hsl.x * 6.0;rgb.r = abs(x - 3.0) - 1.0;rgb.g = 2.0 - abs(x - 2.0);rgb.b = 2.0 - abs(x - 4.0);rgb = clamp(rgb, 0.0, 1.0);float c = (1.0 - abs(2.0 * hsl.z - 1.0)) * hsl.y;rgb = clamp((rgb - vec3(0.5)) * vec3(c) + vec3(hsl.z), 0.0, 1.0);return rgb;}float RGBtoL(vec3 rgb){float max_rgb = max(max(rgb.r, rgb.g), rgb.b);float min_rgb = min(min(rgb.r, rgb.g), rgb.b);return (max_rgb + min_rgb) * 0.5;}vec2 RGBtoSL(vec3 rgb){float max_rgb = max(max(rgb.r, rgb.g), rgb.b);float min_rgb = min(min(rgb.r, rgb.g), rgb.b);vec2 sl = vec2((max_rgb - min_rgb) / (max(flt_epsilon, 1.0 - abs(max_rgb + min_rgb - 1.0))),(max_rgb + min_rgb) * 0.5);return sl;}float random(vec2 n, float d){return d * 0.5 * fract(sin(dot(n.xy, vec2(12.9898, 78.233)))* 43758.5453);}void main(){lowp vec4 source = texture2D(inputImageTexture, textureCoordinate);if ((enable_eyeshadow < 1 && enable_eyeliner < 1 && enable_eyelash < 1) || any(lessThan(level_oriented_coordinate, roi.sp)) || any(greaterThan(level_oriented_coordinate, roi.tq))){gl_FragColor = source;return;}else{float top_lid_left_right_part_selector= step(oriented_upper_lid_center.x, level_oriented_coordinate.x);vec4 top_lid_spline_transform_aligned_parabolic_coeff = mix(top_left_spline_transform_src_dst_aligned_parabolic_coeff, top_right_spline_transform_src_dst_aligned_parabolic_coeff, top_lid_left_right_part_selector);float bottom_lid_left_right_part_selector = step(oriented_lower_lid_center.x, level_oriented_coordinate.x);vec4 bottom_lid_spline_transform_aligned_parabolic_coeff = mix(bottom_left_spline_transform_src_dst_aligned_parabolic_coeff, bottom_right_spline_transform_src_dst_aligned_parabolic_coeff, bottom_lid_left_right_part_selector);float top_bottom_lid_selector = step(similarity_origin.y, level_oriented_coordinate.y);vec4 spline_transform_center = mix(top_spline_transform_src_dst_center, bottom_spline_transform_src_dst_center, top_bottom_lid_selector);vec4 spline_transform_aligned_parabolic_coeff = mix(top_lid_spline_transform_aligned_parabolic_coeff, bottom_lid_spline_transform_aligned_parabolic_coeff, top_bottom_lid_selector);vec4 mapping_to_template_by_parabolic_polar_transform = ParabolicPolarTransform(level_oriented_coordinate, spline_transform_center.xy, spline_transform_center.zw, spline_transform_aligned_parabolic_coeff.xy, spline_transform_aligned_parabolic_coeff.zw, similarity_scale, top_bottom_lid_selector);vec2 mapping_to_template_by_similarity = (level_oriented_coordinate - similarity_origin) * similarity_scale + similarity_origin + similarity_shift; vec2 mapping_for_eyeshadow = mix(mapping_to_template_by_similarity, mapping_to_template_by_parabolic_polar_transform.xy, top_bottom_lid_selector);mapping_for_eyeshadow.y *= frame_to_template_y_remapping_factor;lowp vec4 eyeshadow = texture2D(eyeshadow_texture, mapping_for_eyeshadow);vec2 mapping_for_eyeliner = mapping_to_template_by_parabolic_polar_transform.xy;mapping_for_eyeliner.y *= frame_to_template_y_remapping_factor;lowp float eyeliner_alpha = texture2D(eyeliner_texture, mapping_for_eyeliner).a;vec2 mapping_for_eyelash = mapping_to_template_by_parabolic_polar_transform.xw;mapping_for_eyelash.y *= frame_to_template_y_remapping_factor;lowp float eyelash_alpha = texture2D(eyelash_texture, mapping_for_eyelash).a;lowp float eyeshadow_feather = mix(0.5, 1.0, smoothstep(0.0, 0.125, mapping_to_template_by_parabolic_polar_transform.z));lowp float outside_eye = step(0.0, mapping_to_template_by_parabolic_polar_transform.z) * eyeshadow_feather * float(enable_eyeshadow);eyeshadow *= outside_eye;eyeliner_alpha *= float(enable_eyeliner);eyelash_alpha *= float(enable_eyelash);lowp vec3 color = source.rgb;lowp float src_y = dot(color, rgb_to_y);lowp float multiply_weight = abs(src_y - target_eye_lower_lid_luma) / max(target_eye_lower_lid_luma, 1.0 - target_eye_lower_lid_luma);lowp vec3 eyeshadow_template_color_adjusted = environment_luma.y * eyeshadow.rgb + environment_luma.x * (vec3(eyeshadow.a) - eyeshadow.rgb);color = color * (1.0 - eyeshadow.a) + mix(eyeshadow_template_color_adjusted, color * eyeshadow_template_color_adjusted, clamp(multiply_weight * eyeshadow_multiply_correction, 0.0, 1.0));float glitter_alpha = mix(texture2D(glitter1_texture, mapping_for_eyeshadow).a,texture2D(glitter0_texture, mapping_for_eyeshadow).a,shimmer_model_scale);float bright_alpha = mix(texture2D(bright1_texture, mapping_for_eyeshadow).a,texture2D(bright0_texture, mapping_for_eyeshadow).a,shimmer_model_scale);glitter_alpha *= outside_eye;bright_alpha *= outside_eye;const float shimmer_intensity = 100.0 / 28.0;if (glitter_alpha > 0.0 || bright_alpha > 0.0){float normal_l = RGBtoL(source.rgb) / target_eye_lower_lid_luma;vec3 curr_hsl = RGBtoHSL(color);normal_l *= (1.0 - curr_hsl.z);vec2 eyeshadow_sl = RGBtoSL(eyeshadow.rgb);float difference = normal_l * (glitter_alpha + bright_alpha * bright_alpha * bright_alpha * shimmer_intensity);difference *= environment_compress;difference += random(mapping_for_eyeshadow, difference);curr_hsl.z = max(min(curr_hsl.z + difference, environment_brightest), curr_hsl.z);float s_weight = min(1.0, difference * 5.0 * (1.0 - eyeshadow_sl.y));curr_hsl.y = curr_hsl.y - s_weight * max(0.0, (curr_hsl.y - eyeshadow_sl.x));color = HSLtoRGB(curr_hsl);}lowp vec3 eyeliner_multiply = color * eyeliner_template_color;lowp vec3 eyeliner_color = mix(eyeliner_template_color, eyeliner_multiply, multiply_weight);color = mix(color, eyeliner_color, eyeliner_alpha);color = mix(color, eyelash_template_color, eyelash_alpha);gl_FragColor = vec4(color, 1.0);}}