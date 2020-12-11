package com.example.level4;

public class Data{
    private String title;
    private String shareUser;
    private String in;


    //构造方法
    public Data(String title,String shareUser, String in){
        this.in=in;
        this.title=title;
        this.shareUser=shareUser;
    }


    //setget方法
    public void setShareUser(String shareUser) {
        this.shareUser = shareUser;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShareUser() {
        return shareUser;
    }

    public String getIn() {
        return in;
    }

    public String getTitle() {
        return title;
    }
}
