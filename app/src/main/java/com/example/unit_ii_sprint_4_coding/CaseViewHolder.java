package com.example.unit_ii_sprint_4_coding;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CaseViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvDate;
    private TextView mTvPositive;
    private TextView mTvNegative;
    private TextView mTvHospitalizedCurrently;
    private TextView mTvOnVentilatorCurrently;
    private TextView mTvDeath;
    private TextView mTvDateChecked;

    public CaseViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvDate = itemView.findViewById(R.id.tvDate);
        mTvPositive = itemView.findViewById(R.id.tvPositive);
        mTvNegative = itemView.findViewById(R.id.tvNegative);
        mTvHospitalizedCurrently = itemView.findViewById(R.id.tvHospitalizedCurrently);
        mTvOnVentilatorCurrently = itemView.findViewById(R.id.tvOnVentilatorCurrently);
        mTvDeath = itemView.findViewById(R.id.tvDeath);
        mTvDateChecked = itemView.findViewById(R.id.tvDateChecked);
    }

    public void setData(ResponseModel responseModel) {
        mTvDate.setText(responseModel.getDate());
        mTvPositive.setText(responseModel.getPositive());
        mTvNegative.setText(responseModel.getNegative());
        mTvHospitalizedCurrently.setText(responseModel.getHospitalizedCurrently());
        mTvOnVentilatorCurrently.setText(responseModel.getOnVentilatorCurrently());
        mTvDeath.setText(responseModel.getDeath());
        mTvDateChecked.setText(responseModel.getDateChecked());
    }
}