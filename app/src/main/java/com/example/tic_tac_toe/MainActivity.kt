package com.example.tic_tac_toe

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.jogo_da_velha.Game

class MainActivity : AppCompatActivity() {


    private val game = Game()
    private lateinit var resetBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resetBtn = findViewById<Button>(R.id.reset)
        resetBtn.setOnClickListener{
            resetGame()
        }
    }

    fun onPressedBtn(view : View) {
        if(!game.endGame) {
            game.play(position = view.tag.toString().toInt(), button = view as Button)
            if(game.endGame) {
                showDialog()
            }
        }
    }

    private fun resetGame() {
        findViewById<Button>(R.id.btn1).text = ""
        findViewById<Button>(R.id.btn2).text = ""
        findViewById<Button>(R.id.btn3).text = ""
        findViewById<Button>(R.id.btn4).text = ""
        findViewById<Button>(R.id.btn5).text = ""
        findViewById<Button>(R.id.btn6).text = ""
        findViewById<Button>(R.id.btn7).text = ""
        findViewById<Button>(R.id.btn8).text = ""
        findViewById<Button>(R.id.btn9).text = ""
        game.resetGame()
    }

    private fun showDialog() {
        val message : String = if(game.aTie) "Empate" else if(game.currentPlayer == 1) "Player 1 venceu!!!" else "Player 2 venceu!!!"
        AlertDialog.Builder(this).setTitle("Acabou o jogo").setMessage(message).setPositiveButton("Voltar"
        ) { _, _ -> {}}.create().show()
    }
}