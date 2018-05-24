package com.example.nelson.productmanager;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registro extends AppCompatActivity {

    EditText user;
    EditText pass;
    EditText pass_confirm;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();
        user = findViewById(R.id.editText_usuario);
        pass = findViewById(R.id.editText_pass1);
        pass_confirm=findViewById(R.id.editText_pass2);
    }

    public void registrar(View view){
        String user_written = user.getText().toString();
        String pass_written = pass.getText().toString();
        String pass2_written = pass_confirm.getText().toString();
        if(user_written.compareTo(" ") != 0 && pass_written.compareTo(" ") != 0 && pass2_written.compareTo(" ") != 0 ){
            if(pass_written.compareTo(pass2_written)==0){
                //TODO
                Log.d("Dato",user_written);
                Log.d("Dato",pass_written);
                mAuth.createUserWithEmailAndPassword(user_written, pass_written)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("TAG", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    go_main(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(getApplicationContext(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        );
            }else{
                Toast.makeText(getApplicationContext(), "Contraseñas diferentes",
                        Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Falto completar un campo.",
                    Toast.LENGTH_SHORT).show();

        }

    }

    public void go_main(FirebaseUser user){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
