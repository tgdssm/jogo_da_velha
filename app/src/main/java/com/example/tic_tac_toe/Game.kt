package com.example.jogo_da_velha
import android.widget.Button

class Game {
    var endGame : Boolean = false
    private set
    var currentPlayer : Int = 1
    private set

    var aTie : Boolean = false
    private set

    private var moveCount : Int = 0
    private val player1 = Player(moves = mutableListOf())
    private val player2 = Player(moves = mutableListOf())
    private val board : List<List<Int>> = listOf(
        // horizontal
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9),

        // vertical
        listOf(1, 4, 7),
        listOf(2, 5, 8),
        listOf(3, 6, 9),

        // diagonal
        listOf(1, 5, 9),
        listOf(3, 5, 7),
    )

    fun play(position : Int, button: Button) {
        moveCount++
        if(!endGame && moveCount <= 9) {
            if (currentPlayer == 1) {
                button.text = "X"
                player1.play(positionFilled = position)
                verifyGame(player1)
                if(endGame) return
                else currentPlayer = 2
            } else {
                button.text = "O"
                player2.play(positionFilled = position)
                verifyGame(player2)
                if(endGame) return
                else currentPlayer = 1
            }
        }
    }

    private fun verifyGame(player : Player) {
        if(moveCount == 9 && !endGame) {
            endGame = true
            aTie = true
        } else {
            for(list in board) {
                if (player.moves.containsAll(list)) {
                    endGame = true
                }
            }
        }
    }

    fun resetGame() {
        player1.resetMoves()
        player2.resetMoves()
        currentPlayer = 1
        endGame = false
        aTie = false
        moveCount = 0
    }

}