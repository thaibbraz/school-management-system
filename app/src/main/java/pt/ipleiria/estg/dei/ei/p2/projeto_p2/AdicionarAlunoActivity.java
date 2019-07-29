package pt.ipleiria.estg.dei.ei.p2.projeto_p2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo.Aluno;
import pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo.Aula;
import pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo.GestorSemanaAulas;

public class AdicionarAlunoActivity extends AppCompatActivity {
    private static final String INDICE_AULA = "INDICE_AULA";
    private EditText editTextNome;
    private EditText editTextNumero;
    private Aula aula;
    private int indiceAula;
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_aluno);

        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextNumero = (EditText) findViewById(R.id.editTextNumero);

        indiceAula = getIntent().getIntExtra(INDICE_AULA, -1);
        aula = GestorSemanaAulas.INSTANCIA.getAula(indiceAula);


    }
    public void onClickAdicionarAluno(View view){

        aluno = new Aluno(editTextNome.getText().toString(), Integer.parseInt(editTextNumero.getText().toString()));

        // Adicionar a aula ao aluno, ou o aluno a aula
        aula.adicionar(aluno);
        setResult(RESULT_OK);
        // Terminar actividade
        finish();
    }

    public static Intent createIntent(Context context, int indiceAula){
        Intent intent = new Intent(context, AdicionarAlunoActivity.class);
        intent.putExtra(INDICE_AULA, indiceAula);
        return intent;
    }
}
