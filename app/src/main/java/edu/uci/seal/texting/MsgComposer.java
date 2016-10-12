package edu.uci.seal.texting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MsgComposer extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composer);


        Button sendMsg = (Button) findViewById(R.id.sendMsgBtn);
        sendMsg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        i.setAction("edu.uci.seal.action.SEND_SMS");
        String phoneNumber = ((EditText) findViewById(R.id.phoneNumber)).getText().toString();
        String msg = ((EditText) findViewById(R.id.msg)).getText().toString();
        i.putExtra("PHONE_NUMBER", phoneNumber);
        i.putExtra("TEXT_MSG", msg);

        startService(i);
    }
}
