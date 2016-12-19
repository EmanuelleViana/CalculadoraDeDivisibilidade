package com.discreta.emanuelle.teoriadosnumeros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class TeoriaNumerosActivity extends AppCompatActivity {

    private EditText e1;
    private  EditText e2;
    private  EditText e3;
    private TextView resp;
    private Button divisao,mdc,mmc,combinacao,equacao,solucoes;
    private  int a,b,c;
    private String txt1,txt2,txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.tela_dois_numeros);

        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);

        resp = (TextView) findViewById(R.id.resultTextView);
        divisao = (Button) findViewById(R.id.button5);
        mdc = (Button) findViewById(R.id.button3);
        mmc = (Button) findViewById(R.id.button4);
        combinacao = (Button) findViewById(R.id.button6);
        equacao = (Button) findViewById(R.id.button7);
        solucoes = (Button) findViewById(R.id.button8);


      e3.setEnabled(false);


        fazerOperacoes();
    }
    /* Operacoes para cada botao clicado.
        */
    private void fazerOperacoes() {
      divisao.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            txt1 = e1.getText().toString();
            txt2 = e2.getText().toString();
            e3.setEnabled(false);

            if (txt1.equals("") || txt2.equals("")) {
                resp.setText("");
            } else {
                a = Integer.parseInt(txt1);
                b = Integer.parseInt(txt2);

                int quoc = Operacoes.getQuociente(a, b);
                int rest = Operacoes.getResto(a, b);
                String str = "Quociente: " + quoc + "\nResto: " + rest + "\n\n" + a + " = " + b + " * (" + quoc + ") + " + rest;
                resp.setText(str);
            }
        }
    });

    mdc.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            txt1 = e1.getText().toString();
            txt2 = e2.getText().toString();
            e3.setEnabled(false);

            if (txt1.equals("") || txt2.equals("")) {
                resp.setText("");
            } else {
                a = Integer.parseInt(txt1);
                b = Integer.parseInt(txt2);
                String str = "\nMDC ( " + a + " , " + b + " )" + " = " + Operacoes.calculaMDC(a, b);
                ;
                resp.setText(str);
            }
        }
    });

    mmc.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            String txt1 = e1.getText().toString();
            String txt2 = e2.getText().toString();
            e3.setEnabled(false);

            if (txt1.equals("") || txt2.equals("")) {
                resp.setText("");
            } else {
                a = Integer.parseInt(txt1);
                b = Integer.parseInt(txt2);
                String str = "\nMMC ( " + a + " , " + b + " )" + " = " + Operacoes.calculaMMC(a, b);
                resp.setText(str);
            }
        }
    });
    combinacao.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = null;

            txt1 = e1.getText().toString();
            txt2 = e2.getText().toString();
            e3.setEnabled(false);

            if (txt1.equals("") || txt2.equals("")) {
                resp.setText("");
            } else {
                a = Integer.parseInt(txt1);
                b = Integer.parseInt(txt2);
                try {
                    str = a + "x+" + b + "y = " + Operacoes.calculaMDC(a, b) + "\n\nx: " + Operacoes.combinacaoLinear(a, b)[0] + "\t\ty: " + Operacoes.combinacaoLinear(a, b)[1];
                } catch (Exception e) {
                    e.printStackTrace();
                }
                resp.setText(str);
            }
        }
    });


    equacao.setOnClickListener(new OnClickListener() {

        String str = null;

        @Override
        public void onClick(View v) {
            txt1 = e1.getText().toString();
            txt2 = e2.getText().toString();
            txt3 = e3.getText().toString();
         //  e3.setFocusableInTouchMode(true);
               e3.setEnabled(true);

            if (txt1.equals("") || txt2.equals("") || txt3.equals("")) {
                resp.setText("");
            } else {
                a = Integer.parseInt(txt1);
                b = Integer.parseInt(txt2);
                c = Integer.parseInt(txt3);

                try {
                    str = a + "x+" + b + "y = " + c ;
                } catch (Exception e) {
                    e.printStackTrace();
                }



                if(Operacoes.hasSolutions(a,b,c)) {
                /*  for (String iterar : Operacoes.equacaoDiofantinaAll2(a, b, c)) {
                       if (iterar != null) {
                           str += "\n" + iterar;
                       }
                   }*/
                   int i ;

                    for(i = 0; i < Operacoes.equacaoDiofantinaAll(a,b,c).size();i++){
                       str +="\n" + Operacoes.equacaoDiofantinaAll(a,b,c).get(i);
                    }
                }
                else {
                    str += "\n" + "A equação não tem soluções porque MDC(" + a + "," + b +") não divide " + c;
                }

                resp.setText(str);
            }
        }

    });


    solucoes.setOnClickListener(new OnClickListener() {
    String str = null;
    @Override
    public void onClick(View v) {
        txt1 = e1.getText().toString();
        txt2 = e2.getText().toString();
        txt3 = e3.getText().toString();
      //  e3.setFocusableInTouchMode(true);
        e3.setEnabled(true);

       if (txt1.equals("") || txt2.equals("") || txt3.equals("") ) {
            resp.setText("");
        } else {
      //     e3.setEnabled(true);

           a = Integer.parseInt(txt1);
            b = Integer.parseInt(txt2);
            c = Integer.parseInt(txt3);

            try {
                str = a + "x+" + b + "y = " + c ;
            } catch (Exception e) {
                e.printStackTrace();
            }
            String tm="";
            boolean empty = false;

            if(Operacoes.hasSolutions(a,b,c)) {
                for (String iterar : Operacoes.solucoesPositivas(a, b, c)) {

                    if (iterar != null) {
                        tm += "\n" + iterar;

                    }

                }
                str = str + tm;
            }
            else {
                str += "\n" + "A equação não tem soluções porque MDC(" + a + "," + b +") não divide " + c;
            }

          if (tm == ""){
                  str += "\n" + "A equação não tem soluções positivas.";

          }


            resp.setText(str);
        }

    }
});

}


    /* Iniciar outra activity.
     */
    public void startSecondActivity(View view) {

        Intent secondActivity = new Intent(this, TeoriaNumerosTresNActivity.class);
        startActivity(secondActivity);
    }

    /* Criar o menu.
         * @param item MenuItem opcao do menu.
         */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Acoes para cada opcao selecionada do menu.
     * @param item MenuItem opcao do menu.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.action_home:
                startFirstActivity();
                break;
            case R.id.action_ajuda:
                startAjudaActivity();
                break;
            case R.id.action_sobre:
                startSobreActivity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /* Iniciar activity de ajuda.
     */
    public void startAjudaActivity() {

        Intent secondActivity = new Intent(this, AjudaActivity.class);
        startActivity(secondActivity);
    }

    /* Iniciar activity Sobre.
       */
    public void startSobreActivity() {

        Intent secondActivity = new Intent(this, SobreActivity.class);
        startActivity(secondActivity);
    }

    /* Iniciar primeira activity ( para dois numeros).
     */
    public void startFirstActivity() {

        Intent secondActivity = new Intent(this, TeoriaNumerosActivity.class);
        startActivity(secondActivity);
    }
}
