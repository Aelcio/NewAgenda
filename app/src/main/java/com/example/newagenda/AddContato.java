package com.example.newagenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddContato extends AppCompatActivity {
    private Button Salvar, Cancelar;
    private EditText Nome, Endereco, Telefone1, Telefone2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contato);
        setTitle("Agenda de Contatos");

        Salvar    = (Button) findViewById(R.id.btnSalvar);
        Cancelar  = (Button) findViewById(R.id.btnCancelar);
        Nome      = (EditText) findViewById(R.id.edNome);
        Endereco  = (EditText) findViewById(R.id.edEndereco);
        Telefone1 = (EditText) findViewById(R.id.edTelefone1);
        Telefone2 = (EditText) findViewById(R.id.edTelefone2);

        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enviarContato();
            }
        });

        Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelarContato();
            }
        });
    }

    private boolean verificarCampos(){
        if((Nome.getText().toString().length() > 0 ) &&
          (Endereco.getText().toString().length() > 0 ) &&
          (Telefone1.getText().toString().length() > 0 ) &&
          (Telefone2.getText().toString().length() > 0 ))
          return true;
        else{
            Toast.makeText(this, "Favor, preencher todos os campos!", Toast.LENGTH_LONG).show();
            return false;
        }
   }

    private void enviarContato() {
        if (verificarCampos()) {
            Bundle bundle = new Bundle();
            bundle.putString("nome", Nome.getText().toString());
            bundle.putString("endereco", Endereco.getText().toString());
            bundle.putString("telefone1", Telefone1.getText().toString());
            bundle.putString("telefone2", Telefone2.getText().toString());
            Intent intent = new Intent();
            intent.putExtras(bundle);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    private void cancelarContato(){
        setResult(RESULT_CANCELED);
        finish();
    }
}

