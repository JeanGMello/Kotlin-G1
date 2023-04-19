package com.atitus.projetog1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class CalculateFragment : Fragment() {

    private lateinit var txtPeso: TextInputEditText
    private lateinit var txtAltura: TextInputEditText
    private lateinit var btnCal: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calculate, container, false)
        btnCal = view.findViewById(R.id.btnCalcular)

        btnCal.setOnClickListener{
            txtPeso = view.findViewById(R.id.txtPeso)
            txtAltura = view.findViewById(R.id.txtAltura)
            var peso = txtPeso.text.toString().toDouble()
            var alt = txtAltura.text.toString().toDouble()
            var result2 = peso / (alt * alt)

            Log.e("aaa", peso.toString())
            Log.e("aaa", alt.toString())
            Log.e("aaa", result2.toString())

            val txtName: TextView = view.findViewById(R.id.txtResult)
            txtName.text = "Resultado: ${result2.toInt()} " + checkIMC(result2)

        }

        return view
    }

    private fun checkIMC(db: Double): String{
        return when(db) {
            in .00..17.00 -> "Muito abaixo do peso."
            in 17.1..18.49 -> "Abaixo do peso."
            in 18.5..24.99 -> "Peso normal."
            in 25.0..29.99 ->  "Acima do peso."
            in 30.0..34.99 -> "Obesidade I."
            in 35.0..39.99 -> "Obesidade II(severa)."
            else -> "Obesidade III(mórbida)."
        }
    }

}