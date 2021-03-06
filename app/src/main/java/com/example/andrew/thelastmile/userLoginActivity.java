package com.example.andrew.thelastmile;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.test.SingleLaunchActivityTestCase;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class userLoginActivity extends Activity
{
    private EditText username;
    private EditText password;
    private Button login;
    private Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        login = (Button) findViewById(R.id.email_sign_in_button);
        login.setOnClickListener(ocl);
       // login.setBackgroundColor(Color.MAGENTA);

        findViewById(R.id.button_singup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(userLoginActivity.this, Singup.class));
            }
        });
    }


    OnClickListener ocl = new OnClickListener()
    {
        public void onClick(View arg0)
        {
            username = (EditText) findViewById(R.id.email);
            password = (EditText) findViewById(R.id.password);
            //判断用户输入的用户名和密码是否与设置的值相同
            if ("321".equals(username.getText().toString()) &&
                    "321".equals(password.getText().toString()))
            {
                intent = new Intent(userLoginActivity.this, User.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(userLoginActivity.this, "User login information error", Toast.LENGTH_SHORT).show();
            }
        }
    };
}