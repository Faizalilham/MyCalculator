package com.example.calculator.Presenter

import com.example.calculator.Contract.MainActivityContract
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivityPresenter(private var v : MainActivityContract.ActivityContract?)
    : MainActivityContract.ActivityPresenter {



    override fun Count() : Double {
        val count = v?.expression()
        val result = Expression(count).calculate()
        v?.cekresult(result)
        return result
    }

    override fun onDestroy() {
        v = null
    }
}