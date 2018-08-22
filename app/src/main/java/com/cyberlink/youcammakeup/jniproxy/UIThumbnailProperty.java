package com.cyberlink.youcammakeup.jniproxy;

public class UIThumbnailProperty {
    protected boolean a;
    private long b;

    protected UIThumbnailProperty(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIThumbnailProperty UIThumbnailPropertyVar) {
        return UIThumbnailPropertyVar == null ? 0 : UIThumbnailPropertyVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIImageCodecJNI.delete_UIThumbnailProperty(this.b);
            }
            this.b = 0;
        }
    }

    public UIThumbnailPropertyItemVector b() {
        long UIThumbnailProperty_items_get = UIImageCodecJNI.UIThumbnailProperty_items_get(this.b, this);
        return UIThumbnailProperty_items_get == 0 ? null : new UIThumbnailPropertyItemVector(UIThumbnailProperty_items_get, false);
    }

    public UIThumbnailProperty() {
        this(UIImageCodecJNI.new_UIThumbnailProperty(), true);
    }
}
