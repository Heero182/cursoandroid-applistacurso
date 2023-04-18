package devandroid.heero.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.heero.applistacurso.R;
import devandroid.heero.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Heider");
        pessoa.setSobrenome("Bernardes");
        pessoa.setCursoDesejado("Outro Curso");
        pessoa.setTelefoneContato("9999999999");
    }
}