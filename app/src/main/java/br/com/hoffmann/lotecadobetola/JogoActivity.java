package br.com.hoffmann.lotecadobetola;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.hoffmann.lotecadobetola.response.ApostasUsuario;

public class JogoActivity extends AppCompatActivity {

    private final Long VALOR_APOSTA_UNICA = 4L;
    private TextView valorTotalAposta;
    private Button finalizarApostas, botaoApostar, um, dois, tres, quatro, cinco, seis, sete,
                   oito, nove, dez, onze, doze, treze, quatorze,
                   quinze, dezessis, dezessete, dezoito, dezenove, vinte, vinte1,
                   vinte2, vinte3, vinte4, vinte5, vinte6, vinte7, vinte8,
                   vinte9, trinta, trinta1, trinta2, trinta3, trinta4, trinta5,
                   trinta6, trinta7, trinta8, trinta9, quarenta, quarenta1, quarenta2;

    List<Long> cartelaDeApostas = new ArrayList<>();
    List<ApostasUsuario> cartelaDeApostasFinal;
    private RequestQueue queue;
    private String email, token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        Objects.requireNonNull(getSupportActionBar()).hide();

        iniciarComponentes();
        CarregaOsComponentes();

        botaoApostar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long[] mapper = {
                        cartelaDeApostas.get(0),
                        cartelaDeApostas.get(1),
                        cartelaDeApostas.get(2),
                        cartelaDeApostas.get(3),
                        cartelaDeApostas.get(4),
                        cartelaDeApostas.get(5),
                        cartelaDeApostas.get(6),
                        cartelaDeApostas.get(7),
                        cartelaDeApostas.get(8),
                        cartelaDeApostas.get(9),
                };
                cartelaDeApostasFinal.add(new ApostasUsuario(mapper));

