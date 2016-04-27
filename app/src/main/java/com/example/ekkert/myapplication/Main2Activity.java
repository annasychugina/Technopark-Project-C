package com.example.ekkert.myapplication;

import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.NumberPicker.Formatter;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Bundle;
import android.app.ListActivity;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity {
    static {
        System.loadLibrary("hello");
    }
    public native String stringFromJNI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void onClickConnect(View v){
        String[] values = {stringFromJNI()};
        final ListView listView = (ListView) findViewById(R.id.listView2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1, values);
        listView.setAdapter(adapter);
        //textView.setText(stringFromJNI());
    }

}
