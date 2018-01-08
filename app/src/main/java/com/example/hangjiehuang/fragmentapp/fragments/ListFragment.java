package com.example.hangjiehuang.fragmentapp.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hangjiehuang.fragmentapp.R;
import com.example.hangjiehuang.fragmentapp.adapter.MyListAdapter;
import com.example.hangjiehuang.fragmentapp.interfaces.OnItemSelectionChangeListener;
import com.example.hangjiehuang.fragmentapp.model.ItemModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private List<ItemModel> data;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);


    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        createDataModel();

        ListView listView = this.getActivity().findViewById(R.id.listView);
        MyListAdapter adapter = new MyListAdapter(this.getActivity(), data, R.layout.list_item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }



    private void createDataModel(){
        data = new ArrayList<ItemModel>();
        String[] names = this.getResources().getStringArray(R.array.nombres_productos);
        int[] stocks = this.getResources().getIntArray(R.array.stocks_productos);

        ItemModel item;
        for (int i = 0; i < names.length; i++) {
            item = new ItemModel(names[i],
                    this.getResources().getIdentifier(getResources().getString(R.string.img_name,names[i].toLowerCase()),getResources().getString(R.string.drawable),this.getActivity().getPackageName()),
                    stocks[i]
                    );
            data.add(item);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        OnItemSelectionChangeListener listener = (OnItemSelectionChangeListener) getActivity();
        listener.OnSelectionChanged(i);
    }
}
