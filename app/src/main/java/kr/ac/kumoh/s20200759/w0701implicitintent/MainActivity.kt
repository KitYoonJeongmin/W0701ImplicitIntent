package kr.ac.kumoh.s20200759.w0701implicitintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.ac.kumoh.s20200759.w0701implicitintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.btnHomepage.setOnClickListener {
            val uri = Uri.parse("https://velog.io/@jm450_")
            val intent = Intent(Intent.ACTION_VIEW, uri) //intent 만들기

            startActivity(intent) //만든 intent 실행
        }
        binding.btnMap.setOnClickListener {
            val uri = Uri.parse("geo:0, 0?z=17&q=창원시 마산합포구 월포동")
            val intent = Intent(Intent.ACTION_VIEW, uri) //intent 만들기

            startActivity(intent) //만든 intent 실행
        }
        binding.btnSms.setOnClickListener {
            val uri = Uri.parse("tel:010-9899-9405")
            val intent = Intent(Intent.ACTION_VIEW, uri) //intent 만들기
            if(intent.resolveActivity(packageManager) !== null){
                startActivity(intent)
            }

            else {
                Toast.makeText(this, "연결할 앱이 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}