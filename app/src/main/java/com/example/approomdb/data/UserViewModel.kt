package com.example.approomdb.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {

private val readAllData: LiveData<List<User>>
private val rep: UserRep

init {
    val userDao = UserDataBase.getDataBase(application).userDao()
    rep = UserRep(userDao)
    readAllData = rep.readAllData
}
    fun addUse(user: User){
        viewModelScope.launch(Dispatchers.IO){
            rep.addUse(user)
        }
    }


}