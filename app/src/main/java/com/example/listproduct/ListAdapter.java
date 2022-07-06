package com.example.listproduct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Product> {
    public ListAdapter(Context context, ArrayList<Product> productArrayList){
        super(context, R.layout.activity_product, productArrayList);
    }

    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Product product = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_products,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.imagePic);
        TextView productName = convertView.findViewById(R.id.productName);
        TextView stock = convertView.findViewById(R.id.stock);

        imageView.setImageResource(product.imageId);
        productName.setText(product.productName);
        stock.setText(product.stock);

        return convertView;
    }
}
