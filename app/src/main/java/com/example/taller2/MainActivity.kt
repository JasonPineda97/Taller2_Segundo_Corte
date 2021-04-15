package com.example.taller2

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.ClipData
import android.content.DialogInterface
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*
import android.content.ClipData.Item
import android.content.Intent


class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener{

    var nombre = ""
    var apellido = ""
    var documento = ""
    var tipo_documento = ""
    var fecha_nacimiento = ""
    var hobbies = ""
    var contraseña = ""
    var confirmar_contraseña = ""
    var day = 0
    var month: Int = 0
    var year: Int = 0
    var myDay = 0
    var myMonth: Int = 0
    var myYear: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tipo_documento_boton = findViewById<Button>(R.id.tipo_documento)
        tipo_documento_boton.setOnClickListener {
            val documentos = arrayOf("CC","CE","TI","NIP","NIT","PAP")
            val builder = AlertDialog.Builder(this@MainActivity)

            // Set the alert dialog title
            builder.setTitle("Tipo de documento");
            builder.setItems(documentos,DialogInterface.OnClickListener(){ dialog, which ->
                    tipo_documento = documentos[which].toString()
                    Toast.makeText(this, "Elegiste: $tipo_documento", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
            })
            // Finally, make the alert dialog using builder
            builder.create()
            // Display the alert dialog on app interface
            builder.show()
        }

        val boton_hobbies = findViewById<Button>(R.id.hobbies)
        val selectedItems = ArrayList<String>()
        boton_hobbies.setOnClickListener {
            val lista_hobbies = arrayOf("Leer","Hacer ejercicio","Viajar","Jugar videojuegos","Bailar","Escuchar música")
            val hobbiesList: List<String> = lista_hobbies.toList()
            val builder = AlertDialog.Builder(this@MainActivity)

            // Set the alert dialog title
            builder.setTitle("Tipo de documento")
            .setMultiChoiceItems(lista_hobbies,null,DialogInterface.OnMultiChoiceClickListener(){ dialog, which, isChecked ->
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
                })
            .setNegativeButton("Cancelar",
                DialogInterface.OnClickListener { dialog, id ->

                })
            // Finally, make the alert dialog using builder
            builder.create()
            // Display the alert dialog on app interface
            builder.show()
        }

        val boton_fecha = findViewById<Button>(R.id.fecha_nacimiento)

        boton_fecha.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            day = calendar.get(Calendar.DAY_OF_MONTH)
            month = calendar.get(Calendar.MONTH)
            year = calendar.get(Calendar.YEAR)
            val datePickerDialog =
                DatePickerDialog(this@MainActivity, this@MainActivity, year, month,day)
            datePickerDialog.show()
        }

        val boton_home = findViewById<Button>(R.id.boton_home)

        boton_home.setOnClickListener {
            nombre = findViewById<EditText>(R.id.nombre).text.toString()
            apellido = findViewById<EditText>(R.id.apellido).text.toString()
            documento = findViewById<EditText>(R.id.documento).text.toString()
            contraseña = findViewById<EditText>(R.id.contraseña).text.toString()
            confirmar_contraseña = findViewById<EditText>(R.id.confirmar_contraseña).text.toString()
            val builder = AlertDialog.Builder(this@MainActivity)

            when{
                (nombre.equals(""))->{
                    builder.setMessage("El nombre es obligatorio")
                    builder.create()
                    builder.show()
                }
                (apellido.equals(""))->{
                    builder.setMessage("El apellido es obligatorio")
                    builder.create()
                    builder.show()
                }
                (documento.equals(""))->{
                    builder.setMessage("El documento es obligatorio")
                    builder.create()
                    builder.show()
                }
                (tipo_documento.equals(""))->{
                    builder.setMessage("Debe seleccionar el tipo de documento")
                    builder.create()
                    builder.show()
                }
                (fecha_nacimiento.equals(""))->{
                    builder.setMessage("Debe seleccionar su fecha de nacimiento")
                    builder.create()
                    builder.show()
                }
                (hobbies.equals(""))->{
                    builder.setMessage("Debe seleccionar hobbies")
                    builder.create()
                    builder.show()
                }
                (selectedItems.size<4)->{
                    builder.setMessage("Debe seleccionar al menos 4 hobbies")
                    builder.create()
                    builder.show()
                }
                (contraseña.equals(""))->{
                    builder.setMessage("La contraseña es obligatoria")
                    builder.create()
                    builder.show()
                }
                (confirmar_contraseña.equals(""))->{
                    builder.setMessage("Debe confirmar la contraseña")
                    builder.create()
                    builder.show()
                }

                (contraseña!=confirmar_contraseña)->{
                    builder.setMessage("Las contraseñas no coinciden ")
                    builder.create()
                    builder.show()
                }

                else->{
                    val condiciones = "Con la descarga de la APP usted acepta y autoriza que Skandia Holding de Colombia S.A., utilice sus datos en calidad de responsable del tratamiento para fines derivados de la ejecución de la APP. Skandia Holding de Colombia S.A. informa que podrá ejercer sus derechos a conocer, actualizar, rectificar y suprimir su información personal; así como el derecho a revocar el consentimiento otorgado para el tratamiento de datos personales previstos en la ley 1581 de 2012, observando nuestra política de tratamiento de información disponible en: www.skandia.com.co/protecciondedatos; o a través de protecciondedatos@skandia.com.co o del teléfono 6584300, siendo voluntario responder preguntas sobre información sensible o de menores de edad.                    Skandia Holding de Colombia S.A. podrá dar a conocer, transferir y/o trasmitir sus datos personales dentro y fuera del país a cualquier empresa miembro del grupo Skandia, así como a terceros a consecuencia de un contrato, ley o vínculo lícito que así lo requiera, para todo lo anterior otorgo mi autorización expresa e inequívoca.                    De conformidad a lo anterior autoriza el tratamiento de su información en los términos señalados, y transfiere a Skandia de manera total, y sin limitación mis derechos de imagen y patrimoniales de autor, de manera voluntaria, previa, explicita, informada e inequívoca."
                    val builder = AlertDialog.Builder(this@MainActivity)
                    builder.setMessage(condiciones)
                        .setPositiveButton("Aceptar",
                            DialogInterface.OnClickListener { dialog, id ->
                                // FIRE ZE MISSILES!
                                val intent = Intent(this, HomeActivity::class.java)
                                intent.putExtra("Nombre",nombre)
                                intent.putExtra("Apellido",apellido)
                                intent.putExtra("Documento",documento)
                                intent.putExtra("Tipo de documento",tipo_documento)
                                intent.putExtra("Fecha de nacimiento",fecha_nacimiento)
                                intent.putExtra("Hobbies",hobbies)
                                intent.putExtra("Contraseña",contraseña)
                                intent.putExtra("Confirmar contraseña",confirmar_contraseña)
                                startActivity(intent)
                            })
                        .setNegativeButton("Cancelar",
                            DialogInterface.OnClickListener { dialog, id ->
                                // User cancelled the dialog
                            })
                    // Create the AlertDialog object and return it
                    builder.create()
                    builder.show()
                }
            }
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myDay = dayOfMonth
        myYear = year
        myMonth = month
        val calendar: Calendar = Calendar.getInstance()
        Toast.makeText(this, "Has seleccionado el $dayOfMonth. del $month del año $year", Toast.LENGTH_SHORT).show()
        fecha_nacimiento = "$dayOfMonth / $month / $year"
    }
}