package com.mostafa_anter.usingvolley;

import com.android.volley.Cache;
import com.android.volley.toolbox.StringRequest;
import com.mostafa_anter.usingvolley.app.AppController;

import java.io.UnsupportedEncodingException;

/**
 * Created by mostafa on 04/02/16.
 */
public class ImportantFunc {
    /*Volley comes with powerful cache mechanism to maintain request cache.
     This saves lot of internet bandwidth and reduces user waiting time.
     Following are few example of using volley cache methods.*/
    public void Loading_request_from_cache(String url){
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(url);
        if(entry != null){
            try {
                String data = new String(entry.data, "UTF-8");
                // handle data, like converting it to xml, json, bitmap etc.,
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else{
        // Cached response doesn't exists. Make network call here
    }

    }

    //Invalidate means we are invalidating the cached data instead of deleting it.
    // Volley will still uses the cached object until the new data received from server.
    public void Invalidate_cache(String url){
        AppController.getInstance().getRequestQueue().getCache().invalidate(url, true);

    }

    //If you want disable the cache for a particular url, you can use setShouldCache() method as below.
    public void Turning_off_cache(){
        // String request
        StringRequest stringReq = new StringRequest(....);

        // disable cache
        stringReq.setShouldCache(false);
    }

    public void Requestprioritization(){
        private Priority priority = Priority.HIGH;

        StringRequest strReq = new StringRequest(Method.GET,
                Const.URL_STRING_REQ, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, response.toString());
                msgResponse.setText(response.toString());
                hideProgressDialog();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hideProgressDialog();
            }
        }) {
            @Override
            public Priority getPriority() {
                return priority;
            }

        };

    }
}
