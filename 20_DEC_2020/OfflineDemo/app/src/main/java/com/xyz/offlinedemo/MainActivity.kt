package com.xyz.offlinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var myPreference: MyPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myPreference = MyPreference(this)

        lifecycleScope.launch {
            myPreference.name.collect {
                tvName.text = "$it is the best"
            }
        }

       btnSave.setOnClickListener {
           val name = etName.text.toString()
           if (name.isNotEmpty()){
               lifecycleScope.launch {
                   myPreference.setName(name)
               }

           }else{
               Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show()
           }
       }

    }
}