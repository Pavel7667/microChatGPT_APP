package com.microchatgpt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView textView;
    EditText messageEditText;
    ImageButton sendButton;
    List<Message> messagesList;
    MessageAdapter messageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messagesList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        textView = findViewById(R.id.welcome_text);
        messageEditText = findViewById(R.id.mesagage_edit_text);
        sendButton = findViewById(R.id.send_btn);

        // setup recycler view
        messageAdapter = new MessageAdapter(messagesList);
        recyclerView.setAdapter(messageAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        sendButton.setOnClickListener(v->{
            String question = messageEditText.getText().toString().trim();
            Toast.makeText(this,question,Toast.LENGTH_LONG).show();
        });
    }
}