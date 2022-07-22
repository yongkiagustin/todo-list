package id.ysoftware.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class RegisterModel {

    @Expose
    @SerializedName("message")
    public String message;
    @Expose
    @SerializedName("statusCode")
    public int statusCode;
}
