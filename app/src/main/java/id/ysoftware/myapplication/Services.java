package id.ysoftware.myapplication;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Services {
    @POST("login")
    Call<UserModel> loginUser(
            @Body ParamLoginUser paramLoginUser
    );
    @POST("register")
    Call<RegisterModel> registerUser(
            @Body ParamRegisterUser paramRegisterUser
    );
    @GET("checklist")
    Call<ChecklistModel> checkList(
            @Header("Authorization") String token
    );

    @POST("checklist")
    Call<ParamChecklist> createChecklist(
            @Body ParamChecklist paramChecklist
    );

    static Services initServices(){
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .addInterceptor(logger)
                .build();
        String url = "http://94.74.86.174:8080/api/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Services.class);
    }
}
