package br.com.svenancio.estacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)


        //habilitar o JS
        wbvSite.settings.javaScriptEnabled = true

        //URL que será aberta
        wbvSite.loadUrl("http://br.cellep.com/estacaohack")

        //Abrir qq site local - app e não no navegador
        wbvSite.webViewClient = WebViewClient()
    }
}
