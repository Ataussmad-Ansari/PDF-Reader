package com.example.pdfreader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class PdfActivity extends AppCompatActivity {

    String filePath = "";
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        pdfView = findViewById(R.id.pdfView);
        filePath = getIntent().getStringExtra("path");
        File file = new File(filePath);
        Uri uri = Uri.fromFile(file);
        pdfView.fromUri(uri).load();

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}