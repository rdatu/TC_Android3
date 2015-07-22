package rdatu.android.cyscorpions.com.volleyexample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends Activity {

    public static final String TAG_MESSAGE = "message";
    public static final String TAG_IMAGE = "images";
    public static final String TAG_CODE = "code";

    private TextView mRequestText, mMessageText;
    private String mURL;
    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRequestText = (TextView) findViewById(R.id.displayText);
        mMessageText = (TextView) findViewById(R.id.messageText);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mURL = "http://cblunt.github.io/blog-android-volley/response.json";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, mURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                //mRequestText.setText(jsonObject.toString());

                try {

                    String message = jsonObject.getString(TAG_MESSAGE);
                    String code = jsonObject.getString(TAG_CODE);

                    JSONArray images = jsonObject.getJSONArray(TAG_IMAGE);
                    String imgurl = images.getString(0);
                    mMessageText.setText("MESSAGE:\n\t" + message + "\nCODE:\n\t" + code);
                    mRequestText.setText(imgurl);
                    LoadImage loadimage = new LoadImage();
                    loadimage.execute(imgurl);

                    if (message == null) {
                        Log.d("MainActivity", "message is null");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("MainActivity", "Something Went Wrong");
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mRequestText.setText(volleyError.toString());
            }
        });


        VolleyApplication.getInstance().getRequestQueue().add(request);
    }

    class LoadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                java.net.URL url = new java.net.URL(params[0]);
                Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                return bitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            mImageView.setImageBitmap(bitmap);
        }
    }

}
