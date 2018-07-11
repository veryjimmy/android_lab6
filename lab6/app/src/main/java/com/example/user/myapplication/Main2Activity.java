package com.example.user.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import android.os.Bundle;
public class Main2Activity extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private EditText knee;
    private EditText age;
    private TextView bmi;
    private TextView fat;
    private TextView thingheight;

    private int sex = 1;
    private int auto = 1;
    private RadioGroup group_self;
    private RadioButton rdb1;
    private RadioButton rdb2;
    private Button bmibutton;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fat = (TextView) findViewById(R.id.textView7);
        bmi = (TextView) findViewById(R.id.textView6);
        height = (EditText) findViewById(R.id.editText4);
        weight = (EditText) findViewById(R.id.editText3);
        group_self = (RadioGroup) findViewById(R.id.radioGroup);
        rdb1  =  (RadioButton)findViewById(R.id.radioButton);
        rdb2  =  (RadioButton )findViewById(R.id.radioButton2);
        height.addTextChangedListener(weightTextWatcher);
        weight.addTextChangedListener(weightTextWatcher);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null && bundle.containsKey("height2")) {
            height.setText(bundle.getString("height2").toString());
            weight.setText(bundle.getString("weight").toString());
            int a = bundle.getInt("auto");
            if (a == 0)
                rdb1.setChecked(true);
            else
                rdb2.setChecked(true);

        }
    }

    public void heightonclick(View view) {
        Intent intentbmi = new Intent();

        Bundle bundle = new Bundle();
        Bundle bundleget =this.getIntent().getExtras();

        if (bundleget != null && bundleget.containsKey("knee"))
        {
            bundle.putString("knee",bundleget.getString("knee").toString() );
            bundle.putString("age",bundleget.getString("age").toString() );
            bundle.putInt("sex",bundleget.getInt("age") );
            intentbmi.putExtras(bundle);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("height2",height.getText().toString() );
        bundle2.putString("weight",weight.getText().toString() );
        bundle2.putInt("auto", auto);
        intentbmi.putExtras(bundle2);

        //bundle.putString("age",bundle.getString("age").toString());
        //bundle.putInt("sex", bundle.getInt("sex"));
        intentbmi.setClass(Main2Activity.this, MainActivity.class);
        startActivity(intentbmi);
        overridePendingTransition(R.anim.answer_in, R.anim.answer_out);
    }

    public void readme2(View view) {

        Intent intentbmi = new Intent();
        Bundle bundle2 = new Bundle();
        bundle2.putString("height2",height.getText().toString() );
        bundle2.putString("weight",weight.getText().toString() );
        bundle2.putInt("auto", auto);
        intentbmi.putExtras(bundle2);


        Bundle bundle = new Bundle();
        Bundle bundleget =this.getIntent().getExtras();
        if (bundleget != null && bundleget.containsKey("knee"))
        {
            bundle.putString("knee",bundleget.getString("knee").toString() );
            bundle.putString("age",bundleget.getString("age").toString() );
            bundle.putInt("sex",bundleget.getInt("age") );
            intentbmi.putExtras(bundle);
        }
        if (bundleget != null && bundleget.containsKey("height2"))
        {
            bundle.putString("height2",bundleget.getString("height2").toString() );
            bundle.putString("weight",bundleget.getString("weight").toString() );
            bundle.putInt("auto",bundleget.getInt("auto") );
            intentbmi.putExtras(bundle);
        }
        intentbmi.setClass(Main2Activity.this, Main22Activity.class);
        startActivity(intentbmi);
        overridePendingTransition(R.anim.question_in, R.anim.question_out);
    }

    public void setauto(View view) {

        if (group_self.getCheckedRadioButtonId() == R.id.radioButton) {
            height.setText(getIntent().getStringExtra("thingheight"));
            //getIntent().getStringExtra("thingheight")
            //btn_self.setText("auto");
            auto = 0;

        } else {
            // btn_self.setText("自行輸入");
            auto = 1;
        }
        if (weight.getText().toString().matches(""))
            return;
        if (height.getText().toString().matches(""))
            return;

        caculatebmi();
    }

    private void test() {
        if (Double.parseDouble(bmi.getText().toString()) < 18.5) {
            fat.setText("過輕");
        } else if (Double.parseDouble(bmi.getText().toString()) < 24 && Double.parseDouble(bmi.getText().toString()) > 18.5) {
            fat.setText("標準");
        } else if (Double.parseDouble(bmi.getText().toString()) > 24) {
            fat.setText("過重");
        }
    }

    private TextWatcher weightTextWatcher = new TextWatcher() {
        public void onTextChanged(CharSequence s,
                                  int start, int before, int count) {
            if (height.getText().toString().matches(""))
                return;
            if (weight.getText().toString().matches(""))
                return;
            //if(age.getText().toString().matches(""))
            //   return;
            //if(knee.getText().toString().matches(""))
            //   return;

            caculatebmi();
            test();
        }

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s,
                                      int start, int count, int after) {
        }
    };

    private void caculatebmi() {

        bmi.setText(String.valueOf(Double.parseDouble(weight.getText().toString()) / (Double.parseDouble(height.getText().toString()) * Double.parseDouble(height.getText().toString()))));


        test();
///Integer.valueOf(weight.getText().toString()) / (Integer.valueOf(height.getText().toString())*Integer.valueOf(height.getText().toString()))
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main2 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.user.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main2 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.user.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
