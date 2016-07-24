package com.example.parul.twitter;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

public class Util {
    public static boolean isLollipopOrGreater() {
        return Build.VERSION.SDK_INT >= 21 ? true : false;
    }
    public static boolean isJellyBeanOrGreater(){
        return Build.VERSION.SDK_INT>=16?true:false;
    }


    /**
     * @param context
     *            reference of {@link Context} class.
     * @return true if Internet connection is available otherwise false;
     */
    public static boolean checkInternetConnection(Context context) throws Exception {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // test for connection
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } /*else {
            Log.e("Internet connection not found.");
            throw new IllegalStateException("Internet connection not found.");
        }*/
        return false;
    }


    public static void openActivity(Context context,Class<?> class1) throws NullPointerException, Exception{

        final Intent intent=new Intent(context,class1);
        context.startActivity(intent);

    }
    //open new activity and kill the previous one.
    public static void openNewActivity(Context context,Class<?> class1) throws NullPointerException, Exception{

        final Intent intent=new Intent(context,class1);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        context.startActivity(intent);


    }

}
