package com.rubeniel.rona.network;

import com.rubeniel.rona.models.Constants;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlagClient {

    public static Retrofit retrofit = null;

    public static synchronized FlagApi getFlagClient() {

        if ( retrofit == null ){

            Interceptor interceptor = new Interceptor() {
                @NotNull
                @Override
                public Response intercept(@NotNull Chain chain) throws IOException {
                    Request request = chain.request().newBuilder().build();
                    return chain.proceed(request);
                }
            };

            OkHttpClient.Builder okhttpClient = new OkHttpClient.Builder().addInterceptor(interceptor);

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.FLAG_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okhttpClient.build())
                    .build();

        }

        return retrofit.create(FlagApi.class);

    }

}
