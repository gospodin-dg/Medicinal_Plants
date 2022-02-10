package com.example.medicinal_plants.db;

import android.view.LayoutInflater;
import android.widget.Adapter;

public class MedPlant {
    private String name;
    private String desc;
    private String ill;
    private String photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIll() {
        return ill;
    }

    public void setIll(String ill) {
        this.ill = ill;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
