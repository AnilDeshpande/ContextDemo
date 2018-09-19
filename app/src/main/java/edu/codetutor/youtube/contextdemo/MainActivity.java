package edu.codetutor.youtube.contextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import manager.SomeRandomSampleClass;

/*
    We are printing the hash codes of the Activity Context. If Hash codes match the Objects are same.
    So just observe in which case they match and in which case they won't
 */
public class MainActivity extends AppCompatActivity {

    private static MainActivity sampleStaticInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("STATIC","Activity's Hashcode: "+this.hashCode());// This hash code will chane each time screen orientation changed

        SomeRandomSampleClass sampleObject = SomeRandomSampleClass.getInstance(this);
        Log.i("STATIC","SomeRandomSampleClass static context reference "+sampleObject.mContext.hashCode());// This won't change. This causes the memory leak

        sampleStaticInstance = this;
        Log.i("STATIC","Comparing static with new instance "+sampleStaticInstance.hashCode()+":"+this.hashCode());// Since bother are same that means this not going to cause Memory Leak
    }
}
