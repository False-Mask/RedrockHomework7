package com.example.level2;

public class data {
    String title;
    String link;
    String shareUsers;

    public void setLink(String link) {
        this.link = link;
    }

    public void setShareUsers(String shareUsers) {
        this.shareUsers = shareUsers;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public String getShareUsers() {
        return shareUsers;
    }

    public String getTitle() {
        return title;
    }public data(String title,String shareUsers,String link){
        this.link=link;
        this.title=title;
        this.shareUsers=shareUsers;
    }
}
