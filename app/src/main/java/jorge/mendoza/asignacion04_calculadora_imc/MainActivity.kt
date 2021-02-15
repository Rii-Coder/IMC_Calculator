package jorge.mendoza.asignacion04_calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cEstatura: EditText = findViewById(R.id.cEstatura)
        var cPeso: EditText = findViewById(R.id.cPeso)
        var btnCalcular: Button = findViewById(R.id.btnCalcular)
        var txtResultado: TextView = findViewById(R.id.txtResultado)

        btnCalcular.setOnClickListener{
            if (!cEstatura.text.isEmpty() && !cPeso.text.isEmpty()){

                var estatura = cEstatura.text.toString().toDouble()
                var peso = cPeso.text.toString().toDouble()

                var imc = peso / (estatura * estatura)
                txtResultado.visibility = View.VISIBLE

                var resultado: String = "Su IMC es: "+imc+" y su categoría es: ";

                if (imc < 18.5){
                    resultado = resultado + "bajo peso"
                }else if (imc >= 18.5 && imc <= 24.9){
                    resultado = resultado + "normal"
                }else if(imc >= 25 && imc <= 29.9){
                    resultado = resultado + "sobrepeso"
                }else if(imc >= 30 && imc  <= 34.9){
                    resultado = resultado + "obesidad grado 1"
                }else if(imc >= 35 && imc <= 39.9){
                    resultado = resultado + "obesidad grado 2"
                }else if(imc > 40){
                    resultado = resultado + "obesidad grado 3"
                }

                txtResultado.setText(resultado)
            }else{
                txtResultado.visibility = View.VISIBLE
                txtResultado.setText("Ingrese valores en los campos")
            }
        }

    }

}