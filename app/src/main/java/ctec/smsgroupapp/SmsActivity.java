package ctec.smsgroupapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.telephony.SmsManager;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;


import java.util.ArrayList;


public class SmsActivity extends AppCompatActivity
{
    private EditText smsMessageField;
    private EditText smsNumberField;
    private Button sendSMSButton;
    private Button phraseButton;
    private Button emilyButton;
    private Button nickButton;



    private ListView phraseList;
    private ArrayList<String> arrayPhraseList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        smsMessageField = (EditText) findViewById(R.id.smsContextEditText);
        smsNumberField = (EditText) findViewById(R.id.smsNumberEditText);
        sendSMSButton = (Button) findViewById(R.id.sendSmsButton);
        phraseButton = (Button) findViewById(R.id.phraseButton);
        nickButton = (Button) findViewById(R.id.nickButton);
        emilyButton = (Button) findViewById(R.id.emilyButton);





        phraseList = (ListView) findViewById(R.id.phraseList);
        arrayPhraseList = new ArrayList<String>();

        buildArrayList();
        arrayListToListView();

        setupListeners();

    }


    private void buildArrayList()
    {
        arrayPhraseList.add("Have a nice day!");
        arrayPhraseList.add("Your punctuation is superb today!");
        arrayPhraseList.add("Boy oh boy you sure are dandy!");

    }


    private void arrayListToListView()
    {
        ArrayAdapter<String> myListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayPhraseList);
        phraseList.setAdapter(myListAdapter);
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

                    Toast.makeText(currentView.getContext(), "message was sent", Toast.LENGTH_SHORT).show();
                }

                catch (Exception currentException)
                {
                    Toast.makeText(currentView.getContext(), "message was not sent", Toast.LENGTH_LONG).show();
                    Toast.makeText(currentView.getContext(), currentException.getMessage(), Toast.LENGTH_LONG).show();
                }




            }
        });


            phraseList.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    smsMessageField.setText(arrayPhraseList.get(position));
                }

            });



        phraseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View ButtonView)
            {
                if (phraseList.getVisibility() == View.GONE)
                {
                    phraseList.setVisibility(View.VISIBLE);
                } else
                {
                    phraseList.setVisibility(View.GONE);
                }
            }


        });


        nickButton.setOnClickListener(new View.OnClickListener()
        {
           @Override
        public void onClick(View ButtonView)
           {

               smsNumberField.setText("8017937631");

           }

        });


        emilyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View ButtonView)
            {
                smsNumberField.setText("8017957846");
            }

        });




    }










    private void sendSMS(String messageAddress, String messageContent)
    {
        SmsManager mySMSManager = SmsManager.getDefault();
        mySMSManager.sendTextMessage(messageAddress, null, messageContent, null, null);

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
