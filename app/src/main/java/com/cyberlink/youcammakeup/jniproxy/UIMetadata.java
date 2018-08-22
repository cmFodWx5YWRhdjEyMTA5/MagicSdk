package com.cyberlink.youcammakeup.jniproxy;

public class UIMetadata {
    protected boolean a;
    private long b;

    protected UIMetadata(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIMetadata UIMetadataVar) {
        return UIMetadataVar == null ? 0 : UIMetadataVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIImageCodecJNI.delete_UIMetadata(this.b);
            }
            this.b = 0;
        }
    }

    public UIFileInfo b() {
        long UIMetadata_fileInfo_get = UIImageCodecJNI.UIMetadata_fileInfo_get(this.b, this);
        return UIMetadata_fileInfo_get == 0 ? null : new UIFileInfo(UIMetadata_fileInfo_get, false);
    }

    public UIExifInfo c() {
        long UIMetadata_exifInfo_get = UIImageCodecJNI.UIMetadata_exifInfo_get(this.b, this);
        return UIMetadata_exifInfo_get == 0 ? null : new UIExifInfo(UIMetadata_exifInfo_get, false);
    }

    public UIMetadata() {
        this(UIImageCodecJNI.new_UIMetadata(), true);
    }
}
