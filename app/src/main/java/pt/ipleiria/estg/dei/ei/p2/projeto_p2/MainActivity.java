package pt.ipleiria.estg.dei.ei.p2.projeto_p2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo.GestorSemanaAulas;


public class MainActivity extends AppCompatActivity {
    private ListView listViewAulas;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Trabalho Laboratorial");

     listViewAulas = findViewById(R.id.listViewAulas);
     listViewAulas.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, GestorSemanaAulas.INSTANCIA.getAulas()));
     listViewAulas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


             startActivity(DetalhesAulaActivity.createIntent(MainActivity.this, position));
         }
     });
    }


}
