package eu.grzegorzsovngarde.grzegorzsosnowski.model;

import com.google.gson.annotations.SerializedName;



public class RetroPhoto {


    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("desc")
    private String desc;

    public RetroPhoto(String title, String url, String desc) {

        this.title = title;
        this.url = url;
        this.desc = desc;
    }





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String thumbnailUrl) {
        this.desc = thumbnailUrl;
    }
}
