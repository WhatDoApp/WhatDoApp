package android_class.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by admin on 15-06-14.
 */
public class AskQuestion extends AsyncTask<String, Void, String> {

    public String url = "https://whatdoapi.appspot.com/_ah/api/questions/v1/create";
    private String user_id, title, category_id;

    public AskQuestion(String _user_id, String _title, String _category_id){
        user_id = _user_id;
        title = _title;
        category_id = _category_id;

    }

    @Override
    protected String doInBackground(String... param) {
        JSONObject jsonobj = new JSONObject();
        try {
            jsonobj.put("user_id", user_id);
            jsonobj.put("title", title);
            jsonobj.put("category_id", category_id);
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httppostreq = new HttpPost(url);
            StringEntity se = new StringEntity(jsonobj.toString());
            se.setContentType("application/json;charset=UTF-8");
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
            httppostreq.setEntity(se);
            HttpResponse httpresponse = httpclient.execute(httppostreq);

            Log.i("Data", jsonobj.toString());
        }  catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}