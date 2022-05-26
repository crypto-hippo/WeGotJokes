package com.example.wegotjokes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class JokeActivity : AppCompatActivity() {

    var jokes = arrayOf("Joke 1", "Joke 2", "Joke 3", "Joke 4", "Joke 5")
    var favorite_joke_indexes = ArrayList<Int>()
    var current_fav_index = 0
    var current_joke_index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        val go_back = findViewById<TextView>(R.id.go_back)
        go_back.setOnClickListener {
            val intent = Intent(this@JokeActivity, MainActivity::class.java)
            startActivity(intent)
        }

        // init ui to the first joke
        val current_joke_element = findViewById<TextView>(R.id.current_joke)
        current_joke_element.text = jokes.get(current_joke_index)

        // get the action buttons for next joke and mark _favorite, and set their onclicks
        val btn_mark_fav = findViewById<Button>(R.id.btn_mark_fav)
        val btn_next_joke = findViewById<Button>(R.id.btn_next_joke)
        val btn_next_fav = findViewById<Button>(R.id.btn_next_fav)

        btn_mark_fav.setOnClickListener {
            if (favorite_joke_indexes.contains(current_joke_index)) {
                // do nothing, already exists, use set here
            } else {
                // add to favorites
                favorite_joke_indexes.add(current_joke_index)
            }
        }

        btn_next_joke.setOnClickListener {
            if (current_joke_index == jokes.size - 1) {
                current_joke_index = 0
            } else {
                current_joke_index++
            }
            current_joke_element.text = jokes.get(current_joke_index)
        }

        btn_next_fav.setOnClickListener {
            if (favorite_joke_indexes.size == 0) {
                // do nothing no favorites
            } else {
                if (current_fav_index == favorite_joke_indexes.size - 1) {
                    current_fav_index = 0
                } else {
                    current_fav_index++
                }
                current_joke_element.text = jokes.get(favorite_joke_indexes.get(current_fav_index))
            }
        }
    }
}