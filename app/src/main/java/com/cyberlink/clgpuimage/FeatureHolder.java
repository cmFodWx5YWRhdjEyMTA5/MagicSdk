package com.cyberlink.clgpuimage;

public class FeatureHolder {

    private CLMakeupLiveFilter clMakeupLiveFilter;
    public boolean isHas;
    public boolean[] features;
    public CLMakeupLiveFilter.CaptureFrameType captureFrameType;

    public FeatureHolder(CLMakeupLiveFilter cLMakeupLiveFilter) {
        this.clMakeupLiveFilter = cLMakeupLiveFilter;
        this.features = new boolean[CLMakeupLiveFilter.MakeupLiveFeatures.values().length];
        this.captureFrameType = CLMakeupLiveFilter.CaptureFrameType.NONE;
    }

}
