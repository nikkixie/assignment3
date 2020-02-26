package com.example.cse438.trivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.trivia.adapter.ChartAdapter
import com.example.cse438.trivia.data.Track
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ChartViewModel

    var track_list: ArrayList<Track> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ChartViewModel::class.java)

        var chartadapter = ChartAdapter(track_list)
        recyclerView.adapter = chartadapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        viewModel!!.track_list.observe(this, Observer {
            track_list.clear()
            track_list.addAll(it.tracks.data)
            chartadapter.notifyDataSetChanged()
        })

        viewModel.getTracks("2")
//
//        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoryNames)
//        categorySpinner.adapter = adapter
//        viewModel!!.categoryList.observe(this, Observer {
//            categoryList.clear()
//            categoryList.addAll(it.trivia_categories)
//            categoryNames.clear()
//            for(c in categoryList) {
//                categoryNames.add(c.name)
//            }
//            adapter.notifyDataSetChanged()
//        })
//
//        viewModel.getCategories()

        search_button.setOnClickListener {
            val input: String = search_box.text.toString()
            viewModel!!.getTracks(input)

        }
    }


}
