package com.jpach.tester;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends AppCompatActivity {


    public Button FirstButton, EnterButton;
    public TextView MainText;
    public WebView WebWindow;
    public EditText EnteredURL;
    public FloatingActionButton Closeapp;

    //this is just a test pushed from the pc in the first floor using android studio.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_index);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Closeapp = (FloatingActionButton) findViewById(R.id.Closeapp);
        Closeapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        MainText = (TextView) findViewById(R.id.MainText);

        FirstButton = (Button) findViewById(R.id.FirstButton);
        FirstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainText.setText(R.string.Changed_Text);

            }
        });

        WebWindow = (WebView) findViewById(R.id.WebWindow);
        WebWindow.setWebViewClient(new WebViewClient());
        WebWindow.getSettings().setJavaScriptEnabled(false);
        EnteredURL = (EditText) findViewById(R.id.EnteredURL);
        EnterButton = (Button) findViewById(R.id.EnterButton);



        EnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WebWindow.loadUrl(EnteredURL.getText().toString());

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
    protected void onPause(){

        super.onPause();
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.moveTaskToFront(getTaskId(), 0);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){

        return false;

    }

    /*@Override
    public void onAttachedToWindow(){

        this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);
        super.onAttachedToWindow();

    }*/


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
