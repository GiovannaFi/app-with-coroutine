package com.example.corutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class FirstFragment2 : Fragment() {

    private lateinit var btn_confirm: Button
    private lateinit var tv_number: TextView
    private lateinit var et_addNumber: EditText
    var counter = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_confirm = view.findViewById(R.id.btn_confirm)
        tv_number = view.findViewById(R.id.tv_number)
        et_addNumber = view.findViewById(R.id.editText)



        btn_confirm.setOnClickListener {

            runBlocking {
                incrementNumber()
            }

        }
    }

    suspend fun incrementNumber() {
        delay(2000)
        val number = et_addNumber.text.toString().toInt()
        val newNumber = number + 1 + counter
        counter++
        tv_number.text = newNumber.toString()

    }


}
