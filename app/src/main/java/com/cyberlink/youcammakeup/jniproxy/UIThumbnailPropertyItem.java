package com.cyberlink.youcammakeup.jniproxy;

public class UIThumbnailPropertyItem {
    protected boolean a;
    private long b;

    protected UIThumbnailPropertyItem(long j, boolean z) {
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
                UIImageCodecJNI.delete_UIThumbnailPropertyItem(this.b);
            }
            this.b = 0;
        }
    }

    public UIThumbnailType b() {
        return UIThumbnailType.a(UIImageCodecJNI.UIThumbnailPropertyItem_nType_get(this.b, this));
    }

    public long c() {
        return UIImageCodecJNI.UIThumbnailPropertyItem_nWidth_get(this.b, this);
    }

    public long d() {
        return UIImageCodecJNI.UIThumbnailPropertyItem_nHeight_get(this.b, this);
    }

    public UIImageOrientation e() {
        return UIImageOrientation.a(UIImageCodecJNI.UIThumbnailPropertyItem_nOrientation_get(this.b, this));
    }

    public UIThumbnailPropertyItem() {
        this(UIImageCodecJNI.new_UIThumbnailPropertyItem(), true);
    }
}
