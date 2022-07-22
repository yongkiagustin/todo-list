package id.ysoftware.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParamRegisterUser {


    @Expose
    @SerializedName("username")
    public String username;
    @Expose
    @SerializedName("password")
    public String password;
    @Expose
    @SerializedName("email")
    public String email;
}
