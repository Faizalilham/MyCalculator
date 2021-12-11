package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.calculator.Contract.MainActivityContract
import com.example.calculator.Presenter.MainActivityPresenter
import com.example.calculator.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity(),MainActivityContract.ActivityContract {
    private lateinit var binding: ActivityMainBinding
    private var presenter : MainActivityContract.ActivityPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        presenter = MainActivityPresenter(this)
        setContentView(binding.root)
        addNumber()

    }

    override fun showInput(text: String) : String{
         return "${binding.TvMath.text}$text"
    }

    override fun addNumber() {
        binding.BtnNol.setOnClickListener { binding.TvMath.text = showInput("0") }
        binding.BtnSatu.setOnClickListener { binding.TvMath.text = showInput("1") }
        binding.BtnDua.setOnClickListener { binding.TvMath.text = showInput("2") }
        binding.BtnTiga.setOnClickListener { binding.TvMath.text = showInput("3") }
        binding.BtnEmpat.setOnClickListener { binding.TvMath.text = showInput("4") }
        binding.BtnLima.setOnClickListener { binding.TvMath.text = showInput("5") }
        binding.BtnEnam.setOnClickListener { binding.TvMath.text = showInput("6") }
        binding.BtnTujuh.setOnClickListener { binding.TvMath.text = showInput("7") }
        binding.Btndelapan.setOnClickListener { binding.TvMath.text = showInput("8") }
        binding.BtnSembilan.setOnClickListener { binding.TvMath.text = showInput("9") }
        binding.BtnKali.setOnClickListener { binding.TvMath.text = showInput("x") }
        binding.BtnBagi.setOnClickListener {binding.TvMath.text = showInput("/") }
        binding.BtnPlus.setOnClickListener { binding.TvMath.text = showInput("+") }
        binding.BtnMinus.setOnClickListener { binding.TvMath.text = showInput("-") }
        binding.BtnKurungbuka.setOnClickListener { binding.TvMath.text = showInput("(") }
        binding.BtnKurungtutup.setOnClickListener { binding.TvMath.text = showInput(")") }
        binding.BtnTitik.setOnClickListener { binding.TvMath.text = showInput(".") }
        binding.BtnDelete.setOnClickListener {
            binding.TvMath.text = ""
            binding.TvResult.text = ""
        }
        binding.BtnBackspace.setOnClickListener {

            var text = binding.TvMath.text.toString()
            if(text.length >= 1){
                val text2 = text.substring(0,text.length-1)
                binding.TvMath.setText(text2)
            }
            if(text.length < 1){
                binding.TvMath.setText("0")
            }

        }
        binding.BtnHitung.setOnClickListener { binding.TvResult.text = presenter?.Count().toString()}

    }

    override fun expression(): String {
        var expression = binding.TvMath.text.replace(Regex("x"),"*")
        return expression
    }

    override fun cekresult(result: Double) {
        if(!result.isNaN()){
            binding.TvResult.text = DecimalFormat("0.##").format(result).toString()
        }else{
            binding.TvResult.text = "ERROR"
            binding.TvResult.setTextColor(ContextCompat.getColor(this,R.color.red))
        }
    }


}