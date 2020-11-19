package com.idyllic.roomsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.idyllic.roomsample.db.User
import com.idyllic.roomsample.view.adapters.UserAdapter
import com.idyllic.roomsample.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewmodel: UserViewModel
    private val adapter = UserAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        viewmodel.getAllUsers().observe(this, Observer {users ->
            adapter.users = users
            adapter.notifyDataSetChanged()
        })

        mainRv.layoutManager = LinearLayoutManager(this)
        mainRv.adapter = adapter

        var age = 1

        addUserButton.setOnClickListener {
            val user = User(name = "Farrukh", age = age++)
            viewmodel.insert(user)
        }
    }
}