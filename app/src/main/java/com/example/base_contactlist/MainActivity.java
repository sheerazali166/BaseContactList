package com.example.base_contactlist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText nameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText phoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Get editText reference
        nameEditText = findViewById(R.id.input_name);
        lastNameEditText = findViewById(R.id.input_lastName);
        emailEditText = findViewById(R.id.input_email);
        phoneNumberEditText = findViewById(R.id.input_phoneNumber);

        Button button = findViewById(R.id.button_create_contact);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getText().toString();


                // Get values from EditText and create a new Contact
                Integer phoneNumberInt = parsePhoneNumber(phoneNumber);
                if (phoneNumberInt != null) {
                    createNewContact(name, lastName, email, phoneNumberInt);
                }


            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void createNewContact(String name, String lastName, String email, Integer phoneNumber) {

        Contact contact = new Contact(name, lastName, email, phoneNumber);
        Log.d(TAG, "createNewContact: " + contact.toString());
        clearEditText();

        Intent intent = new Intent(this, DetailActivity.class);
        // TODO: send the reset of contact parameters
        intent.putExtra("name", name);
        startActivity(intent);
    }

    private void clearEditText() {
        nameEditText.setText("");
        lastNameEditText.setText("");
        emailEditText.setText("");
        phoneNumberEditText.setText("");
    }

    public static Integer parsePhoneNumber(String phoneNumber) {

        try {
            return Integer.parseInt(phoneNumber);

        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }
}