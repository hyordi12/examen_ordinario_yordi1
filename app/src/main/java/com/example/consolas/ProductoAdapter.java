package com.example.consolas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductoAdapter extends ArrayAdapter<Producto> {

    public ProductoAdapter(Context context, List<Producto> productos) {
        super(context, 0, productos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_producto, parent, false);
        }

        Producto producto = getItem(position);

        ImageView imageView = convertView.findViewById(R.id.imageViewProducto);
        TextView textViewNombre = convertView.findViewById(R.id.textViewNombreProducto);
        TextView textViewDescripcion = convertView.findViewById(R.id.textViewDescripcionProducto);


        imageView.setImageResource(producto.getImagenResId());
        textViewNombre.setText(producto.getNombre());
        textViewDescripcion.setText(producto.getDescripcion());

        return convertView;
    }
}

