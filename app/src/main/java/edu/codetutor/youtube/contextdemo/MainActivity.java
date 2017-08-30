package edu.codetutor.youtube.contextdemo;

import android.app.Activity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

import manager.SomeRandomSampleClass;

public class MainActivity extends Activity implements SensorEventListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    SomeRandomSampleClass someRandomSampleClass;


    //Utilize the services of WeakReference concept of you really need to hold static References
    private static WeakReference<MainActivity> activity;

    //If you have static views, if you need then always dereference them in Activity Life Cycle methods.
    private static TextView textViewLabel;

    //Don't have static inner class References
    private static Object sampleInnerClassObject;

    Thread thread;

    //Working with Sensors
    private SensorManager sensorManager;
    private Sensor sensor;

    //Private static AsyncTask class
    private static class MyAsyncTask extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }

    private static class CustomHandler extends Handler{
        @Override public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    private static class RunnableForHandler implements Runnable{
        @Override
        public void run() {

        }
    }

    private static class MyTimerTask extends TimerTask{
        @Override
        public void run() {

        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = new WeakReference<MainActivity>(this);

        textViewLabel = (TextView)findViewById(R.id.textViewLabel);

        class SampleInnerClass{

        }

        sampleInnerClassObject = new SampleInnerClass();


        //Staring a Anonymous Inner AsyncTask
        /*new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }
        }.execute();*/

        new MyAsyncTask().execute();

        //Having a Anonymous Inner Handler
        new CustomHandler().postDelayed(new RunnableForHandler(), Long.MAX_VALUE >> 1);


        //Having a Anonymous Inner Thread
        thread = new Thread(){
            @Override
            public void run() {
                if(!isInterrupted()){

                }
            }
        };
        thread.start();


        //Stating a Anonymous inner timer
        new Timer().schedule(new MyTimerTask(), Long.MAX_VALUE >> 1);

        registerSensor();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textViewLabel=null;
        unregisterSensors();
        if(thread!=null){
            thread.interrupt();
        }


    }

    private void registerSensor(){
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ALL);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    private void unregisterSensors(){
        if(sensorManager!=null && sensor!=null){
            sensorManager.unregisterListener(this,sensor);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }
}
