package com.example.whatsapp_clone.sharedpreferences.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.whatsapp_clone.sharedpreferences.Repository.DataStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = DataStoreRepository(application)

    val readtoken = repository.readtoken.asLiveData()
    val readid = repository.readid.asLiveData()
    val readname = repository.readname.asLiveData()
    val readphone = repository.readphone.asLiveData()
    val readimage = repository.readimage.asLiveData()


    fun deleteFromDataStore() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteFromDataStore()
    }

    fun saveToDataStore(token: String,id: String,name: String,phone:String,image:String) = viewModelScope.launch(Dispatchers.IO) {
        repository.saveToDataStore(token,id,name,phone,image)
    }
}