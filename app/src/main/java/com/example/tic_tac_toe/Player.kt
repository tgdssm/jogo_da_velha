package com.example.jogo_da_velha

data class Player(var moves : MutableList<Int>) {
    fun play(positionFilled : Int) {
        moves.add(positionFilled);
    }

    fun resetMoves() = moves.clear()
}