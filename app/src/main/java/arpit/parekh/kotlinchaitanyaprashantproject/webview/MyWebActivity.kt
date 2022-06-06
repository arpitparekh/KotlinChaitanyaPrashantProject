package arpit.parekh.kotlinchaitanyaprashantproject.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyWebBinding

class MyWebActivity : AppCompatActivity() {

    lateinit var binding : ActivityMyWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.loadUrl("https://www.firstpost.com/world/google-pays-tribute-to-espresso-machine-inventor-angelo-moriondo-with-special-doodle-10763441.html")

        binding.webView.webViewClient = WebViewClient()

    }

    override fun onBackPressed() {
//        super.onBackPressed()

        if(binding.webView.canGoBack()){

            binding.webView.goBack()

        }else{
            super.onBackPressed()
        }

    }
}