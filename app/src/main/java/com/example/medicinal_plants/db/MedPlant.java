package com.example.medicinal_plants.db;

import android.view.LayoutInflater;

public class MedPlant {
    private String name;
    private String desc;
    private String ill;

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
}
