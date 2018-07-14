package com.example.smaik.shortcutsapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonContacts = findViewById(R.id.ma_contacts_btn);
        Button buttonAlarm = findViewById(R.id.ma_alarm_btn);
        buttonAlarm.setOnClickListener(view ->
        {
            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
            if (intent.resolveActivity(getPackageManager()) != null)
                startActivity(intent);
        });
        buttonContacts.setOnClickListener(view->
        {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
            if(intent.resolveActivity(getPackageManager()) != null)
                startActivityForResult(intent,1);
        });
    }
}
