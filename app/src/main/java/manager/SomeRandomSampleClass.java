package manager;

import android.content.Context;
import android.util.Log;

/**
 * Created by anildeshpande on 08/06/17.
 */
public class SomeRandomSampleClass {
    private static SomeRandomSampleClass instance;
    public static Context mContext;

    private SomeRandomSampleClass(Context context){
        mContext=context;
    }

    public static SomeRandomSampleClass getInstance(Context context){
        if(instance ==null){
            instance =new SomeRandomSampleClass(context);
            Log.i("STATIC","SomeRandomSampleClass Context assignment: "+mContext.hashCode());// Gets called only once and holds on to First time reference of the Activity
        }

        return instance;
    }
}
