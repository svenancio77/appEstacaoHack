package br.com.svenancio.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Criando o clique do botao entrar
        btnEntrar.setOnClickListener {
            //Recuperando os valores digitados pelo usuário
            val usuario = edtUsuario.text.toString().trim()
            val senha = edtSenha.text.toString().trim()


            //Condicao para verificar se o usuario ou senha estao corretos
            if (usuario.isEmpty()) {
                //Apresentando um Toast para o usuário, mostrando que o campo usuario esta vazio
                Toast.makeText(this@LoginActivity, "Usuário vazio!", Toast.LENGTH_LONG).show()

            }else if (senha.isEmpty()) {
                //Campo senha vazia
                Toast.makeText(this@LoginActivity, "Senha vazia!", Toast.LENGTH_LONG).show()

            }else if (usuario == "Adm") {
                if (senha == "1234") {
                    Toast.makeText(this@LoginActivity, "Usuário logado com sucesso!", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))

                    //Tirar a tela do empilhamento
                    finish()

                }else{
                    Toast.makeText(this@LoginActivity, "Senha incorreta!", Toast.LENGTH_LONG).show()

                }
            }else{
                Toast.makeText(this@LoginActivity, "Usuário incorreto!", Toast.LENGTH_LONG).show()
            }
        }


        //Criando o click do botão CADASTRAR e abrir a tela de CADASTRO
        btnCadastrar.setOnClickListener {
            startActivity(Intent(this@LoginActivity, CadastroActivity::class.java))
            }
       }
  }