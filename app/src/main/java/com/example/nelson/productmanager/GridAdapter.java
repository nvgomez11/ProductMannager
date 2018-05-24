package com.example.nelson.productmanager;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by Nelson on 14/4/2018.
 */

public class GridAdapter extends BaseAdapter {

    //private ArrayList<String> icons;
    private ArrayList<String> title;
    private ArrayList<String> description;
    private Context context;
    private LayoutInflater inflater;


    public GridAdapter(Context context, ArrayList<String> title, ArrayList<String> description){
        this.context = context;
        this.description = description;
        this.title = title;
        //this.icons = icons;
    }
    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public Object getItem(int i) {
        return title.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = convertView;
        if(convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.content_products_inflator,null);
        }
        TextView grid_titles = (TextView) gridView.findViewById(R.id.text_view_titulo);
        TextView grid_description = (TextView) gridView.findViewById(R.id.text_view_descripcion);
        //ImageView image = gridView.findViewById(R.id.icons_img);

        //icon.setImageResource(icons[position]);
        grid_titles.setText(title.get(position).toString());
        grid_description.setText(description.get(position).toString());
        //String url = String.valueOf(icons.get(position).toString());
        //Picasso.get().load(url).into(image);

        return gridView;
    }
}
