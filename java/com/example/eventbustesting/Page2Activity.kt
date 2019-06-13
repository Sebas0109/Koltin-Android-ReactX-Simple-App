package com.example.eventbustesting

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.eventbustesting.events.EventAddPerson
import com.example.eventbustesting.utils.RxBus
import kotlinx.android.synthetic.main.activity_page2.*

class Page2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        btnsendName.setOnClickListener {
            if (txtName.text.toString().isEmpty())
            {
                Toast.makeText(this,"Agrega Nombre", Toast.LENGTH_LONG).show()
            }else
            {
                RxBus.publish(EventAddPerson(txtName.text.toString()))
                finish()
            }
        }
    }
}
