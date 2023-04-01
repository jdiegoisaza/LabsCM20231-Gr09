package co.edu.udea.compumovil.gr09_20231.lab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner


class PersonalDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)
        nextActivity()
        /*val buttonSiguiente = findViewById<Button>(R.id.buttonSiguiente)
        buttonSiguiente.setOnClickListener {
            // Crear un Intent para iniciar la siguiente actividad
            val intent = Intent(this, activity_contact_data::class.java)

            // Iniciar la siguiente actividad
            startActivity(intent)
        }*/
    }

    private fun nextActivity(){
        val button:Button = findViewById(R.id.buttonSiguiente)
        val name:EditText = findViewById(R.id.editTextName)
        val lastName:EditText = findViewById(R.id.editTextLastname)
        val gender:RadioGroup = findViewById(R.id.radioGroupGender)
        val education:Spinner = findViewById(R.id.spinnerSchool)
        val date:DatePicker = findViewById(R.id.editTextFNacimiento)
        button.setOnClickListener{
            if (name.text.isNotEmpty() && lastName.text.isNotEmpty()){
                val intent = Intent(this, ContactDataActivity::class.java)
                intent.putExtra("name", name.text.toString())
                intent.putExtra("lastName", lastName.text.toString())
                if(gender.checkedRadioButtonId != -1){
                    val radioButton:RadioButton =findViewById(gender.checkedRadioButtonId)
                    intent.putExtra("gender",radioButton.text)
                }
                val datebirth:String = date.dayOfMonth.toString() + "/" + (date.month+1).toString() + "/" + date.year.toString()
                intent.putExtra("date", datebirth)
                intent.putExtra("education", education.selectedItem.toString())


                startActivity(intent)
            }
    }
    }

}