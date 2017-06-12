package manager;

import android.content.Context;

/**
 * Created by anildeshpande on 08/06/17.
 */
public class SomeRandomSampleClass {
    private static SomeRandomSampleClass instance;
    private Context mContext;

    private SomeRandomSampleClass(Context context){
        mContext=context;
    }

    public static SomeRandomSampleClass getInstance(Context context){
        if(instance ==null){
            instance =new SomeRandomSampleClass(context.getApplicationContext());
        }
        return instance;
    }
}
