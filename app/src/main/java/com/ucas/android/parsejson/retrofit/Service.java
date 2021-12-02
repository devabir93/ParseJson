package com.ucas.android.parsejson.retrofit;

import com.ucas.android.parsejson.model.UserResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface Service {
    @GET("users")
    Call<UserResponse> getUsers();

    class RetrofitClient {
        private static final String BASE_URL = "https://reqres.in/api/";

        public static Service getRetrofitInstance() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(Service.class);
        }
    }

}
