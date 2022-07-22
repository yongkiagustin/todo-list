package id.ysoftware.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    @Expose
    @SerializedName("data")
    public DataLogin dataLogin;
    @Expose
    @SerializedName("message")
    public String message;
    @Expose
    @SerializedName("statusCode")
    public int statuscode;
}
