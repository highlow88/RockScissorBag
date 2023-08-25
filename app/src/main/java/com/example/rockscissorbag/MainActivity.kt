package com.example.rockscissorbag

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rockscissorbag.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var userChoice: String
    private lateinit var computerChoice: String
    private var userWins = 0
    private var computerWins = 0

    private lateinit var userChoiceTextView: TextView
    private lateinit var computerChoiceTextView: TextView
    private lateinit var resultTextView: TextView
    private lateinit var statsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userChoiceTextView = findViewById(R.id.userChoiceTextView)
        computerChoiceTextView = findViewById(R.id.computerChoiceTextView)
        resultTextView = findViewById(R.id.resultTextView)
        statsTextView = findViewById(R.id.statsTextView)

        val rockButton: Button = findViewById(R.id.rockButton)
        val paperButton: Button = findViewById(R.id.paperButton)
        val scissorsButton: Button = findViewById(R.id.scissorsButton)
        val playButton: Button = findViewById(R.id.playButton)

        rockButton.setOnClickListener { onChoiceSelected("rock") }
        paperButton.setOnClickListener { onChoiceSelected("paper") }
        scissorsButton.setOnClickListener { onChoiceSelected("scissors") }
        playButton.setOnClickListener { playMatch() }
    }

    private fun onChoiceSelected(choice: String) {
        userChoice = choice
        userChoiceTextView.text = "Your choice: $userChoice"
    }

    private fun playMatch() {
        val choices = arrayOf("rock", "paper", "scissors")
        computerChoice = choices.random()
        computerChoiceTextView.text = "Computer's choice: $computerChoice"

        val result = determineResult(userChoice, computerChoice)
        resultTextView.text = "Result: $result"

        if (result == "You win!") {
            userWins++
        } else if (result == "Computer wins!") {
            computerWins++
        }

        val matchResult = "Wins: You $userWins - Computer $computerWins"
        statsTextView.text = matchResult
    }

    private fun determineResult(userChoice: String, computerChoice: String): String {
        return when {
            userChoice == computerChoice -> "It's a tie!"
            userChoice == "rock" && computerChoice == "scissors" ||
                    userChoice == "scissors" && computerChoice == "paper" ||
                    userChoice == "paper" && computerChoice == "rock" -> "You win!"
            else -> "Computer wins!"
        }
    }
}
