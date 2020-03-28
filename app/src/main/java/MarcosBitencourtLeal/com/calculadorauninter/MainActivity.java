package MarcosBitencourtLeal.com.calculadorauninter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaração dos Numeros
    private TextView zero;
    private TextView um;
    private TextView dois;
    private TextView tres;
    private TextView quatro;
    private TextView cinco;
    private TextView seis;
    private TextView sete;
    private TextView oito;
    private TextView nove;

    //Declaração das operações
    private TextView adicao; //add
    private TextView subtracao; //sub
    private TextView multicacao; //mul
    private TextView divisao; //div
    private TextView igual;
    private TextView limpar;


    //Declaração das telas
    private TextView resultado; //info
    private TextView expressao; // result

    //Declaração das funções da Calc
    private final char ADICAO = '+';
    private final char SUBTRACAO = '-';
    private final char MULTIPLICACAO = '*';
    private final char DIVISAO = '/';
    private final char IGUAL = 0;



    private double val1 = Double.NaN;
    private double val2;
    private char ACAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        //Função para quando se clicar em determinado numero o mesmo aparece na tela expressao
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                resultado.setText(resultado.getText().toString() + "0" );
            }
        });

        um.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                resultado.setText(resultado.getText().toString() + "1" );
            }
        });

        dois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                resultado.setText(resultado.getText().toString() + "2" );
            }
        });

        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                resultado.setText(resultado.getText().toString() + "3" );
            }
        });

        quatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                resultado.setText(resultado.getText().toString() + "4" );
            }
        });

        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                resultado.setText(resultado.getText().toString() + "5" );
            }
        });

        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                resultado.setText(resultado.getText().toString() + "6" );
            }
        });

        sete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                resultado.setText(resultado.getText().toString() + "7" );
            }
        });

        oito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                resultado.setText(resultado.getText().toString() + "8" );
            }
        });

        nove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                resultado.setText(resultado.getText().toString() + "9" );
            }
        });


        subtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                computar();
                ACAO=SUBTRACAO;
                expressao.setText(String.valueOf(val1) + "-");
                resultado.setText(null);

            }
        });

        adicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                computar();
                ACAO=ADICAO;
                expressao.setText(String.valueOf(val1) + "+");
                resultado.setText(null);

            }
        });

        multicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                computar();
                ACAO=MULTIPLICACAO;
                expressao.setText(String.valueOf(val1) + "*");
                resultado.setText(null);

            }
        });

        divisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                computar();
                ACAO=DIVISAO;
                expressao.setText(String.valueOf(val1) + "/");
                resultado.setText(null);

            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computar();
                ACAO= IGUAL;
                expressao.setText(expressao.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                resultado.setText(null);
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resultado.getText().length() > 0){
                    CharSequence name = resultado.getText().toString();
                    resultado.setText(name.subSequence(0,name.length() -1));
                }
                else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    resultado.setText(null);
                    expressao.setText(null);
                }
            }
        });

    }

    //Associação dos botões com os Id's
    private void setupUIViews(){
        zero = (TextView) findViewById(R.id.Zero);
        um = (TextView) findViewById(R.id.Um);
        dois = (TextView) findViewById(R.id.Dois);
        tres =(TextView) findViewById(R.id.Tres);
        quatro = (TextView) findViewById(R.id.Quatro);
        cinco = (TextView) findViewById(R.id.Cinco);
        seis = (TextView) findViewById(R.id.Seis);
        sete = (TextView) findViewById(R.id.Sete);
        oito = (TextView) findViewById(R.id.Oito);
        nove = (TextView) findViewById(R.id.Nove);
        adicao = (TextView) findViewById(R.id.Adicao);
        subtracao = (TextView) findViewById(R.id.Subtracao);
        multicacao = (TextView) findViewById(R.id.Multiplicacao);
        divisao = (TextView) findViewById(R.id.Divisao);
        igual = (TextView) findViewById(R.id.Igual);
        resultado = (TextView) findViewById(R.id.Resultado);
        expressao = (TextView) findViewById(R.id.Expressao);
        limpar = (TextView) findViewById(R.id.Limpar);
    }

    private void computar(){ // funcao
        if(!Double.isNaN(val1)){
            val2 =Double.parseDouble( resultado.getText().toString());//Conversao

            switch (ACAO){ // Switch para cada (ACAO)  operação especifica
                case ADICAO:
                    val1 = val1+val2;
                    break;
                case SUBTRACAO:
                    val1 = val1-val2;
                    break;
                case MULTIPLICACAO:
                    val1 = val1*val2;
                    break;
                case DIVISAO:
                    val1 = val1/val2;
                    break;
                case IGUAL:
                    break;
            }
        }
        else {
            val1 =Double.parseDouble( resultado.getText().toString());
        }
    }
}
