package com.hexabyte.demo;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

public class Main2Activity extends AppCompatActivity {
    public User user;
    public Button sBtn;
    public DatabaseReference ref;
    public EditText nameTxt,addTxt,ageTxt;
    public TextView lgnTxtClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

            }
        }