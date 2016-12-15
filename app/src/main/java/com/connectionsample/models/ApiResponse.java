package com.connectionsample.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chiu on 2016/12/15.
 */

public class ApiResponse {
    @SerializedName("result")
    private final Result result;

    public ApiResponse(Result result) {this.result = result;}

    public Result getResult() {
        return result;
    }

}
