package co.edu.udea.compumovil.gr09_20231.lab1

import android.content.ContentValues.TAG
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class ContactDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)
        save()
    }
    private fun save(){
        val button:Button = findViewById(R.id.button)
        val phone:EditText = findViewById(R.id.phoneNumber)
        val email:EditText = findViewById(R.id.emailAddress)
        val country:EditText = findViewById(R.id.country)
        val city:EditText = findViewById(R.id.city)

        val extras = intent.extras
        val dataName = extras?.getString("name")
        val dataLastName = extras?.getString("lastName")
        val dataDate = extras?.getString("date")
        val dataGender = extras?.getString("gender")
        val dataEducation = extras?.getString("education")
        button.setOnClickListener{
            if(phone.text.isNotEmpty()&&email.text.isNotEmpty()&&country.text.isNotEmpty()){
                Log.i(TAG,"informacion Personal:")
                Log.i(TAG,"$dataName $dataLastName")
                if (dataGender!= null)
                    Log.i(TAG,"$dataGender")
                Log.i(TAG,"Nacio el: $dataDate")
                Log.i(TAG,"informacion de Contacto:")
                Log.i(TAG,"Telefono:"+ phone.text)
                Log.i(TAG,"Email:" + email.text)
                Log.i(TAG,"Pais:" + country.text)
                Log.i(TAG,"Ciudad:" + city.text)
            }
        }
    }
}