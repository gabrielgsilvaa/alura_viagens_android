package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.dao.PacoteDAO;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";
    public static final String PACOTE = "pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APPBAR);

        configuraLista();
    }

    private void configuraLista() {
        ListView listaPacotes = findViewById(R.id.lista_pacotes_listview);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));

        listaPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Pacote pacoteSelecionado = pacotes.get(position);

                Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
                intent.putExtra(PACOTE, pacoteSelecionado);
                startActivity(intent);

            }
        });
    }

}
