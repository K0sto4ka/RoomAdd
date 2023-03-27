package com.example.approomdb.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.approomdb.R
import com.example.approomdb.data.UserViewModel
import com.example.approomdb.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private lateinit var bind: FragmentListBinding
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentListBinding.inflate(inflater, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel ::class.java)
        bind.floatingActionButton2.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return bind.root
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_list, container, false)
    }


}