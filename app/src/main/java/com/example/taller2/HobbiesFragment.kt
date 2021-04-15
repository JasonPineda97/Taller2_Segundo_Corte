package com.example.taller2

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_hobbies.*
import kotlinx.android.synthetic.main.fragment_info.*
import java.util.ArrayList
import android.content.Intent




class HobbiesFragment constructor(hobbies: String) : Fragment() {
    
    var hobbie = ""
    var hobbies = ""

    init{
        this.hobbie = hobbies
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hobbies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        hobbies_mod.setText(hobbie)
        super.onViewCreated(view, savedInstanceState)
        modificar_hobbies.setOnClickListener {
            val selectedItems = ArrayList<String>()
            val lista_hobbies = arrayOf("Leer","Hacer ejercicio","Viajar","Jugar videojuegos","Bailar","Escuchar música")
            val hobbiesList: List<String> = lista_hobbies.toList()
            val builder = AlertDialog.Builder(context)

            // Set the alert dialog title
            builder.setTitle("Tipo de documento")
                .setMultiChoiceItems(lista_hobbies,null,
                    DialogInterface.OnMultiChoiceClickListener(){ dialog, which, isChecked ->
                        if(isChecked){
                            selectedItems.add(hobbiesList.get(which));
                        }
                        else if (selectedItems.contains(which)){
                        }
                    })

                .setPositiveButton("Aceptar",
                    DialogInterface.OnClickListener { dialog, id ->
                        // User clicked OK, so save the selectedItems results somewhere
                        // or return them to the component that opened the dialog
                        for(i in selectedItems.indices){
                            hobbies = hobbies + "-" + selectedItems.get(i)
                        }
                        hobbies_mod.setText(hobbies)
                        val info = HomeActivity()
                        info.hobbies = hobbies
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->

                    })
            // Finally, make the alert dialog using builder
            builder.create()
            // Display the alert dialog on app interface
            builder.show()
        }
    }
}