package id.ysoftware.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParamLoginUser {

    @Expose
    @SerializedName("password")
    public String password;
    @Expose
    @SerializedName("username")
    public String username;
}
