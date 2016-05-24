package org.dalol.restapidemo.model.api;

import com.google.gson.GsonBuilder;
import org.dalol.restapidemo.model.utilities.Constants;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Sanjeev on 23-05-2016.
 */
public class RestApiManager {
    private AboutApi mAboutApi;

    public AboutApi getAboutApi() {
        if (mAboutApi == null) {
            GsonBuilder gson = new GsonBuilder();
            gson.registerTypeAdapter(String.class, new StringDesirializer());
            mAboutApi = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setConverter(new GsonConverter(gson.create()))
                    .build()
                    .create(AboutApi.class);
        }
        return mAboutApi;
    }
}