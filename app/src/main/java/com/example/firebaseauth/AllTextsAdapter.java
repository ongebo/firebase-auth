package com.example.firebaseauth;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AllTextsAdapter extends RecyclerView.Adapter<AllTextsAdapter.ViewHolder> {
    private List<Text> pairedDevices;

    public AllTextsAdapter(List<Text> savedTexts) {
        this.pairedDevices = savedTexts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.saved_text_details, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TextView textTitle = viewHolder.view.findViewById(R.id.savedTextTitle);
        TextView textDescription = viewHolder.view.findViewById(R.id.savedTextDescription);
        textTitle.setText(pairedDevices.get(i).getTitle());
        textDescription.setText(pairedDevices.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return pairedDevices.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;

        ViewHolder(View view) {
            super(view);
            this.view = view;
        }
    }
}
