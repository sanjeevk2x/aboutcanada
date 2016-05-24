package org.dalol.restapidemo.controller;

import android.util.Log;

import org.dalol.restapidemo.model.api.RestApiManager;
import org.dalol.restapidemo.model.pojo.About;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Sanjeev on 23-05-2016.
 */
public class Controller {
    private static final String TAG = Controller.class.getSimpleName();
    private AboutCallbackListener mListener;
    private RestApiManager mRestApiManager;

    public Controller(AboutCallbackListener listener) {
        mListener = listener;
        mRestApiManager = new RestApiManager();
    }

    public void startFetching() {
        mRestApiManager.getAboutApi().getAboutData(new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    String aboutTitle = jsonObject.getString("title");
                    if (aboutTitle.equalsIgnoreCase("About Canada")) {
                        JSONArray jsonArray = jsonObject.getJSONArray("rows");
                        for(int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String title = object.getString("title");
                            Log.i(TAG, "title :: " + title);
                            String description = object.getString("description");
                            Log.i(TAG, "description :: " + description);
                            String imageHref = object.getString("imageHref");
                            Log.i(TAG, "imageHref :: " + imageHref);

                            About about = new About.Builder()
                                    .setTitle(title)
                                    .setDescription(description)
                                    .setImagePath(imageHref)
                                    .build();
                            mListener.onFetchProgress(about);
                        }
                    }
                } catch (JSONException e) {
                    mListener.onFetchFailed();
                }
                mListener.onFetchComplete();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "Error :: " + error.getMessage());
                mListener.onFetchComplete();
            }
        });
    }


    // About Canada callback listener interface.
    public interface AboutCallbackListener {
        void onFetchStart();

        void onFetchProgress(About about);

        void onFetchProgress(List<About> aboutList);

        void onFetchComplete();

        void onFetchFailed();
    }
}
