package android_class.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by admin on 15-06-14.
 */
public class GetUserData extends AsyncTask<String, Void, String> {

    public String response;
    public String email;
    private Context parent;
    public String get_url = "https://whatdoapi.appspot.com/_ah/api/users/v1/get_user?email=";


    public GetUserData(String s, Context c)
    {
        email = s;
        //get the parent context
        parent = c;

    }

    @Override
    protected String doInBackground(String... url) {
        String json = null;
        try {
            String user = get_url + email;
            Log.v(user, user);
            HttpClient client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(user);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            json = client.execute(httpget, responseHandler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        response = json;
        return response;
    }

    @Override
    protected void onPostExecute(String response) {
        Toast.makeText(parent, response, Toast.LENGTH_LONG).show();
    }


}