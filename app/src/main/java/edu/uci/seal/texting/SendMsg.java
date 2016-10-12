package edu.uci.seal.texting;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.util.Log;

public class SendMsg extends Service {
    public SendMsg() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        if (checkCallingPermission("edu.uci.seal.action.SEND_SMS")
                == PackageManager.PERMISSION_GRANTED) {
            String phoneNumber = intent.getStringExtra("PHONE_NUMBER");
            //throws NullPointerException if phoneNumber is empty, or IndexOutOfBoundsException if the length is less than 3
            String areaCode = phoneNumber.substring(0, 3);
            String msg = intent.getStringExtra("TEXT_MSG");
            Log.i("TEXTING", "Send a message to " + phoneNumber + " text: " + msg);
            SmsManager smsManager = SmsManager.getDefault();
            //This API throws IllegalArgumentException if the message body is empty
            smsManager.sendTextMessage(phoneNumber, null, msg, null, null);
        }
        return START_STICKY;
    }
}
