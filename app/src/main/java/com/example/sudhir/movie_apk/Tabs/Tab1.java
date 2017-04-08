package com.example.sudhir.movie_apk.Tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sudhir.movie_apk.Main2Activity;
import com.example.sudhir.movie_apk.R;

/**
 * Created by sudhir on 04/04/17.
 */

public class Tab1 extends Fragment {
    EditText t1 ;
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.tab1,container,false);
        Button b = (Button) v.findViewById(R.id.submit_area);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = (EditText) v.findViewById(R.id.EditText2);
                Intent i = new Intent();
                i.putExtra("year",t1.getText().toString());
                i.setClass(getActivity(), Main2Activity.class);
                startActivity(i);

            }
        });
        return v;
    }
}
