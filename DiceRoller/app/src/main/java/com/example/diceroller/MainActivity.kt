package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var diceValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roll_button.setOnClickListener {
            rollDice()
        }

        count_up.setOnClickListener {

            countUp()
        }

        reset_btn.setOnClickListener {
            reset()
        }
    }


    private fun rollDice() {

        displayMessage("Button Clicked")
         diceValue = (1..6).random()
        updateDice(diceValue)

    }

     private fun updateDice(diceValue:Int){

         val drawableResource = when (diceValue) {
             1 -> R.drawable.dice_1
             2 -> R.drawable.dice_2
             3 -> R.drawable.dice_3
             4 -> R.drawable.dice_4
             5 -> R.drawable.dice_5
             else -> R.drawable.dice_6
         }
         dice_image.setImageResource(drawableResource)
     }

    private fun countUp() {

            if(diceValue == 6){
                displayMessage("Cannot Increase Number")
            } else{
                diceValue += 1
                updateDice(diceValue)
            }
    }

    private fun reset() {
        diceValue = 0
        dice_image.setImageResource(R.drawable.empty_dice)
    }

    private fun displayMessage(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT ).show()

    }
}
