package com.cyberlink.youcammakeup.jniproxy;

public class UIThumbnailPropertyItemVector {
    protected boolean a;
    private long b;

    protected UIThumbnailPropertyItemVector(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIImageCodecJNI.delete_UIThumbnailPropertyItemVector(this.b);
            }
            this.b = 0;
        }
    }

    public UIThumbnailPropertyItemVector() {
        this(UIImageCodecJNI.new_UIThumbnailPropertyItemVector__SWIG_0(), true);
    }

    public long b() {
        return UIImageCodecJNI.UIThumbnailPropertyItemVector_size(this.b, this);
    }

    public UIThumbnailPropertyItem a(int i) {
        return new UIThumbnailPropertyItem(UIImageCodecJNI.UIThumbnailPropertyItemVector_get(this.b, this, i), false);
    }
}
