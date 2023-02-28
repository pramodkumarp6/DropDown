package com.example.dropdown
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dropdown.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
     private lateinit var activityMainBinding: ActivityMainBinding
      var country = arrayOf("Select Country", "India", "USA", "China", "Japan", "Other")




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding =ActivityMainBinding.inflate(layoutInflater)
        val view = activityMainBinding.root
        setContentView(view)

        activityMainBinding.bottom.setOnClickListener {
              register()
          }
        val aa = ArrayAdapter(this, R.layout.spinner_item, country).also {
            it.setDropDownViewResource(R.layout.spinner_dropdown)
            it.notifyDataSetChanged()
        }
        activityMainBinding.countryid.adapter = aa
        activityMainBinding.countryid.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val country = parent?.getItemAtPosition(position).toString()
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
    fun  register(){
        val con = activityMainBinding.countryid.getSelectedItem().toString()
        Log.d(con,"con")

        if (con.equals("Select Country")) {
            Toast.makeText(this, "Select Country", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}

