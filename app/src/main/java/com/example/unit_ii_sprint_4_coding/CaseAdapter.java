package com.example.unit_ii_sprint_4_coding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CaseAdapter extends RecyclerView.Adapter<CaseViewHolder> {

    private List<ResponseModel> caseModelList;

    public CaseAdapter(List<ResponseModel> caseModelList) {
        this.caseModelList = caseModelList;
    }

    @NonNull
    @Override
    public CaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new CaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CaseViewHolder holder, int position) {
        ResponseModel responseModel = caseModelList.get(position);
        holder.setData(responseModel);
    }

    @Override
    public int getItemCount() {
        return caseModelList.size();
    }
}