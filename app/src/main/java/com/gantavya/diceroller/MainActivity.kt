package com.gantavya.diceroller

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity(), Parcelable {

    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // button2.setOnClickListener { rollDice() }
        setContentView(R.layout.activity_main)
        dice1.run {
            dice1.addAnimatorListener(object : AnimatorListener {
                override fun onAnimationStart(animation: Animator) {

                }

                override fun onAnimationEnd(animation: Animator) {
                    hideDice()
                    val random = (1..6).random()
                    textView.text = random.toString()
                }

                override fun onAnimationCancel(animation: Animator) {

                }

                override fun onAnimationRepeat(animation: Animator) {

                }

                })
        }
    }

    private fun rollDice(){Toast.makeText(this, "please wait",
            Toast.LENGTH_SHORT).show()}
    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    private fun showDice() {
        dice1.visibility=View.VISIBLE
        textView.visibility=View.GONE
        button2.isEnabled=false
    }

    private fun hideDice() {
        dice1.visibility=View.GONE
        textView.visibility=View.VISIBLE
        button2.isEnabled=true
    }

    fun onclick(view: View) {

        showDice()
        dice1.playAnimation()
    }

    fun gantubutton(view: View) {
        val url="http://gantavyamalviya.github.io"
        val i = Intent(Intent.ACTION_VIEW)
        i.data= Uri.parse(url)
        startActivity(i)
    }
    


}
