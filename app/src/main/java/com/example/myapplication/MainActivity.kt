package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.sampleCompose.ComposeActivity
import com.example.myapplication.sample_1.MoveObjectByClick
import com.example.myapplication.sample_2.AndroidIsTheStar
import com.example.myapplication.sample_3.MovingSun
import com.example.myapplication.sample_4.MovingSunNonLinear
import com.example.myapplication.sample_5.ChangeAttributes
import com.example.myapplication.sample_6.ChangeCustomAttributes
import com.example.myapplication.sample_7.ComplexMovingPath
import com.example.myapplication.sample_8.MultipleConstraintSet
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = MainAdapter(data)
    }
}

private val data = listOf(
    Sample(
        "Simple animation on Click events",
        "Object moves from start to end direction after clicking on it",
        MoveObjectByClick::class
    ),
    Sample(
        "Animations on Click event",
        "Multiple object moving based on their start to end destinations",
        AndroidIsTheStar::class
    ),
    Sample(
        "Simple moving sun",
        "Sun moves Linear direction and text appears",
        MovingSun::class
    ),
    Sample(
        "Moving sun with KeyFrame",
        "Sun moves non Linear direction using KeyFrame and text appears",
        MovingSunNonLinear::class
    ),
    Sample(
        "Moving sun with KeyAttribute",
        "Sun moves non Linear direction changing size and rotating using KeyAttribute",
        ChangeAttributes::class
    ),
    Sample(
        "Change color during Animation with Custom KeyAttribute",
        "During animation AndroidMan Changes his color late text appearance",
        ChangeCustomAttributes::class
    ),
    Sample(
        "Complex Moving Path multiple keyframe",
        "Sun moves with complex path by multiple key frame",
        ComplexMovingPath::class
    ),
    Sample(
        "Multiple ConstraintSets",
        "Sun moves with complex path by multiple key frame and after android man Will rise using multiple sets",
        MultipleConstraintSet::class
    ),
    Sample(
        "Compose sample",
        "Compose sample",
        ComposeActivity::class
    )
)

data class Sample(
    val title: String,
    val description: String,
    val activity: KClass<out Activity>,
)

class MainAdapter(val data: List<Sample>) : RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MainViewHolder(view as CardView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(data[position])
    }

}

class MainViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView) {
    private val description: TextView = cardView.findViewById(R.id.description)
    private val caption: TextView = cardView.findViewById(R.id.caption)

    fun bind(sample: Sample) {
        description.text = sample.title
        caption.text = sample.description
        val context = cardView.context
        cardView.setOnClickListener {
            val intent = Intent(context, sample.activity.java)
            context.startActivity(intent)
        }
    }
}