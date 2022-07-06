package com.example.listproduct;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listproduct.databinding.ActivityProductBinding;

public class ProductActivity extends AppCompatActivity {

    ActivityProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null){

            String productName = intent.getStringExtra("productName");
            String stock = intent.getStringExtra("stock");
            String price = intent.getStringExtra("price");
            int imageid = intent.getIntExtra("imageid",R.drawable.baju);

            binding.productName.setText(productName);
            binding.stock.setText(stock);
            binding.price.setText(price);
            binding.imagePic.setImageResource(imageid);
        }
    }
}
