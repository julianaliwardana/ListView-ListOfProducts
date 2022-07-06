package com.example.listproduct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listproduct.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.baju,R.drawable.celana_panjang,R.drawable.celana_pendek,R.drawable.jas,R.drawable.jaket1,
                R.drawable.jaket2,R.drawable.kemeja,R.drawable.polo,R.drawable.polo};

        String[] productName = {"Baju","Celana Panjang","Celama Pendek","Jas","Jaket Keren",
                "Jaket Old","Kemeja Nikahan","Polo Shirt A","Polo Shirt B"};

        String[] stock = {"70","100","20","25","45","55","125","15","90"};

        String[] price = {"70000","100000","20000","25000","45000","55000","125000","15000","90000"};

        ArrayList<Product> productArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){
            Product product = new Product(productName[i],stock[i],price[i],imageId[i]);
            productArrayList.add(product);
        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,productArrayList);

        binding.productList.setAdapter(listAdapter);
        binding.productList.setClickable(true);
        binding.productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this,ProductActivity.class);
                i.putExtra("productName",productName[position]);
                i.putExtra("stock",stock[position]);
                i.putExtra("price",price[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);
            }
        });
    }
}