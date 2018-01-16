package com.hazal.hazalscats;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatsApi {

    @GET("58fcfef20f00004c21513695")
    Call<List<Cat>> getCats();


}
