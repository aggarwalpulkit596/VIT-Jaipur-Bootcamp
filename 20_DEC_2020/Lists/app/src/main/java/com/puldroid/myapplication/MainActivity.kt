package com.puldroid.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  var items = arrayOf<String>() // or Use a ArrayList
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    button.setOnClickListener {
      val item = inputEd.text.toString()
      items.plus(item)
      listView.adapter = ArrayAdapter(
        this@MainActivity, android.R.layout.simple_list_item_1, items
      )
      Log.d("this is a log", "this is size" + items.size)
    }
  }
}