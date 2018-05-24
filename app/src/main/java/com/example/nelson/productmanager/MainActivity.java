package com.example.nelson.productmanager;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText email;
    EditText pass;
    Button sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editText_correo);
        pass = findViewById(R.id.editText_contrasena);
        sign_in = findViewById(R.id.btn_ingresar);

    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void intenta_Ingresar(View view){
        String email_user = email.getText().toString();
        String pass_user = pass.getText().toString();
        Log.d("Dato",email_user);
        Log.d("Dato",pass_user);
        //Toast.makeText(getApplicationContext(),email_user+pass_user,Toast.LENGTH_SHORT).show();
        if( email_user == null || email_user == " "){
            Toast.makeText(getApplicationContext(),"Ingrese bien los datos",Toast.LENGTH_SHORT).show();
        }else{
            if(pass_user == null || pass_user == " "){

            }else{
                //TODO
                mAuth.signInWithEmailAndPassword(email_user, pass_user)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("TAG", "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("TAG", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(getApplicationContext(), "Error de autenticacion.",
                                            Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }
                            }
                        });
            }
        }
    }

    public void updateUI(FirebaseUser user){
        Intent intent = new Intent(this,Products.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void go_registro(View view){
        Intent intent = new Intent(this,Registro.class);
        startActivity(intent);
    }
}
