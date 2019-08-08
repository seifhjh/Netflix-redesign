package net.seifhadjhassen.netflix.model;

public class CategModel {

    int img;
    String title;

    public CategModel() {
    }

    public CategModel(int img, String title) {
        this.img = img;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
