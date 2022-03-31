package com.example.myapplication.sample_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.motion.widget.MotionLayout
import com.example.myapplication.R

class MultipleConstraintSet : AppCompatActivity() {

    private var start = true
    private var startTwo = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_constraint_set)

        val motionLayout = findViewById<MotionLayout>(R.id.root)
        val buttonOne = findViewById<Button>(R.id.partOneBtn)
        val buttonTwo = findViewById<Button>(R.id.partTwoBtn)


        buttonOne.setOnClickListener {
            if (start) {
                motionLayout.transitionToState(R.id.mid, 3000)
            } else {
                motionLayout.transitionToState(R.id.start, 3000)
            }
            start = !start
        }


        buttonTwo.setOnClickListener {
            if (startTwo) {
                motionLayout.transitionToState(R.id.end, 1600)
            } else {
                motionLayout.transitionToState(R.id.mid, 1600)
            }
            startTwo = !startTwo
        }
    }
}