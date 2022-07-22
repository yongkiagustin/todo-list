package id.ysoftware.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public abstract class ChecklistResultModel {

    @Expose
    @SerializedName("data")
    public List<String> data;
    @Expose
    @SerializedName("message")
    public String message;
    @Expose
    @SerializedName("statusCode")
    public int statuscode;
}
