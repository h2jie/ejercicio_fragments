package com.example.hangjiehuang.fragmentapp.activities;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.ListFragment;
import android.support.v7.app.AppCompatActivity;

import com.example.hangjiehuang.fragmentapp.R;
import com.example.hangjiehuang.fragmentapp.fragments.DescriptionFragment;
import com.example.hangjiehuang.fragmentapp.interfaces.OnItemSelectionChangeListener;


public class MainActivity extends AppCompatActivity implements OnItemSelectionChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.mainListFragment)!=null){
            if (savedInstanceState != null){
                return;
            }

            ListFragment listFragment = new ListFragment();
            listFragment.setArguments(getIntent().getExtras());

            FragmentManager fragmentManager = this.getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.mainListFragment, new ListFragment());
            fragmentTransaction.commit();
        }


    }

    @Override
    public void OnSelectionChanged(int itemIndex) {

        FragmentManager fragmentManager = getFragmentManager();
        DescriptionFragment descriptionFragment = (DescriptionFragment)fragmentManager.findFragmentById(R.id.mainDescriptionFragmentL);

        if (descriptionFragment != null) {
            //Estamos en una tablet
            descriptionFragment.setItem(itemIndex);

        } else {
            DescriptionFragment newDescriptionFragment = new DescriptionFragment();
            Bundle bundle = new Bundle();

            bundle.putInt(getResources().getString(R.string.key_pos), itemIndex);
            newDescriptionFragment.setArguments(bundle);

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.mainListFragment, newDescriptionFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

    }


}
