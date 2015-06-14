package com.whatdo.whatdoco.whatdo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by admin on 15-06-14.
 */
public class GetQuestionsBatch extends AsyncTask<String, Void, ArrayList<String>> {

    public ArrayList<String> result;
    public String user_id;
    private Context parent;
    public String get_url = "https://whatdoapi.appspot.com/_ah/api/questions/v1/get_batch?user_id=";

    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    @InjectView(R.id.frame)
    SwipeFlingAdapterView flingContainer;


    public GetQuestionsBatch(String _user_id, Context _context, SwipeFlingAdapterView f)
    {
        user_id = _user_id;
        //get the parent context
        parent = _context;
        flingContainer =f;

    }

    @Override
    protected ArrayList<String> doInBackground(String... url) {
        String json = null;
        JSONArray res = new JSONArray();
        ArrayList<String> result = new ArrayList<>(0);
        try {
            String questions = get_url + user_id;
            HttpClient client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(questions);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            json = client.execute(httpget, responseHandler);
            Log.i("JSON", json);
            try {
                JSONObject jObject = new JSONObject(json);
                res = jObject.getJSONArray("questions");
                for(int i = 0; i < res.length(); i++)
                {
                    res.getJSONObject(i);
                }
                Log.i("questions", res.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < res.length(); i++)
        {
            try{
                result.add(res.getJSONObject(i).getString("title"));
                Log.i("question", result.get(i));
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    protected void onPostExecute(ArrayList<String> response) {
        result = response;

        arrayAdapter = new ArrayAdapter<>(parent, R.layout.item, R.id.helloText, al );


        flingContainer.setAdapter(arrayAdapter);

    }


}