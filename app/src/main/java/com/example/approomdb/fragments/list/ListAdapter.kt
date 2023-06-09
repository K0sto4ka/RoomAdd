package com.example.approomdb.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.approomdb.R
import com.example.approomdb.data.User

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_rou, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = userList[position]
        val id_txt = holder.itemView.findViewById<TextView>(R.id.id_txt)
        val firsname_txt = holder.itemView.findViewById<TextView>(R.id.firstname_txt)
        val  lastname_txt = holder.itemView.findViewById<TextView>(R.id.lastname_txt)
        val age_txt = holder.itemView.findViewById<TextView>(R.id.age_txt)
        val roulayot = holder.itemView.findViewById<ConstraintLayout>(R.id.rou_layout)

        id_txt.text = currentUser.id.toString()
        firsname_txt.text = currentUser.firstName
        lastname_txt.text = currentUser.lastName
        age_txt.text = currentUser.age.toString()

        roulayot.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentUser)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
      return userList.size
    }
    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}