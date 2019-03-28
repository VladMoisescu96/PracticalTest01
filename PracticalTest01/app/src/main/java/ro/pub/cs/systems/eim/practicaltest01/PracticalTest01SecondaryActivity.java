package ro.pub.cs.systems.eim.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01SecondaryActivity extends Activity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        Button ok = findViewById(R.id.button3);
        Button cancel = findViewById(R.id.button4);

        ok.setOnClickListener(okButton);
        cancel.setOnClickListener(cancelButton);

        textView = findViewById(R.id.textView);

        if (getIntent().hasExtra("SUM")) {
            textView.setText(Integer.toString(getIntent().getIntExtra("SUM", 0)));
        }
    }

    private OKButton okButton = new OKButton();
    private class OKButton implements View.OnClickListener {
        @Override

        public void onClick(View view) {
            getIntent().putExtra("result", "OK.");
            setResult(RESULT_OK, getIntent());
            finish();
        }
    }

    private CancelButton cancelButton = new CancelButton();
    private class CancelButton implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            getIntent().putExtra("result", "Cancel.");
            setResult(RESULT_OK, getIntent());
            finish();
        }
    }
}
