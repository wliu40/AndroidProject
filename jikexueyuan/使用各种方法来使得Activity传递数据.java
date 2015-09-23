package com.example.android.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("MainActivity", " the main activity started");
        //打开网页
        findViewById(R.id.button_open_url).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.163.com")));
            }
        });
        //传入EditText输入的字符串
        findViewById(R.id.send_button_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = (EditText)findViewById(R.id.editText_view);
                String s = et.getText().toString();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("data2", s);
                startActivity(intent);
            }
        });
        //传递Bundle
        findViewById(R.id.send_bundle_button_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("name", "Diudiu");
                b.putInt("age", 4);
                b.putString("color", "white");
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("data_bundle", b);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //Layout XML文件中修改Button的onClick属性, 也可以传递intent
    public void start2Act(View view)
    {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("data1","this is a string from MainActivity");
        startActivity(intent);
    }
    /*
    public void openUrl(View view)
    {

        Uri webpage = Uri.parse("http://www.163.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }
    */
}

//////////////////////////////////////////////////////////////////////////////////////////////////////
package com.example.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.v("MainActivity", " the main activity started");
        Intent intent = getIntent();
        String s1 = intent.getStringExtra("data1");
        System.out.println("s1 = " + s1);
        String s2 = intent.getStringExtra("data2");
        System.out.println("s2 = " + s2);
        Bundle bundle = intent.getBundleExtra("data_bundle");
        tv1 = (TextView)findViewById(R.id.text_view_1);
        tv2 = (TextView)findViewById(R.id.text_view_2);
        tv3 = (TextView)findViewById(R.id.text_view_3);
        if (s1 != null)
            tv1.setText(s1);
        if (s2 != null)
            tv2.setText(s2);
        if (bundle != null)
            tv3.setText(String.format("name: %s, age: %d, color: %s", bundle.getString("name"), bundle.getInt("age"), bundle.getString("color")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
