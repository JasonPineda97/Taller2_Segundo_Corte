package com.example.taller2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity(){
    var contador = 0
    var hobbies = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val boton_info = findViewById<Button>(R.id.boton1)
        boton_info.setOnClickListener{
            showInfoFragment()
        }

        val boton_hobbies = findViewById<Button>(R.id.boton2)
        boton_hobbies.setOnClickListener {
            showHobbiesFragment()
        }
    }

    private fun showInfoFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        var nombre = getIntent().getStringExtra("Nombre").toString()
        var apellido = getIntent().getStringExtra("Apellido").toString()
        println(apellido)
        var documento = getIntent().getStringExtra("Documento").toString()
        var tipo_documento = getIntent().getStringExtra("Tipo de documento").toString()
        var fecha_nacimiento = getIntent().getStringExtra("Fecha de nacimiento").toString()
        if(contador==0) {
            hobbies = getIntent().getStringExtra("Hobbies").toString()
            contador++
        }else{

        }
        var contraseña = getIntent().getStringExtra("Contraseña").toString()
        transaction.replace(R.id.container, InfoFragment(nombre,apellido,documento,tipo_documento,fecha_nacimiento,hobbies,contraseña), null)
        transaction.commit()
    }

    private fun showHobbiesFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        var hobbies = getIntent().getStringExtra("Hobbies").toString()
        transaction.replace(R.id.container, HobbiesFragment(hobbies), null)
        transaction.commit()
    }
}