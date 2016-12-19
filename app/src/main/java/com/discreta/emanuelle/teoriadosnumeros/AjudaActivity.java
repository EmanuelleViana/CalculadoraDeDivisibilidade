package com.discreta.emanuelle.teoriadosnumeros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

/**
 * Created by Emanuelle on 25/05/2016.
 */
public class AjudaActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajuda);
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