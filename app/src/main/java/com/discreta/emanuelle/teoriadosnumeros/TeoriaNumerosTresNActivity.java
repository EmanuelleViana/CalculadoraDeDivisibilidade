package com.discreta.emanuelle.teoriadosnumeros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

/**
 * Created by Emanuelle.
 * Classe principal que gerencia a primeira tela para operacoes com dois numeros.
 */
public class TeoriaNumerosTresNActivity extends AppCompatActivity {

    private EditText e1,e2,e3;
    private TextView resp;
    private Button  mdc, mmc, combinacao;
    private int a, b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_tres_numeros);


        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);

        resp = (TextView) findViewById(R.id.resultTextView);

        mdc = (Button) findViewById(R.id.mdc3);
        mmc = (Button) findViewById(R.id.mmc3);
        combinacao = (Button) findViewById(R.id.comb3);


       fazerOperacoes();

    }
    /* Operacoes para cada botao clicado.
     */
    private void fazerOperacoes(){
        mdc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt1 = e1.getText().toString();
                String txt2 = e2.getText().toString();
                String txt3 = e3.getText().toString();

                if(txt1.equals("") || txt2.equals("") || txt3.equals("")) {
                    resp.setText("");
                }
                else {
                    a = Integer.parseInt(txt1);
                    b = Integer.parseInt(txt2);
                    c = Integer.parseInt(txt3);

                    String str = "\nMDC (" + a + "," + b + ","+ c+")" + " = " + Operacoes.calculaMDC(a, b,c);
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
                String txt3 = e3.getText().toString();

                if(txt1.equals("") || txt2.equals("") || txt3.equals("")) {
                    resp.setText("");
                }
                else {
                    a = Integer.parseInt(txt1);
                    b = Integer.parseInt(txt2);
                    c = Integer.parseInt(txt3);
                    String str = "\nMMC (" + a + "," + b + ","+ c+")" + " = " + Operacoes.calculaMMC(a, b,c);
                    resp.setText(str);
                }
            }
        });
        combinacao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = null;

                String txt1 = e1.getText().toString();
                String txt2 = e2.getText().toString();
                String txt3 = e3.getText().toString();

                if(txt1.equals("") || txt2.equals("") || txt3.equals("")) {
                    resp.setText("");
                } else {
                    a = Integer.parseInt(txt1);
                    b = Integer.parseInt(txt2);
                    c = Integer.parseInt(txt3);
                    try {
                        str = a + "x+" + b + "y+"+c+"z = " + Operacoes.calculaMDC(a, b,c) + "\n\nx: " + Operacoes.combinacaoLinear(a, b,c)[0] + "\t\ty: " + Operacoes.combinacaoLinear(a, b,c)[1] + "\n\nz: " + Operacoes.combinacaoLinear(a, b,c)[2];
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    resp.setText(str);
                }
            }
        });

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


    /* Iniciar primeira activity ( para dois numeros).
   */
    public void startFirstActivity(View view) {

        Intent secondActivity = new Intent(this, TeoriaNumerosActivity.class);
        startActivity(secondActivity);
    }

}