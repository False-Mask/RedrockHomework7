package com.example.level3;

public class Date {
    private String title;
    private String shareUser;
    private String in;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public void setShareUser(String shareUser) {
        this.shareUser = shareUser;
    }

    public String getTitle() {
        return title;
    }

    public String getIn() {
        return in;
    }

    public String getShareUser() {
        return shareUser;
    }
    public Date(String title ,String shareUser,String in){
        this.in=in;
        this.title=title;
        this.shareUser=shareUser;
    }
}
