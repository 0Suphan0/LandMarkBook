package com.suphan.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;

import com.suphan.landmarkbook.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {


    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        Landmark selectedLandmark= (Landmark) intent.getSerializableExtra("landMark");

        binding.cityText.setText(selectedLandmark.country);
        binding.nameText.setText(selectedLandmark.name);
        binding.imageView.setImageResource(selectedLandmark.image);


    }
}