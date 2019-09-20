package com.andresual.dicodingsubmission3.model;

import org.json.JSONObject;

public class ReturnModel {

    private String success;
    private JSONObject obj;

    public ReturnModel(String success, JSONObject obj) {
        this.success = success;
        this.obj = obj;
    }

    public JSONObject getObj() {
        return obj;
    }

    public void setObj(JSONObject obj) {
        this.obj = obj;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

}
