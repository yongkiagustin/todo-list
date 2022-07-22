package id.ysoftware.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import id.ysoftware.myapplication.databinding.ActivityMainBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Services services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        services = Services.initServices();
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doRequest();
            }
        });
        binding.registerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }

    private String token;

    private void doRequest() {
        ParamLoginUser param = new ParamLoginUser();
        param.username = binding.loginUsername.getText().toString();
        param.password = binding.loginPassword.getText().toString();
        services.loginUser(param).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.body() != null) {
                    token = response.body().dataLogin.token;
                    SharePref.setToken(MainActivity.this,token);
//                    Toast.makeText(MainActivity.this, SharePref.getToken(MainActivity.this) + " = tokennya nya", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, ChecklistActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}