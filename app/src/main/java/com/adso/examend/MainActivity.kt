package com.example.examenD

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adso.examend.R
import com.example.examenD.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var operand1: Double = 0.0
    private var operation: Char = ' '

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button0.setOnClickListener(this);
        binding.button1.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
        binding.button3.setOnClickListener(this);
        binding.button4.setOnClickListener(this);
        binding.button5.setOnClickListener(this);
        binding.button6.setOnClickListener(this);
        binding.button7.setOnClickListener(this);
        binding.button8.setOnClickListener(this);
        binding.button9.setOnClickListener(this);

        // Asignar clic listeners a los botones de operaciones
        binding.btnAdd.setOnClickListener(this);
        binding.btnSubtract.setOnClickListener(this);
        binding.btnMultiply.setOnClickListener(this);
        binding.btnDivide.setOnClickListener(this);
        binding.btnEqual.setOnClickListener(this);
        binding.btnClear.setOnClickListener(this);

    }

    private fun setOperation(op: Char) {
        operand1 = binding.textView.text.toString().toDouble()
        operation = op
        binding.textView.text = ""
    }

    private fun calculate() {
        val operand2 = binding.textView.text.toString().toDouble()
        val result = when (operation) {
            '+' -> operand1 + operand2
            '-' -> operand1 - operand2
            '*' -> operand1 * operand2
            '/' -> operand1 / operand2
            else -> 0.0
        }
        binding.textView.text = result.toString()
    }

    private fun clear() {
        binding.textView.text = ""
        operand1 = 0.0
        operation = ' '
    }

    // Método onClick del OnClickListener
    override fun onClick(view: View) {
        when (view.id) {
            binding.button0 -> showToast("0")
            binding.button1 -> showToast("1")
            binding.button2 -> showToast("2")
            binding.button3 -> showToast("3")
            binding.button4 -> showToast("4")
            binding.button5 -> showToast("5")
            binding.button6 -> showToast("6")
            binding.button7 -> showToast("7")
            binding.button8 -> showToast("8")
            binding.button9 -> showToast("9")
            binding.buttonAdd -> setOperation('+')
            binding.buttonSubtract -> setOperation('-')
            binding.buttonMultiply -> setOperation('*')
            binding.buttonDivide -> setOperation('/')
            binding.buttonEquals -> calculate()
            binding.buttonClear -> clear()
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}



