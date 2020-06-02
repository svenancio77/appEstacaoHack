package br.com.svenancio.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //1 - Populando e criando o adapter do spinner
        //Criando a lista de sexo do spinner

        val listaSexo =  arrayListOf("Selecione o sexo", "Feminino", "Masculino", "Outros")


        //2 - Adapter do spinner
        val sexoAdapter = ArrayAdapter(
            this@CadastroActivity,
            android.R.layout.simple_spinner_dropdown_item,
            listaSexo
        )

        // 3- Adicionando o adapter ao spinner
        spnSexo.adapter = sexoAdapter

        // Criar o clique do botão
        btnCadastro.setOnClickListener {

            //Recuperar os dados digitados

            val nome             = edtNome.text.toString().trim()
            val sobrenome        = edtSobrenome.text.toString().trim()
            val email            = edtEmail.text.toString().trim().toLowerCase()
            val senha            = edtSenha.text.toString().trim()
            val sexo             = spnSexo.selectedItem.toString()

            val mensagem         = "Campo obrigatório!"



            if(nome.isEmpty()){
                //apresentar o erro direto no componente
                edtNome.error = mensagem
                edtNome.requestFocus()

            }else if(sobrenome.isEmpty()){
                edtSobrenome.error = mensagem
                edtSobrenome.requestFocus()

            }else if(email.isEmpty()){
                edtEmail.error = mensagem
                edtEmail.requestFocus()

            }else if(senha.isEmpty()){
                edtSenha.error = mensagem
                edtSenha.requestFocus()

            }else if(sexo == "Selecione o sexo"){
                //apresenta msg ao usuario
                Toast.makeText(this@CadastroActivity, mensagem, Toast.LENGTH_LONG).show()

            }else{
                //gravar as informações no SharedPreferences
                getSharedPreferences("cadastro-$email", Context.MODE_APPEND).edit().apply {
                    putString("nome", nome)
                    putString("sobrenome", sobrenome)
                    putString("email", email)
                    putString("senha", senha)
                    putString("sexo", sexo)

                }.apply()

                //abrir a tela main
                val abrirTelaMain = Intent(this@CadastroActivity, MainActivity::class.java)

                //passagem de parametro via Intent
                abrirTelaMain.putExtra("email", email)

                //executando a Intent
                startActivity(abrirTelaMain)


                //apresenta msg ao usuario
                Toast.makeText(this@CadastroActivity, "Usuário Cadastrado!", Toast.LENGTH_LONG).show()


                //tirar as telas do empilhamento
                finishAffinity()

            }


        }

    }

}
