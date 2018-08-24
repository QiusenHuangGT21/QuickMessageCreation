package com.learning.huangmr.massager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class viewTextActivity extends AppCompatActivity {

    public static String currentText;
    public static final String EXTRA_MESSAGE = "currentText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_text);
        Intent intent = getIntent();
        currentText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageTextView = (TextView) findViewById(R.id.messageTextView);
        messageTextView.setText(currentText);
    }

    public void onReturn(View view) {
        Intent intent = new Intent(this, AddInfoActivity.class);
        intent.putExtra("previous_car", currentText);
        startActivity(intent);
    }

    public void onReset(View view) {
        Intent intent = new Intent(this, CreateMessageActivity.class);
        startActivity(intent);
    }

    public void onSend(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, currentText);
        startActivity(intent);
    }

}
