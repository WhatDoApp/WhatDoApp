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
public class GetMyQuestionsAsked extends AsyncTask<String, Void, String> {

    public String response;
    public String user_id;
    private Context parent;
    public String get_url = "http://localhost:28081/_ah/api/users/v1/get_questions_asked?user_id=";


    public GetMyQuestionsAsked(String _user_id, Context _context)
    {
        user_id = _user_id;
        //get the parent context
        parent = _context;

    }

    @Override
    protected String doInBackground(String... url) {
        String json = null;
        try {
            String questions = get_url + user_id;
            HttpClient client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(questions);
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