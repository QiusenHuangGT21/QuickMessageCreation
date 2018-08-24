package com.learning.huangmr.massager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message_acticity);
    }

    public void onSendMessage(View view) {
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        String value = String.valueOf(spinner1.getSelectedItem());
        StringBuilder output = new StringBuilder("您好，");
        output.append(value);
        spinner1 = (Spinner) findViewById(R.id.spinner2);
        output.append("，" + String.valueOf(spinner1.getSelectedItem()));
        spinner1 = (Spinner) findViewById(R.id.spinner3);
        output.append("，" + String.valueOf(spinner1.getSelectedItem()));
        spinner1 = (Spinner) findViewById(R.id.spinner4);
        output.append("，" + String.valueOf(spinner1.getSelectedItem()) + ", ");
        EditText weight = (EditText) findViewById(R.id.weight);
        output.append(weight.getText().toString() + "吨。 车号：");
        weight = (EditText) findViewById(R.id.car_input);
        output.append(weight.getText().toString() + "。 请报单，谢谢！");

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, output.toString());
        startActivity(intent);
    }
    public void onAddInfo(View view) {
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        String value = String.valueOf(spinner1.getSelectedItem());
        StringBuilder output = new StringBuilder("您好， ");
        output.append(value);
        spinner1 = (Spinner) findViewById(R.id.spinner2);
        output.append("， " + String.valueOf(spinner1.getSelectedItem()));
        spinner1 = (Spinner) findViewById(R.id.spinner3);
        output.append("， " + String.valueOf(spinner1.getSelectedItem()));
        spinner1 = (Spinner) findViewById(R.id.spinner4);
        output.append("， " + String.valueOf(spinner1.getSelectedItem()) + "， ");
        EditText weight = (EditText) findViewById(R.id.weight);
        output.append(weight.getText().toString() + "吨。 车号: ");
        weight = (EditText) findViewById(R.id.car_input);
        output.append(weight.getText().toString() + "。");
        Intent intent = new Intent(this, AddInfoActivity.class);
        intent.putExtra("previous_car",  output.toString());
        startActivity(intent);
    }
}
