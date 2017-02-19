package com.example.myfirstapp.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by M.Franco on 2/19/2017.
 */

public class MiembrosResponse {

    @SerializedName("results")
    private Miembro[] results;

    public Miembro[] getResults() {
        return results;
    }

    public void setResults(Miembro[] results) {
        this.results = results;
    }
}
