package com.example.taller2

import android.R.attr
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_info.*

class InfoFragment constructor(nombre: String, apellido: String, documento: String, tipo_documento: String, fecha_nacimiento: String, hobbies: String, contraseña: String) : Fragment() {

    var nombre = ""
    var apellido = ""
    var documento = ""
    var tipo_documento = ""
    var fecha_nacimiento = ""
    var hobbie = ""
    var contraseña = ""
    var contador = 0

    init{
        this.nombre = nombre
        this.apellido = apellido
        this.documento = documento
        this.tipo_documento = tipo_documento
        this.fecha_nacimiento = fecha_nacimiento
        this.hobbie = hobbies
        this.contraseña = contraseña
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        nom.setText(nombre)
        ape.setText(apellido)
        doc.setText(documento)
        ti_doc.setText(tipo_documento)
        fe_nac.setText(fecha_nacimiento)
        hob.setText(hobbie)
        con.setText(contraseña)

        super.onViewCreated(view, savedInstanceState)
    }
}