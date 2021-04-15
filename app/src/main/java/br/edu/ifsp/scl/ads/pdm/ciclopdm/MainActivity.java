package br.edu.ifsp.scl.ads.pdm.ciclopdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.ifsp.scl.ads.pdm.ciclopdm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //Constante de filtro do LogCat
    private final String CICLO_PDM_TAG = "CICLO_PDM_TAG";

    //Constante de dados de instância
    private final String TELEFONE = "TELEFONE";

    private ActivityMainBinding activityMainBinding;

    //Views dinâmicas
    private TextView telefoneTv;
    private EditText telefoneEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        // Views dinâmicas
        telefoneTv = new TextView(this);
        telefoneTv.setText("Telefone");
        telefoneEt = new EditText(this);
        telefoneEt.setInputType(InputType.TYPE_CLASS_PHONE);

        //Adicionando Views dinâmicas ao Layout
        activityMainBinding.linearLayout.addView(telefoneTv);
        activityMainBinding.linearLayout.addView(telefoneEt);

        // Restaurando dados de instância antigos, se necessário
        /*if (savedInstanceState != null) {
            telefoneEt.setText(savedInstanceState.getString(TELEFONE, ""));
        }*/

        Log.v(CICLO_PDM_TAG, "onCreate: Iniciando ciclo COMPLETO");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //Salvando dados de instância
        outState.putString(TELEFONE, telefoneEt.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        telefoneEt.setText(savedInstanceState.getString(TELEFONE, ""));
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(CICLO_PDM_TAG, "onStart: Iniciando ciclo VISÍVEL");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(CICLO_PDM_TAG, "onResume: Iniciando ciclo PRIMEIRO PLANO");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(CICLO_PDM_TAG, "onPause: Finalizando ciclo PRIMEIRO PLANO");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(CICLO_PDM_TAG, "onStop: Finalizando ciclo VISÍVEL");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(CICLO_PDM_TAG, "onDestroy: Finalizando ciclo COMPLETO");
    }

    //Opcionamente
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(CICLO_PDM_TAG, "onRestart: Preparando para chamar onStart");
    }
}