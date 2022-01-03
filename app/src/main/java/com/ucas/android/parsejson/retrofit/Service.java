package com.ucas.android.parsejson.retrofit;

import com.ucas.android.parsejson.model.Product;
import com.ucas.android.parsejson.model.RegisterRequestBody;
import com.ucas.android.parsejson.model.RegisterResponse;
import com.ucas.android.parsejson.model.UserResponse;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {
    @GET("users")
    Call<UserResponse> getUsers();

    @GET("products")
    Call<List<Product>> getProducts();

    @GET("products/{xx}")
    Call<Product> getProductDetails(@Path("xx") int xxx);

//    @GET("products")
//    Call<Product> getProductDetails(@Query("product_id") int xxx);
//
    @GET("query")
    Call<EarthQuakResponse> getEarthquake(@Query("format") String format, @Query("starttime") String starttime, @Query("endtime") String endtime);

    @POST("register")
    Call<RegisterResponse> register(@Body RegisterRequestBody user);

    class RetrofitClient {
        //private static final String BASE_URL = "https://reqres.in/api/";
        //private static final String BASE_URL = "https://fakestoreapi.com/";
        private static final String BASE_URL = "https://earthquake.usgs.gov/fdsnws/event/1/";

        public static Service getRetrofitInstance() {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(Service.class);
        }
    }

}
