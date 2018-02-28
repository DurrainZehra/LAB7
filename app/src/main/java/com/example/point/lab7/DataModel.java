package com.example.point.lab7;

/**
 * Created by POINT on 2/27/2018.
 */

public class DataModel {
    private String Username;
    private String Useremail;
    private String Usermobile;
    DataModel(String Username, String Useremail, String Usermobile) {
        this.Username= Username;
        this.Useremail= Useremail;
        this.Usermobile= Usermobile;

    }
    public String getUsername(){
        return Username;
    }
    public String getUseremail(){
        return Useremail;
    }
    public String getUsermobile(){
        return Usermobile;
    }
}

