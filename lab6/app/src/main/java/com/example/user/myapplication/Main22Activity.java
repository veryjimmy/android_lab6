package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.Bundle;
public class Main22Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
    }
    public void heightonclick2(View view){
        Intent intentbmi = new Intent();

        Bundle bundle = new Bundle();
        Bundle bundleget =this.getIntent().getExtras();

        if (bundleget != null && bundleget.containsKey("knee"))
        {
            bundle.putString("knee",bundleget.getString("knee").toString() );
            bundle.putString("age",bundleget.getString("age").toString() );
            bundle.putInt("sex",bundleget.getInt("age") );
            intentbmi.putExtras(bundleget);
        }
        if (bundleget != null && bundleget.containsKey("height2"))
        {
            bundle.putString("height2",bundleget.getString("height2").toString() );
            bundle.putString("weight",bundleget.getString("weight").toString() );
            bundle.putInt("auto",bundleget.getInt("auto") );
            intentbmi.putExtras(bundle);
        }

        intentbmi.setClass(Main22Activity.this,MainActivity.class);
        startActivity(intentbmi);
        overridePendingTransition(R.anim.answer_in, R.anim.answer_out);
    }

    public void bmionclick2(View view){
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

        if (bundleget != null && bundleget.containsKey("height2"))
        {
            bundle.putString("height2",bundleget.getString("height2").toString() );
            bundle.putString("weight",bundleget.getString("weight").toString() );
            bundle.putInt("auto",bundleget.getInt("auto") );
            intentbmi.putExtras(bundle);
        }

        intentbmi.setClass(Main22Activity.this,Main2Activity.class);
        startActivity(intentbmi);
        overridePendingTransition(R.anim.question_in, R.anim.question_out);
    }
    public void exit(View view){
        //android.os.Process.killProcess( android.os.Process.myPid());
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
    public void reset(View view){
        Intent intentbmi = new Intent();
        intentbmi.setClass(Main22Activity.this, Main22Activity.class);
        startActivity(intentbmi);
    }
}
