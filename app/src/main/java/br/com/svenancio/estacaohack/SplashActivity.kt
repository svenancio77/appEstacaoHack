package br.com.svenancio.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //funcAbrir() -> isso é uma chamada de função

        /*
        {} -> Bloco de programação / scopo de programação
        [] -> Lista, Coleção
        () -> Condição, Passagem de parametros ou Método construtor
        */


        //Função q apresenta o .xml para o usuário
        setContentView(R.layout.activity_splash)

        //Pausa na execução
        Handler().postDelayed({
            //Função Lambda

            //Abrindo a tela de Login
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))

            //Tirando a tela do empilhamento
            finish()

        },5000)
    }
}
