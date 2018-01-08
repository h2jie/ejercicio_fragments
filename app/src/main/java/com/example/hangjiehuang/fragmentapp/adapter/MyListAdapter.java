package com.example.hangjiehuang.fragmentapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hangjiehuang.fragmentapp.R;
import com.example.hangjiehuang.fragmentapp.model.ItemModel;

import java.util.List;

/**
 * Created by HangjieHuang on 2017/12/13.
 */

public class MyListAdapter extends BaseAdapter {
    private Activity activity;
    private List<ItemModel> data;
    private LayoutInflater inflater;
    private int item_layout;

    public MyListAdapter(Activity activity, List<ItemModel> data, int item_layout) {
        this.activity = activity;
        this.data = data;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.item_layout = item_layout;
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int i) {
        return this.data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view= this.inflater.inflate(item_layout, null,true);
        }
        TextView itemName = view.findViewById(R.id.name);
        ImageView itemImage = view.findViewById(R.id.imagen);
        TextView itemStock = view.findViewById(R.id.stock);


        itemName.setText(data.get(i).getName());
        itemImage.setImageResource(data.get(i).getImagen());
        itemStock.setText(String.valueOf(data.get(i).getStock()));


        return view;
    }
}
