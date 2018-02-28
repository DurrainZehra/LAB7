package com.example.point.lab7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public String urlJsonData="https://api.androidhive.info/volley/person_array.json";
    RequestQueue queue=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
        ListView listView= (ListView)findViewById(R.id.listView);
        ArrayList<DataModel> list=new ArrayList<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(urlJsonData, new Response.Listener<JSONArray>()
        {
            @Override
            public void onResponse(JSONArray jsonArray)
            {
                for(int i=0;i<jsonArray.length();i++)
                {
                    try {
                        JSONObject contacts=jsonArray.getJSONObject(i);
                        String name=contacts.getString("name");
                        String email=contacts.getString("email");
                        JSONObject phone = contacts.getJSONObject("phone");
                        String home=phone.getString("home");
                        String mobileNum=phone.getString("mobile");
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            }
            ,
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError){

            }
        }
        );
        CustomAdapter adapter=new CustomAdapter(this,R.layout.custom_row_layout,list);
        listView.setAdapter(adapter);
        queue.add(jsonArrayRequest);
    }
    }
