package com.learning.huangmr.massager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class AddInfoActivity extends AppCompatActivity {

    public static String massage;
    public static final String EXTRA_MESSAGE = "previous_car";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
        Intent intent = getIntent();
        massage = intent.getStringExtra(EXTRA_MESSAGE);
    }

    public String getSelection() {
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        String value = String.valueOf(spinner1.getSelectedItem());
        StringBuilder output = new StringBuilder(massage);
        output.append("您好，");
        output.append(value);
        spinner1 = (Spinner) findViewById(R.id.spinner2);
        output.append("，" + String.valueOf(spinner1.getSelectedItem()));
        spinner1 = (Spinner) findViewById(R.id.spinner3);
        output.append("，" + String.valueOf(spinner1.getSelectedItem()));
        spinner1 = (Spinner) findViewById(R.id.spinner4);
        output.append("，" + String.valueOf(spinner1.getSelectedItem()) + "，");
        EditText weight = (EditText) findViewById(R.id.weight);
        output.append(weight.getText().toString() + "吨。 车号：");
        weight = (EditText) findViewById(R.id.car_input);
        output.append(weight.getText().toString() + "。 请报单，谢谢！");
        return output.toString();
    }

    public void onSendMessage(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, getSelection());
        startActivity(intent);
    }

    public void onClear(View view) {
        Intent intent = new Intent(this, CreateMessageActivity.class);
        startActivity(intent);
    }

    public void onViewText(View view) {
        Intent intent = new Intent(this, viewTextActivity.class);
        intent.putExtra("currentText", getSelection());
        startActivity(intent);
    }

    public void onAddInfo(View view) {
        Intent intent = new Intent(this, AddInfoActivity.class);
        intent.putExtra("previous_car", getSelection());
        startActivity(intent);
    }
}
