package com.example.eventbustesting
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.example.eventbustesting.events.EventAddPerson
import com.example.eventbustesting.utils.RxBus
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var personDisposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChangeAct.setOnClickListener {
            startActivity(Intent(this,Page2Activity::class.java))
        }

        personDisposable = RxBus.listen(EventAddPerson::class.java).subscribe{
            txtRes.text = it.personName
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (!personDisposable.isDisposed) personDisposable.dispose()
    }
}
