package Autotest.POJOclasses;

public class AnimeImage {
    public String original;
    public String preview;
    public String x96;
    public String x48;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getX96() {
        return x96;
    }

    public void setX96(String x96) {
        this.x96 = x96;
    }

    public String getX48() {
        return x48;
    }

    public void setX48(String x48) {
        this.x48 = x48;
    }

    public AnimeImage(String original, String preview, String x96, String x48) {
        this.original = original;
        this.preview = preview;
        this.x96 = x96;
        this.x48 = x48;
    }

    public AnimeImage() {
    }
}
