package com.example.ekkert.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ekkert.myapplication.client.JSonClient;
import com.example.ekkert.myapplication.models.City;

import java.io.IOException;
import java.util.List;

public class Main2Activity extends Activity {
    //static {
    //  System.loadLibrary("hello");
    //}

    //public native String stringFromJNI();
    private Handler h;
    private List<City> cities = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onClickConnect(View v) throws IOException {
        //String[] values = {stringFromJNI()};

        h = new Handler();
        final ListView listView = (ListView) findViewById(R.id.listView2);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //          android.R.layout.simple_list_item_activated_1, values);

        //listView.setAdapter(adapter);


        final Runnable fillst = new Runnable() {
            @Override
            public void run() {
                String[] values = new String[cities.size()];
                int i = 0;
                for (City c : cities) {

                    values[i++] = c.getName();


                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main2Activity.this,
                        android.R.layout.simple_list_item_activated_1, values);
                listView.setAdapter(adapter);
            }
        };

        //textView.setText(stringFromJNI());

        Thread srvConnect = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cities = new JSonClient("192.168.1.2", 5000).getCities();
                    h.post(fillst);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        srvConnect.start();
    }


}
