package com.example.wegotjokes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_load_jokes = findViewById<Button>(R.id.btn_load_jokes);
        btn_load_jokes.setOnClickListener {
            val intent = Intent(this@MainActivity, JokeActivity::class.java)
            startActivity(intent);
        }
    }
}