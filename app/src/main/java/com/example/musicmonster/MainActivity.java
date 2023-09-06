package com.example.musicmonster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ListView listView;

    ArrayList< HashMap<String,String> > arrayList = new ArrayList<>();
    HashMap<String,String>hashMap;

    public static String Video_url ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        progressBar = findViewById(R.id.progresber);


        progressBar.setVisibility(View.VISIBLE);

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://outstandingacademy.000webhostapp.com/musticmonster/music.json";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++)
                {
                    try {

                        progressBar.setVisibility(View.GONE);
                        JSONObject jsonObject = response.getJSONObject(i);

                        String title = jsonObject.getString("title");
                        String V_id = jsonObject.getString("video_id");

                        hashMap = new HashMap<>();
                        hashMap.put("title",title);
                        hashMap.put("Video_id",V_id);
                        arrayList.add(hashMap);



                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                }

                Mylist mylist = new Mylist();
                listView.setAdapter(mylist);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressBar.setVisibility(View.GONE);


            }
        });

        queue.add(jsonArrayRequest);




    }

    private class Mylist extends BaseAdapter{


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            progressBar.setVisibility(View.GONE);

            LayoutInflater layoutInflater = getLayoutInflater();

           View myview = layoutInflater.inflate(R.layout.item,viewGroup,false);

            ImageView imageView = myview.findViewById(R.id.item_iamge);
            TextView textView =myview.findViewById(R.id.item_title);

            HashMap<String,String> hashMap1 = arrayList.get(i);
            String title = hashMap1.get("title");
            String vid_id = hashMap1.get("Video_id");


            String imageUrl = "https://img.youtube.com/vi/"+ vid_id +"/0.jpg";


            Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.drawable.boy)
                    .into(imageView);

            textView.setText(title);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    // Handle the ImageView click event here
                    String videoId = vid_id;
                    // Assuming you want to open a new activity to play the video

                    if(videoId.equals("eirmiouZsE4"))
                    {
                        Intent intent = new Intent(MainActivity.this, MusicVideoPlay.class);
                        intent.putExtra("video_id", videoId);
                        startActivity(intent);

                        Video_url ="https://www.youtube.com/embed/eirmiouZsE4?si=cSwawi5OxNAaaRJ2";



                    } else if (videoId.equals("7izt614wtgI")) {

                        Intent intent = new Intent(MainActivity.this, MusicVideoPlay.class);
                        intent.putExtra("video_id", videoId);
                        startActivity(intent);

                        Video_url ="https://www.youtube.com/embed/7izt614wtgI?si=CAOuXEcLzuMdtJDB";

                    } else if ( videoId.equals("SYe-x9ZQF7o") ) {

                        Intent intent = new Intent(MainActivity.this, MusicVideoPlay.class);
                        intent.putExtra("video_id", videoId);
                        startActivity(intent);

                        Video_url ="https://www.youtube.com/embed/SYe-x9ZQF7o?si=sAp6QRIgk30G-NDa";
                        
                    } else if ( videoId.equals("NcC966m0MLU") ) {

                        Intent intent = new Intent(MainActivity.this, MusicVideoPlay.class);
                        intent.putExtra("video_id", videoId);
                        startActivity(intent);

                        Video_url ="https://www.youtube.com/embed/NcC966m0MLU?si=f6dMP6FGrPgK8IA0";

                    } else if ( videoId.equals("5f1O74GwWJM") ) {

                        Intent intent = new Intent(MainActivity.this, MusicVideoPlay.class);
                        intent.putExtra("video_id", videoId);
                        startActivity(intent);

                        Video_url ="https://www.youtube.com/embed/5f1O74GwWJM?si=F5ma2qrIxQmEvHR0";

                    } else if ( videoId.equals("QxUji_IpiOI")  ) {

                        Intent intent = new Intent(MainActivity.this, MusicVideoPlay.class);
                        intent.putExtra("video_id", videoId);
                        startActivity(intent);

                        Video_url ="https://www.youtube.com/embed/QxUji_IpiOI?si=r1mRyobtm-vDLive";


                        
                    }


                }
            });


            return myview;


        }
    }



}