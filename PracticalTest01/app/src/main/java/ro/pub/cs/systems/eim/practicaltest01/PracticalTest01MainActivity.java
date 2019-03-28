package ro.pub.cs.systems.eim.practicaltest01;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01MainActivity extends AppCompatActivity {

    private TextView numberEditText1;
    private TextView numberEditText2;
    private final String firstTextView = "first";
    private final String secondTextView = "second";
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        numberEditText1 = (TextView) findViewById(R.id.textView1);
        numberEditText2 = (TextView) findViewById(R.id.textView2);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button = findViewById(R.id.button);


        button1.setOnClickListener(firstButton);
        button2.setOnClickListener(secondButton);
        button.setOnClickListener(navigationButton);

    }


    private FirstButton firstButton = new FirstButton();
    private class FirstButton implements View.OnClickListener {
        @Override

        public void onClick(View view) {
            numberEditText1.setText(Integer.toString(Integer.parseInt(numberEditText1.getText().toString()) + 1));
        }
    }

    private SecondButton secondButton = new SecondButton();
    private class SecondButton implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            numberEditText2.setText(Integer.toString(Integer.parseInt(numberEditText2.getText().toString()) + 1));
        }
    }

    private NavigationButton navigationButton = new NavigationButton();
    private class NavigationButton implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(getBaseContext(), PracticalTest01SecondaryActivity.class);
            intent.putExtra("SUM",Integer.parseInt(numberEditText1.getText().toString()) + Integer.parseInt(numberEditText2.getText().toString()));
            startActivityForResult(intent, RESULT_OK);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey(firstTextView)) {
            TextView textView = findViewById(R.id.textView1);
            textView.setText(savedInstanceState.getString(firstTextView));
        }
        if (savedInstanceState.containsKey(secondTextView)) {
            TextView textView = findViewById(R.id.textView2);
            textView.setText(savedInstanceState.getString(secondTextView));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(firstTextView, numberEditText1.getText().toString());
        outState.putString(secondTextView, numberEditText2.getText().toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //if (resultCode == RESULT_OK) {

            result = data.getStringExtra("result");
        //}
    }
}
