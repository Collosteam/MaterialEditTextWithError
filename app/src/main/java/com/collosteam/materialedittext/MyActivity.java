package com.collosteam.materialedittext;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.collosteam.materialedittextlib.MaterialEditTextWithError;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_my);

        final MaterialEditTextWithError etLogin = (MaterialEditTextWithError) findViewById(R.id.etLogin);
        etLogin.setHint("Log In");

        MaterialEditTextWithError etSignUp = (MaterialEditTextWithError) findViewById(R.id.etSignUp);
        etSignUp.setBackgroundResource(R.drawable.material_edittext_bg_black);
        etSignUp.setHint("Sign Up");
        etSignUp.setTextColor(getResources().getColor(R.color.app_grey));
        etSignUp.setHintColorIds(R.color.app_focused_label, R.color.app_unfocused_label);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etLogin.setError("Field can't be empty!");
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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
