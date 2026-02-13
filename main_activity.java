package com.example.ex_091;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import android.os.Bundle;
import androidx.core.view.ViewCompat;
import android.widget.Button;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Spinner;
import android .widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerstate;
    EditText firstname,lastname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Spinner spinnerState = findViewById(R.id.spinnerState);
            ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource(
                    this,
                    R.array.state_list,
                    android.R.layout.simple_spinner_item
            );
            stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerState.setAdapter(stateAdapter);

            Spinner spinnerComplaint = findViewById(R.id.spinnerType);
            ArrayAdapter<CharSequence> complaintAdapter = ArrayAdapter.createFromResource(
                    this,
                    R.array.Complaint_type_list,
                    android.R.layout.simple_spinner_item
            );
            complaintAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerComplaint.setAdapter(complaintAdapter);
            lastname=findViewById(R.id.etLastName);
            firstname=findViewById(R.id.FirstName);
            Button btnSubmit=findViewById(R.id.btnSubmit);
            btnSubmit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    firstname.setTextColor(Color.RED);
                    firstname.setTextSize(20);
                    lastname.setTextColor(Color.BLUE);
                    lastname.setTextSize(20);
                    Toast.makeText(MainActivity.this,"Submitted Successfully!",Toast.LENGTH_SHORT).show();
                }
            });
            return insets;
        });
    }
}