                Intent refresh = new Intent(JogoActivity.this, JogoActivity.class);
                refresh.putExtra("email", getIntent().getExtras().getString("email"));
                refresh.putExtra("token", getIntent().getExtras().getString("token"));
                refresh.putExtra("cartelaDeApostasFinal", (Serializable) cartelaDeApostasFinal);
                finish();
                overridePendingTransition(0, 0);
                startActivity(refresh);
                overridePendingTransition(0, 0);
            }
        });

        finalizarApostas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long[] mapper = {
                        cartelaDeApostas.get(0),
                        cartelaDeApostas.get(1),
                        cartelaDeApostas.get(2),
                        cartelaDeApostas.get(3),
                        cartelaDeApostas.get(4),
                        cartelaDeApostas.get(5),
                        cartelaDeApostas.get(6),
                        cartelaDeApostas.get(7),
                        cartelaDeApostas.get(8),
                        cartelaDeApostas.get(9),
                };
                cartelaDeApostasFinal.add(new ApostasUsuario(mapper));

                Intent intent = new Intent(JogoActivity.this, ListaDeApostas.class);
                intent.putExtra("email", getIntent().getExtras().getString("email"));
                intent.putExtra("token", getIntent().getExtras().getString("token"));
                Bundle bundle = new Bundle();
                bundle.putSerializable("cartelaDeApostasFinal", (Serializable) cartelaDeApostasFinal);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void validaTamanhoDaAposta(long l, Button button) {
            if (cartelaDeApostas.size() == 10L) {
                Toast.makeText(this, "JA SELECIONOU TODOS OS NUMEROS", Toast.LENGTH_SHORT).show();
                button.setClickable(false);
            } else {
                checaBotao(button);
                cartelaDeApostas.add(l);
            }
    }

    @Override
    protected void onStart() {
        super.onStart();
        token = getIntent().getExtras().getString("token");
        email = getIntent().getExtras().getString("email");
        cartelaDeApostasFinal = (List<ApostasUsuario>) getIntent().getExtras().getSerializable("cartelaDeApostasFinal");

        if (cartelaDeApostasFinal == null) {
            cartelaDeApostasFinal = new ArrayList<>();
        }

        Long total = VALOR_APOSTA_UNICA * cartelaDeApostasFinal.size();
        valorTotalAposta.setText("R$ " + total + ",00");
    }


    private void CarregaOsComponentes(){
        um.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(1L, um);}});

        dois.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(2L, dois);}});

        tres.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(3L, tres);}});

        quatro.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(4L, quatro);}});

        cinco.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(5L, cinco);}});

        seis.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(6L, seis);}});

        sete.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(7L, sete);}});

        oito.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(8L, oito);}});

        nove.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(9L, nove);}});

        dez.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(10L, dez);}});

        onze.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(11L, onze);}});

        doze.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(12L, doze);}});

        treze.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(13L, treze);}});

        quatorze.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(14L, quatorze);}});

        quinze.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(15L, quinze);}});

        dezessis.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(16L, dezessis);}});

        dezessete.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(17L, dezessete);}});

        dezoito.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(18L, dezoito);}});

        dezenove.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(19L, dezenove);}});

        vinte.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(20L, vinte);}});

        vinte1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(21L, vinte1);}});

        vinte2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(22L, vinte2);}});

        vinte3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(23L, vinte3);}});

        vinte4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(24L, vinte4);}});

        vinte5.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(25L, vinte5);}});

        vinte6.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(26L, vinte6);}});

        vinte7.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(27L, vinte7);}});

        vinte8.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(28L, vinte8);}});

        vinte9.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(29L, vinte9);}});

        trinta.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(30L, trinta);}});

        trinta1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(31L, trinta1);}});

        trinta2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(32L, trinta2);}});

        trinta3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(33L, trinta3);}});

        trinta4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(34L, trinta4);}});

        trinta5.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(35L, trinta5);}});

        trinta6.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(36L, trinta6);}});

        trinta7.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(37L, trinta7);}});

        trinta8.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(38L, trinta8);}});

        trinta9.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(39L, trinta9);}});

        quarenta.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(40L, quarenta);}});

        quarenta1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(41L, quarenta1);}});

        quarenta2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                validaTamanhoDaAposta(42L, quarenta2);}});
    }

    private void checaBotao(Button button) {
            button.setClickable(false);
            button.setBackgroundColor(1);
            button.setTextColor(getApplication().getResources().getColor(R.color.black));
            button.setTextSize(16);
    }

    private void iniciarComponentes() {
        valorTotalAposta = findViewById(R.id.valor_total_aposta);
        botaoApostar = findViewById(R.id.botao_apostar);
        finalizarApostas = findViewById(R.id.botao_finalizar_apostas);
        queue = Volley.newRequestQueue(JogoActivity.this);
        um = findViewById(R.id.button1);
        dois = findViewById(R.id.button2);
        tres = findViewById(R.id.button3);
        quatro = findViewById(R.id.button4);
        cinco = findViewById(R.id.button5);
        seis = findViewById(R.id.button6);
        sete = findViewById(R.id.button7);
        oito = findViewById(R.id.button8);
        nove = findViewById(R.id.button9);
        dez = findViewById(R.id.button10);
        onze = findViewById(R.id.button11);
        doze = findViewById(R.id.button12);
        treze = findViewById(R.id.button13);
        quatorze = findViewById(R.id.button14);
        quinze = findViewById(R.id.button15);
        dezessis = findViewById(R.id.button16);
        dezessete = findViewById(R.id.button17);
        dezoito = findViewById(R.id.button18);
        dezenove = findViewById(R.id.button19);
        vinte = findViewById(R.id.button20);
        vinte1 = findViewById(R.id.button21);
        vinte2 = findViewById(R.id.button22);
        vinte3 = findViewById(R.id.button23);
        vinte4 = findViewById(R.id.button24);
        vinte5 = findViewById(R.id.button25);
        vinte6 = findViewById(R.id.button26);
        vinte7 = findViewById(R.id.button27);
        vinte8 = findViewById(R.id.button28);
        vinte9 = findViewById(R.id.button29);
        trinta = findViewById(R.id.button30);
        trinta1 = findViewById(R.id.button31);
        trinta2 = findViewById(R.id.button32);
        trinta3 = findViewById(R.id.button33);
        trinta4 = findViewById(R.id.button34);
        trinta5 = findViewById(R.id.button35);
        trinta6 = findViewById(R.id.button36);
        trinta7 = findViewById(R.id.button37);
        trinta8 = findViewById(R.id.button38);
        trinta9 = findViewById(R.id.button39);
        quarenta = findViewById(R.id.button40);
        quarenta1 = findViewById(R.id.button41);
        quarenta2 = findViewById(R.id.button42);
    }
}