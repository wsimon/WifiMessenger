package com.simonfam.wifimessenger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactsActivity.this, AddContactActivity.class);
                startActivity(intent);
            }
        });


        //Initialize Dynamic Contact List
        TableLayout contactTable = (TableLayout) findViewById(R.id.contact_table);

        //TODO Pull data from file or shared prefs
        for (int i = 0; i < 2; i++) {
            TableRow row = new TableRow(this);
            row.setGravity(Gravity.CENTER);

            //Name
            TextView name = new TextView(this);
            name.setText("Contact #" + i);
            row.addView(name);

            //Ip
            TextView ip = new TextView(this);
            ip.setText("192.168.1." + i);
            row.addView(ip);

            //Delete
            ImageButton minusBtn = new ImageButton(this);
            minusBtn.setImageResource(android.R.drawable.ic_delete);
            minusBtn.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));
            row.addView(minusBtn);

            contactTable.addView(row);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contacts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
