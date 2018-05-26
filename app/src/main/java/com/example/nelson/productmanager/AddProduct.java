package com.example.nelson.productmanager;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddProduct extends AppCompatActivity {

    EditText name;
    EditText description;
    Button addButton;
    private DatabaseReference mDatabase;
    int cont=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        name = findViewById(R.id.editText_nombreGet);
        description = findViewById(R.id.editText_descripcionGet);
        addButton = findViewById(R.id.btn_add);



    }

    public void insertarBase(View view){
        if(name.getText().toString()==" "){
            Toast.makeText(AddProduct.this,"Ingrese un nombre del producto",Toast.LENGTH_SHORT).show();

        }else{
            if(description.getText().toString() == " "){
                Toast.makeText(AddProduct.this,"Ingrese una descripcion",Toast.LENGTH_SHORT).show();
            }else{
                // Write a message to the database
                mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child(name.getText().toString()).child("Descripcion").setValue(description.getText().toString());


                AlertDialog alertDialog = new AlertDialog.Builder(AddProduct.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Producto guardado en la base de datos");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                name.setText("");
                                description.setText("");
                            }
                        });
                        alertDialog.show();
            }
        }
    }
}
