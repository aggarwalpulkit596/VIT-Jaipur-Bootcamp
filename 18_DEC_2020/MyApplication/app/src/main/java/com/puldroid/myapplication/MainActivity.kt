package com.puldroid.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    pressMeBtn.setOnClickListener {
      Toast.makeText(this, "This is button press with a toast", Toast.LENGTH_LONG).show()
      val p: Int = editText1.text.toString().toInt()
      val r: Int = editText2.text.toString().toInt()
      val n: Int = editText3.text.toString().toInt()
      //EMI = P × r × (1 + r)n/((1 + r)n - 1)
      // where P= Loan amount, r= interest rate, n=tenure in number of months.
    val emi = (p * r * ((1 + r).toDouble().pow(n.toDouble()))/ ((1 + r) * (n - 1)))
      displayTv.text = "The emi is $emi"

    }
  }
}