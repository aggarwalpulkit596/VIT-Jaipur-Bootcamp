package com.puldroid.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

class MainActivity2 : AppCompatActivity() {

  val movies = arrayOf(
    "Iron Man", "Thor", "Captain America", "Doctor Strange", "Captain Marvel", "Black Panther"
  )
  val year = arrayOf("2008", "2010", "2011", "2016", "2019", "2018")
  val actors = arrayOf("RDJ", "Chris", "Chris Evans", "Benedict", "Brie", "Chadwick")
  val images = arrayOf(
    R.drawable.ironman,
    R.drawable.thor,
    R.drawable.captain,
    R.drawable.strange,
    R.drawable.marvel,
    R.drawable.panther
  )
  val list = arrayListOf<Movies>()
  private val onItemClicked = object : MovieItemClickListener {
    override fun onItemClick(movie: Movies) {
      Toast.makeText(this@MainActivity2, "$movie", Toast.LENGTH_SHORT).show()
    }

  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main2)
    for (i in 0..100) {
      val random = Random().nextInt(5)
      val movie = Movies(
        movies[random], year[random], actors[random], images[random]
      )
      list.add(movie)
    }
    val movieAdapter = MovieAdapter(list)
    movieAdapter.onItemClickListener = onItemClicked
//    val todoAdapter = TodoAdapter(list)
//    saveBtn.setOnClickListener {
//      val todo = input.editText?.text.toString()
//      list.add(todo)
//      todoAdapter.notifyDataSetChanged()
//    }
    moviesRv.apply {
      layoutManager = LinearLayoutManager(this@MainActivity2, RecyclerView.VERTICAL, false)
      adapter = movieAdapter

    }
  }
}

data class Movies(
  val name: String, val year: String, val actor: String, val image: Int
) : BaseModel()

open class BaseModel()
