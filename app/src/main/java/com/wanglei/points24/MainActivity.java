package com.wanglei.points24;

import android.app.ListActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
//import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity implements TextWatcher {
//    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView a = findViewById(R.id.a);
        a.addTextChangedListener(this);
        TextView b = findViewById(R.id.b);
        b.addTextChangedListener(this);
        TextView c = findViewById(R.id.c);
        c.addTextChangedListener(this);
        TextView d = findViewById(R.id.d);
        d.addTextChangedListener(this);
        update();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        update();
    }

    private void update() {
//        long start = System.currentTimeMillis();
        TextView a = findViewById(R.id.a);
        TextView b = findViewById(R.id.b);
        TextView c = findViewById(R.id.c);
        TextView d = findViewById(R.id.d);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Point.getPoints24(getFloat(a), getFloat(b), getFloat(c), getFloat(d))));
//        Log.i(TAG, "WL_DEBUG update cost = " + (System.currentTimeMillis() - start));
    }

    private float getFloat(TextView tv) {
        float result = 0;
        try {
            result = Float.parseFloat(tv.getText().toString());
        } catch (Exception e) {
//            Log.e(TAG, "WL_DEBUG getFloat e = " + e, e);
        }
        return result;
    }
}