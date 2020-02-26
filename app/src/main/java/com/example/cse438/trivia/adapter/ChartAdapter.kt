package com.example.cse438.trivia.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.trivia.R
import com.example.cse438.trivia.data.Track
import com.squareup.picasso.Picasso


//define the binding for the view holder
class ChartViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.question_item, parent, false)) {
    private val trackName: TextView
    private val trackImage: ImageView

    init {
        trackName = itemView.findViewById(R.id.track_name)
        trackImage = itemView.findViewById(R.id.track_image)

    }

    fun bind(track: Track) {
        trackName?.text = track.title
//        var choices: String = ""
//        for(item in question.incorrect_answers){
//            choices += item + ", "
//        }
//        choices += question.correct_answer

        Picasso.get().load(track.album.cover).into(trackImage)
    }

}


//define the adapter for the recycler view
class ChartAdapter(private val list: ArrayList<Track>)
    : RecyclerView.Adapter<ChartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ChartViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ChartViewHolder, position: Int) {
        val track: Track = list[position]
        holder.bind(track)
    }

    override fun getItemCount(): Int = list.size
}

