package ctec.smsgroupapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.telephony.SmsManager;



public class SmsActivity extends AppCompatActivity
{
    private EditText smsMessageField;
    private EditText smsNumberField;
    private Button sendSMSButton;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        smsMessageField = (EditText) findViewById(R.id.smsContextEditText);
        smsNumberField = (EditText) findViewById(R.id.smsNumberEditText);
        sendSMSButton = (Button) findViewById(R.id.sendSmsButton);

        setupListeners();
    }


    private void setupListeners()
    {
        sendSMSButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View currentView)
            {
                try
                {
                    String Contact = smsNumberField.getText().toString();
                    String Message = smsMessageField.getText().toString();
                    sendSMS(Contact, Message);
                }

            }
        })
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sms, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
