package org.dalol.restapidemo.model.api;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Sanjeev on 23-05-2016.
 */
public interface AboutApi {
    @GET("/u/746330/facts.json")
    void getAboutData(Callback<String> aboutData);
}
