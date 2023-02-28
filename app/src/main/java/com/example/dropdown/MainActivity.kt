package com.example.dropdown
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var country = arrayOf("Select Country", "India", "USA", "China", "Japan", "Other")

    private var spin: Spinner? = null
    private   var b: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val b = findViewById<Button>(R.id.bottom)
        b.setOnClickListener {
              register()
          }
       val spin =  findViewById<Spinner>(R.id.countryid);

        spin.onItemSelectedListener = this;

       val  aa = ArrayAdapter(this,R.layout.spinner_item,country)
           .also {
            aa ->
            aa.setDropDownViewResource(R.layout.spinner_dropdown)
        }

        spin.adapter = aa


    }

    fun  register(){
        var con= spin?.getSelectedItem().toString().trim()

      Log.d(con,"con")
    }

     fun getString(s: String): String? {
        return null
    }



    fun validateSpinner(spinner: Spinner, error: String?): Boolean {
        val selectedView = spinner.selectedView
        if (selectedView != null && selectedView is TextView) {
            val selectedTextView = selectedView
            if (selectedTextView.text == "Select Academic Year") {
                selectedTextView.error = error
                Toast.makeText(this, error, Toast.LENGTH_LONG).show()
                return false
            }
        }
        return true
    }






    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    //llToast.makeText(this, position, Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}

