package id.ysoftware.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataLogin {
    @Expose
    @SerializedName("token")
    public String token;
}
