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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 15-06-14.
 */
public class AddCategoriesToUser extends AsyncTask<String, Void, String> {

    public String url = "https://whatdoapi.appspot.com/_ah/api/categories/v1/add_categories_to_user";
    private String user_id;
    private ArrayList<String> categories;

    public AddCategoriesToUser(String _user_id, List<String> _categories){
        user_id = _user_id;
        categories = new ArrayList<String>(_categories);
    }


    @Override
    protected String doInBackground(String... param) {
        JSONObject jsonobj = new JSONObject();
        JSONArray jsArray = new JSONArray(categories);
        try {
            jsonobj.put("user_id", user_id);
            jsonobj.put("list_category_strings", jsArray);
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