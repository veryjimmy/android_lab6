package com.example.user.myapplication;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.*;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private EditText knee;
    private EditText age;
    private TextView bmi;
    private TextView fat;
    private TextView thingheight;

    private int sex = 1;
    private int auto = 1;
    private RadioButton   btn_sex;
    private RadioButton   btn_sex2;
    private RadioGroup  group_sex;
    private Button  btn_self;
    private Button bmibutton;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        age = (EditText) findViewById(R.id.editText);
        knee = (EditText) findViewById(R.id.editText2);

        thingheight = (TextView) findViewById(R.id.textView9);
        group_sex  =  (RadioGroup)findViewById(R.id.radioGroup);
        btn_sex  =  (RadioButton )findViewById(R.id.radioButton);
        btn_sex2  =  (RadioButton )findViewById(R.id.radioButton2);
        //btn_self  = (Button) findViewById(R.id.button2);
        //bmibutton=(Button) findViewById(R.id.button6);
        //ewbutton=(Button) findViewById(R.id.button6);

        age.addTextChangedListener(weightTextWatcher);
        knee.addTextChangedListener(weightTextWatcher);
        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null ) {
            knee.setText(bundle.getString("knee").toString());
            age.setText(bundle.getString("age").toString());
            int a = bundle.getInt("sex");
            if (a == 0)
                btn_sex.setChecked(true);
            else
                btn_sex2.setChecked(true);

        }
    }
    public void bmionclick(View view){
        Intent intentbmi = new Intent();
        intentbmi.putExtra("thingheight",thingheight.getText().toString());

        Bundle bundle = new Bundle();
        bundle.putString("knee",knee.getText().toString() );
        bundle.putString("age",age.getText().toString() );
        bundle.putInt("sex", sex);
        intentbmi.putExtras(bundle);


        Bundle bundleget =this.getIntent().getExtras();
        if (bundleget != null && bundleget.containsKey("height2"))
        {
            bundle.putString("height2",bundleget.getString("height2").toString() );
            bundle.putString("weight",bundleget.getString("weight").toString() );
            bundle.putInt("auto",bundleget.getInt("auto") );
            intentbmi.putExtras(bundle);
        }

        intentbmi.setClass(MainActivity.this,Main2Activity.class);
        startActivity(intentbmi);
        overridePendingTransition(R.anim.answer_in, R.anim.answer_out);

    }
    public void readme(View view){
        Intent intentbmi = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("knee",knee.getText().toString() );
        bundle.putString("age",age.getText().toString() );
        bundle.putInt("sex", sex);
        intentbmi.putExtras(bundle);
        Bundle bundleget =this.getIntent().getExtras();
        if (bundleget != null && bundleget.containsKey("height2"))
        {
            bundle.putString("height2",bundleget.getString("height2").toString() );
            bundle.putString("weight",bundleget.getString("weight").toString() );
            bundle.putInt("auto",bundleget.getInt("auto") );
            intentbmi.putExtras(bundle);
        }
        intentbmi.setClass(MainActivity.this,Main22Activity.class);
        startActivity(intentbmi);
        overridePendingTransition(R.anim.question_in, R.anim.question_out);
    }
    public void setboy(View view)
    {

        if(group_sex.getCheckedRadioButtonId() == R.id.radioButton)
        {
            //btn_sex.setText("女");
            sex = 0;
        }
        else{
           // btn_sex.setText("男");
            sex = 1;
        }
        if(knee.getText().toString().matches(""))
            return;
        if(age.getText().toString().matches(""))
            return;
        caculateheight();
    }
    /*public void setauto(View view)
    {

        if(btn_self.getText().toString()=="自行輸入")
        {
            btn_self.setText("auto");
            auto = 0;
        }
        else {
            btn_self.setText("自行輸入");
            auto = 1;
        }
        if(weight.getText().toString().matches(""))
            return;
        if(height.getText().toString().matches(""))
            return;
        if(thingheight.getText().toString().matches(""))
            return;
        caculatebmi();
    }*/
    public void reset(View view){
        height.setText("0");
        weight.setText("0");
        age.setText("0");
        knee.setText("0");
        fat.setText("0");
        bmi.setText("0");
        thingheight.setText("0");
    }

    private TextWatcher weightTextWatcher = new TextWatcher() {
        public void onTextChanged(CharSequence s,
                                  int start, int before, int count){
//            if(height.getText().toString().matches(""))
 //               return ;
  //          if(weight.getText().toString().matches(""))
   //             return;
            if(age.getText().toString().matches(""))
                return;
            if(knee.getText().toString().matches(""))
                return;

            caculateheight();
        }
        public void afterTextChanged(Editable s) {}
        public void beforeTextChanged(CharSequence s,
                                      int start, int count, int after){}
    };

    private void caculateheight(){

        if(sex==0) {
            thingheight.setText(String.valueOf((85.1+1.73*Double.parseDouble(knee.getText().toString())-0.11*Double.parseDouble(age.getText().toString()))*0.01));
        }
        else
        {
            thingheight.setText(String.valueOf((91.45+1.53*Double.parseDouble(knee.getText().toString())-0.16*Double.parseDouble(age.getText().toString()))*0.01));
            // /thingheight.setText(String.valueOf(91.45+1.53*Double.parseDouble(knee.getText().toString())-0.16*Double.parseDouble(age.getText().toString())*0.01));
        }
    }
    public void reset(){
        knee.setText("");
    }

}
