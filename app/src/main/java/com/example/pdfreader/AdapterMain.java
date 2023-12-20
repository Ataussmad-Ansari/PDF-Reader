package com.example.pdfreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.viewHolder> {

    Context context;
    List<File> pdfFile;
    onPdfSelectListener listener;

    public AdapterMain(Context context, List<File> pdfFile, onPdfSelectListener listener) {
        this.context = context;
        this.pdfFile = pdfFile;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdapterMain.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMain.viewHolder holder, int position) {
        holder.fileN.setText(pdfFile.get(position).getName());
        holder.fileN.setSelected(true);
        holder.itemView.setOnClickListener(v -> {
            listener.onPdfSelected(pdfFile.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return pdfFile.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView fileN;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            fileN = itemView.findViewById(R.id.textView);
        }
    }
}
