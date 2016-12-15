package com.connectionsample.models;

import java.util.ArrayList;

/**
 * Created by chiu on 2016/12/15.
 */

public class Result {
    private int offset;
    private int limit;
    private int count;
    private String sort;
    private ArrayList<Station> results;

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getCount() {
        return count;
    }

    public String getSort() {
        return sort;
    }

    public ArrayList<Station> getResults() {
        return results;
    }
}
