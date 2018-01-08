package com.example.hangjiehuang.fragmentapp.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hangjiehuang.fragmentapp.R;
import com.example.hangjiehuang.fragmentapp.model.ItemModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionFragment extends Fragment {

    private int currentPosition;
    private List<ItemModel> data;
    private ImageView img;
    private TextView nombre;
    private TextView stock;
    private TextView desc;


    public DescriptionFragment() {
        // Required empty public constructor
    }


    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        createDataModel();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (savedInstanceState != null){
            currentPosition = savedInstanceState.getInt("itemPosition");
        }

        View view = inflater.inflate(R.layout.fragment_description, container, false);

        nombre=view.findViewById(R.id.info_name);
        img=view.findViewById(R.id.info_image);
        stock=view.findViewById(R.id.info_stock);
        desc= view.findViewById(R.id.info_desc);

        return view;
    }

    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            setItem(args.getInt("itemPosition"));
        } else if (currentPosition != -1) {
            setItem(currentPosition);
        }
    }

    public void setItem(int itemIndex) {
        ItemModel item = data.get(itemIndex);

        img.setImageResource(item.getImagen());
        nombre.setText(item.getName());
        stock.setText(String.valueOf(item.getStock()));
        desc.setText(getResources().getString(R.string.descTest, item.getName().toLowerCase()));
        currentPosition = itemIndex;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(getResources().getString(R.string.key_pos), currentPosition);
    }

    private void createDataModel() {
        data = new ArrayList<ItemModel>();
        String[] nombres = this.getResources().getStringArray(R.array.nombres_productos);
        int[] stocks = this.getResources().getIntArray(R.array.stocks_productos);

        ItemModel item;
        for (int i = 0; i < nombres.length; i++) {
            item = new ItemModel(nombres[i],
                    this.getResources().getIdentifier(getResources().getString(R.string.img_name, nombres[i].toLowerCase()), getResources().getString(R.string.drawable), this.getActivity().getPackageName()),
                    stocks[i]
                    );
            data.add(item);
        }
    }
}
