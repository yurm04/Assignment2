package com.yuraima.assignment2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "Assignment2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i(TAG, "onCreate");

        /* Registering an onClick event for the "complete" button */
        Button button = (Button) findViewById(R.id.completeBtn);
        button.setOnClickListener( new Button.OnClickListener() {
            public void onClick(View v) {
                /* Check to see if text field is empty, set error message */
                EditText taskField = (EditText) findViewById((R.id.taskField));
                String taskText = taskField.getText().toString();

                TextView viewMessage = (TextView) findViewById(R.id.taskMessage);
                if (taskText.isEmpty()) {
                    viewMessage.setTextColor(Color.RED);
                    viewMessage.setText("Missing Task Field");
                } else {
                    viewMessage.setText("Added Task: " + taskText);
                    Log.i(TAG, "Task Text: " + taskText);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Adding an option menu to add a new accomplishment
        menu.add(0, Menu.FIRST, 0, "Add Accomplishment");

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

    /* Override methods for state change */

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");

        // Get text field entry
        final EditText textBox = (EditText) findViewById(R.id.taskField);
        CharSequence userText = textBox.getText();

        outState.putCharSequence("savedText", userText);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");

        // restore saved edit text field entry
        final EditText textBox = (EditText) findViewById(R.id.taskField);
        CharSequence userText = savedInstanceState.getCharSequence("savedText");
        /*
            NOTE TO SELF
            onRestoreInstanceState gets called on orientation change
            NOT when application switches from in view to foreground, etc.
         */
        textBox.setText(userText);
    }
}
