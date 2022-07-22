package id.ysoftware.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataChecklistModel {
    @Expose
    @SerializedName("checklistCompletionStatus")
    public boolean checklistcompletionstatus;
    @Expose
    @SerializedName("name")
    public String name;
    @Expose
    @SerializedName("id")
    public int id;
}
