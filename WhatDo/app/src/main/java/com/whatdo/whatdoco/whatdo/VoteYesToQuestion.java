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
public class VoteYesToQuestion extends AsyncTask<String, Void, String> {

    public String url = "https://whatdoapi.appspot.com/_ah/api/questions/v1/yes_vote";
    private String user_id, question_id;

    public VoteYesToQuestion(String _user_id, String _question_id){
        user_id = _user_id;
        question_id = _question_id;
    }


    @Override
    protected String doInBackground(String... param) {
        JSONObject jsonobj = new JSONObject();
        try {
            jsonobj.put("user_id", user_id);
            jsonobj.put("question_id", question_id);
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httppostreq = new HttpPost(url);
            StringEntity se = new StringEntity(jsonobj.toString());
            se.setContentType("application/json;charset=UTF-8");
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
            httppostreq.setEntity(se);
            HttpResponse httpresponse = httpclient.execute(httppostreq);

            Log.i("User", jsonobj.toString());
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