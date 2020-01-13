package com.miguelcr.intentexplicito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etEmail, etPass;
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Conectar los componentes visuales (Views) de
        // nuestro layout activity_main con las variables
        // que tenemos declaradas en esta clase.

        etEmail = findViewById(R.id.editTextEmail);
        etPass = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.buttonLogin);
        btnRegister = findViewById(R.id.buttonRegister);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        
        if(id == R.id.buttonLogin) {
            doLogin();
        } else if(id == R.id.buttonRegister) {
            doRegister();
        }
    }

    private void doRegister() {
    }

    private void doLogin() {
        String email = etEmail.getText().toString();
        String password = etPass.getText().toString();

        if(email.equals("admin@admin.com") && password.equals("1234")) {
            // Login correcto
            Toast.makeText(
                    this,
                    "Login correcto",
                    Toast.LENGTH_LONG).show();
        } else {
            // Login incorrecto
            if(email.isEmpty()) {
                etEmail.setError("Se debe escribir un email");
            } else if(password.isEmpty()) {
                etPass.setError("Se debe escribir una contraseña");
            } else {
                etEmail.setError("Email y/o contraseña incorrectos");
            }
        }
    }
}
