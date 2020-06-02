package br.com.svenancio.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //capturar o e-mail enviado pela Intent
        val email = intent.getStringExtra("email")

        //abrindo o SharedPreference
        val minhaPreferencia = getSharedPreferences("cadastro-$email", Context.MODE_PRIVATE)

        txtNomeUsuario.text = minhaPreferencia.getString("nome", "Erro Shared")
        txtEmailUsuario.text = minhaPreferencia.getString("email", "Erro Shared")
        txtSexoUsuario.text = minhaPreferencia.getString("sexo", "Erro Shared")


        //clique do botão SAIR
        btnSair.setOnClickListener {

            //abri a tela Login
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))


            //tirar a tela do empilhamento
            finish()
        }

        //clique o botão SITE
        btnSiteCellep.setOnClickListener {

            //abrir a tela web
            startActivity(Intent(this@MainActivity, WebActivity::class.java))
        }

    }
}
