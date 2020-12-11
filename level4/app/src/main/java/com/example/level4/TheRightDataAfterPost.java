package com.example.level4;

public class TheRightDataAfterPost{
    /*
    {
        "data": {
        "admin": false,
        "chapterTops": [],
        "coinCount": 0,
        "collectIds": [],
        "email": "",
        "icon": "",
        "id": 83000,
        "nickname": "对应的用户名",
        "password": "",
        "publicName": "对应的用户名",
        "token": "",
        "type": 0,
        "username": "对应的用户名"
    },
    */
    boolean admin=false;
    Object chapterTops;
    int coinCount=0;
    Object collectIds;
    String email="";
    String icon="";
    int id=83000;
    String nickname="对应的用户名";
    String password="";
    String publicName="";
    String token="";
    int type=0;
    String username="对应的用户名";

    //构造方法


    public TheRightDataAfterPost(boolean admin, Object chapterTops,
                                 int coinCount, Object collectIds,
                                 String email, String icon, int id,
                                 String nickname, String password,
                                 String publicName, String token,
                                 int type, String username) {
        this.admin = admin;
        this.chapterTops = chapterTops;
        this.coinCount = coinCount;
        this.collectIds = collectIds;
        this.email = email;
        this.icon = icon;
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.publicName = publicName;
        this.token = token;
        this.type = type;
        this.username = username;
    }



    //set set方法
    public boolean isAdmin() {
        return admin;
    }

    public Object getChapterTops() {
        return chapterTops;
    }

    public int getCoinCount() {
        return coinCount;
    }

    public Object getCollectIds() {
        return collectIds;
    }

    public String getEmail() {
        return email;
    }

    public String getIcon() {
        return icon;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getPublicName() {
        return publicName;
    }

    public String getToken() {
        return token;
    }

    public int getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setChapterTops(Object[] chapterTops) {
        this.chapterTops = chapterTops;
    }

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

    public void setCollectIds(Object[] collectIds) {
        this.collectIds = collectIds;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
