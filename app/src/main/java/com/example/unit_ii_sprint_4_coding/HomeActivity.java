package com.example.unit_ii_sprint_4_coding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private EditText mEtDate;
    private Button mBtnFetch;
    private RecyclerView mRecyclerView;
    private List<ResponseModel> caseModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        Intent intent = getIntent();
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        int date = Integer.parseInt(mEtDate.getText().toString());
        apiService.getCases(date).enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                caseModelList = response.body();
                setRecyclerView();
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView() {
        CaseAdapter caseAdapter = new CaseAdapter(this.caseModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(caseAdapter);
    }

    private void initViews() {
        mEtDate = findViewById(R.id.etDate);
        mBtnFetch = findViewById(R.id.btnFetch);
        mRecyclerView = findViewById(R.id.recyclerView);
        mBtnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }
}