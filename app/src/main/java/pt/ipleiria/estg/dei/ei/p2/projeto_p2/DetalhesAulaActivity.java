package pt.ipleiria.estg.dei.ei.p2.projeto_p2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo.Aula;
import pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo.GestorSemanaAulas;

public class DetalhesAulaActivity extends AppCompatActivity {
    private ListView listViewAlunos;
    public static final String INDICE_AULA = "INDICE_AULA";
    private int indiceAula;
    private Aula aula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Trabalho Laboratorial");
        setContentView(R.layout.activity_detalhes_aula);

        indiceAula = getIntent().getIntExtra(INDICE_AULA, -1);

        aula = GestorSemanaAulas.INSTANCIA.getAula(indiceAula);


        TextView textViewNome = findViewById(R.id.textViewNome);
        TextView textViewNumero = findViewById(R.id.textViewNumero);
        TextView textViewAula = findViewById(R.id.textViewAula);
        TextView textViewProfessor = findViewById(R.id.textViewProfessor);
        TextView textViewSala = findViewById(R.id.textViewSala);
        TextView textViewAlunos = findViewById(R.id.textViewAlunos);

        listViewAlunos = findViewById(R.id.listViewAlunos);

        textViewNome.setText(aula.getNome());
        textViewNumero.setText(Long.toString(aula.getNumero()));
        textViewSala.setText(aula.getSala().getNome());
        textViewAula.setText(aula.getHorario().toString());
        textViewProfessor.setText("Professor: "+aula.getProfessor().getNome());
        textViewAlunos.setText("Alunos:");

        listViewAlunos = findViewById(R.id.listViewAlunos);

        atualizarListaAlunos();

    }

    private void atualizarListaAlunos() {
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, aula.getAlunos());

        listViewAlunos.setAdapter(listAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
      getMenuInflater().inflate(R.menu.menu_adicionar_aluno, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.itemAdicionarAluno){
            startActivityForResult(AdicionarAlunoActivity.createIntent(DetalhesAulaActivity.this, indiceAula), 0);
            return true;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0){
            if(resultCode == RESULT_OK){
                atualizarListaAlunos();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


    public static Intent createIntent(Context context, int indiceAula){
        Intent intent = new Intent(context, DetalhesAulaActivity.class);
        intent.putExtra(INDICE_AULA, indiceAula);
        return intent;
    }
}
