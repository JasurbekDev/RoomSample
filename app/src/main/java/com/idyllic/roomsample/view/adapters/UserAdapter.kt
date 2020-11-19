package com.idyllic.roomsample.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idyllic.roomsample.R
import com.idyllic.roomsample.db.User
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class UserAdapter(var users: List<User>) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(user: User) {
            view.apply {
                userName.text = user.name
                userAge.text = user.age.toString()
            }
        }

    }
}