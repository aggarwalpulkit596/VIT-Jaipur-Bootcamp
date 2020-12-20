package com.puldroid.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    button.setOnClickListener {
      val email = editTextTextPersonName.text.toString()
      val intent = Intent()
      intent.action = Intent.ACTION_SENDTO
      intent.data = Uri.parse("mailto:$email")
      startActivity(intent)
    }
    button2.setOnClickListener {
      val address = editTextTextPersonName.text.toString()
      val intent = Intent()
      intent.action = Intent.ACTION_VIEW
      intent.data = Uri.parse("https://$address")
      startActivity(intent)
    }
    button3.setOnClickListener {
      val mobile = editTextTextPersonName.text.toString()
      val intent = Intent()
      intent.action = Intent.ACTION_DIAL
      intent.data = Uri.parse("tel:$mobile")
      startActivity(intent)
    }

    getImageBtn.setOnClickListener {
      val intent = Intent()
      intent.setType("image/*")
      intent.action = Intent.ACTION_GET_CONTENT
      startActivityForResult(Intent.createChooser(intent, "Choose Picture"), 100)
    }

  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    imageView2.setImageURI(data?.data)
  }
}