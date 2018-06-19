package com.foslipy.languagetutorial;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

public class ConnectionDetector {
    Context context;

    public ConnectionDetector(Context context) {
        this.context = context;
    }

    public boolean isConnected() {
        ConnectivityManager connection = (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if (connection != null) {
            NetworkInfo info = connection.getActiveNetworkInfo();
            if (info != null)
            {
                if(info.getState()== NetworkInfo.State.CONNECTED)
                {
                    return true;
                }
                else {
                    return false;
                }

            }else {
                return false;
            }
        } else{
            return  false;
        }

    }
}
