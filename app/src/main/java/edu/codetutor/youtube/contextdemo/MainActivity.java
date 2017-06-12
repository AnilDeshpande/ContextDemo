package edu.codetutor.youtube.contextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import manager.SomeRandomSampleClass;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SomeRandomSampleClass sampleObject= SomeRandomSampleClass.getInstance(this);
    }
}
