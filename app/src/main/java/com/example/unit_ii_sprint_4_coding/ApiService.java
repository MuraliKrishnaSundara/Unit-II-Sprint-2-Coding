package com.example.unit_ii_sprint_4_coding;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/comments")
    Call<List<ResponseModel>> getCases(@Query("date") int date);
}