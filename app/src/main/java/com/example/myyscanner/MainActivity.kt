package com.example.myyscanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.zxing.integration.android.IntentIntegrator
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val scanBtn = findViewById<Button>(R.id.btn_Scan)
        scanBtn.setOnClickListener(){
            val sc = IntentIntegrator(this)
            sc.initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if(result != null){
            val obj: JSONObject = JSONObject(result.contents)
            val strCode = obj.getString("name")
            findViewById<TextView>(R.id.textView_result).text = strCode
        }
    }
}