package devandroid.heero.applistacurso.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import devandroid.heero.applistacurso.R;
import devandroid.heero.applistacurso.controller.PessoaController;
import devandroid.heero.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {


    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";
    Pessoa pessoa;

    PessoaController pessoaController;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editCurso;
    EditText editTelefone;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES ,0);
        SharedPreferences.Editor listaVip = preferences.edit();

        pessoaController = new PessoaController();

        pessoa = new Pessoa();

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCurso = findViewById(R.id.editCurso);
        editTelefone = findViewById(R.id.editTelefone);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editCurso.setText(pessoa.getCursoDesejado());
        editTelefone.setText(pessoa.getTelefoneContato());

        btnLimpar.setOnClickListener(v -> {
            editPrimeiroNome.setText("");
            editSobrenome.setText("");
            editCurso.setText("");
            editTelefone.setText("");
        });

        btnFinalizar.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
            finish();
        });

        btnSalvar.setOnClickListener(v -> {
            pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
            pessoa.setSobrenome(editSobrenome.getText().toString());
            pessoa.setCursoDesejado(editCurso.getText().toString());
            pessoa.setTelefoneContato(editTelefone.getText().toString());

            listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
            listaVip.putString("sobrenome", pessoa.getSobrenome());
            listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
            listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
            listaVip.apply();

            pessoaController.salvar(pessoa);

            Toast.makeText(MainActivity.this, "Salvo", Toast.LENGTH_LONG).show();
        });
    }
}