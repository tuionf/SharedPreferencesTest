package com.example.tuionf.sharedpreferencestest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private Button re;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn_save);
        re = (Button) findViewById(R.id.re_save);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("datadata",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString("name","tuionf");
                editor.putInt("age",23);
                editor.putBoolean("boy",true);

                editor.commit();
            }
        });

        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("datadata",MODE_PRIVATE);
                String name = sharedPreferences.getString("name","");
                int age = sharedPreferences.getInt("age",0);
                boolean sex = sharedPreferences.getBoolean("boy",false);

                Log.d("Main","name is "+name+"----->"+"age is "+age+"----->"+"sex is "+sex);
            }
        });
    }
}
