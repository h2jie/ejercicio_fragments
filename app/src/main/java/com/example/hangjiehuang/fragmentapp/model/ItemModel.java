package com.example.hangjiehuang.fragmentapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by HangjieHuang on 2017/12/13.
 */

public class ItemModel implements Parcelable {
    private int imagen;
    private String name;
    private int stock;

    public ItemModel(String name, int imagen, int stock) {
        this.name = name;
        this.imagen = imagen;
        this.stock = stock;
    }



    public String getName() {
        return name;
    }

    public int getImagen() {
        return imagen;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.imagen);
        parcel.writeString(this.name);
        parcel.writeInt(this.stock);
    }
    public static final Parcelable.Creator<ItemModel> CREATOR = new Parcelable.Creator<ItemModel>() {
        @Override
        public ItemModel createFromParcel(Parcel source) {
            return new ItemModel(source);
        }

        @Override
        public ItemModel[] newArray(int size) {
            return new ItemModel[size];
        }
    };

    public ItemModel(Parcel source) {
        this.imagen = source.readInt();
        this.name = source.readString();
        this.stock = source.readInt();
    }
}
