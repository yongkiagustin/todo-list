package id.ysoftware.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import id.ysoftware.myapplication.databinding.ActivityCheckListBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChecklistActivity extends AppCompatActivity {
    ActivityCheckListBinding binding;
    CheckListAdapter adapter;
    Services services;
    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        services = Services.initServices();
        callData();
        binding.createChecklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDataChecklist();
            }
        });

        adapter = new CheckListAdapter();
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        callData();
    }

    private void callData() {
        token = SharePref.getToken(ChecklistActivity.this);
        Toast.makeText(ChecklistActivity.this, token, Toast.LENGTH_SHORT).show();
        services.checkList("Bearer "+token).enqueue(new Callback<ChecklistModel>() {
            @Override
            public void onResponse(Call<ChecklistModel> call, Response<ChecklistModel> response) {
                adapter.datalist.addAll(response.body().data);
                adapter.notifyDataSetChanged();
                Toast.makeText(ChecklistActivity.this, response.body().message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ChecklistModel> call, Throwable t) {

            }
        });
    }
    private void createDataChecklist() {
        ParamChecklist param = new ParamChecklist();
        param.name = "Checklist1";

        services.createChecklist(param).enqueue(new Callback<ParamChecklist>() {
            @Override
            public void onResponse(Call<ParamChecklist> call, Response<ParamChecklist> response) {
                Toast.makeText(ChecklistActivity.this, response.body().name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ParamChecklist> call, Throwable t) {

            }
        });

    }

}