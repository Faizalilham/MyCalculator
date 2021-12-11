package com.example.calculator.Contract

interface MainActivityContract {

    interface ActivityContract{
        fun showInput(text : String) : String
        fun expression():String
        fun cekresult(result : Double)
        fun addNumber()

    }

    interface ActivityPresenter{
        fun Count() : Double
        fun onDestroy()
    }
}