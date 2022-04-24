package com.example.whatsapp_clone.sharedpreferences.Repository

import android.content.Context
import android.util.Log
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

const val PREFERENCE_NAME = "my_preference"

class DataStoreRepository(context: Context) {

    private object PreferenceKeys {
        val token = preferencesKey<String>("token")
        val id = preferencesKey<String>("id")
        val name = preferencesKey<String>("name")
        val phone = preferencesKey<String>("phone")
        val image = preferencesKey<String>("image")
    }

    private val dataStore: DataStore<Preferences> = context.createDataStore(
        name = PREFERENCE_NAME
    )

    suspend fun saveToDataStore(token: String,id: String, name: String, phone: String, image: String){
        dataStore.edit { preference ->
            preference[PreferenceKeys.token] = token
            preference[PreferenceKeys.id] = id
            preference[PreferenceKeys.name] = name
            preference[PreferenceKeys.phone] = phone
            preference[PreferenceKeys.image] = image
        }
    }

    val readtoken: Flow<String> = dataStore.data
        .catch { exception ->
            if(exception is IOException){
                Log.d("DataStore", exception.message.toString())
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }
        .map { preference ->
            val token = preference[PreferenceKeys.token] ?: "none"
            token
        }
    val readid: Flow<String> = dataStore.data
        .catch { exception ->
            if(exception is IOException){
                Log.d("DataStore", exception.message.toString())
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }
        .map { preference ->
            val id = preference[PreferenceKeys.id] ?: "none"
            id
        }
    val readname: Flow<String> = dataStore.data
        .catch { exception ->
            if(exception is IOException){
                Log.d("DataStore", exception.message.toString())
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }
        .map { preference ->
            val name = preference[PreferenceKeys.name] ?: "none"
            name
        }
    val readphone: Flow<String> = dataStore.data
        .catch { exception ->
            if(exception is IOException){
                Log.d("DataStore", exception.message.toString())
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }
        .map { preference ->
            val phone = preference[PreferenceKeys.phone] ?: "none"
            phone
        }
    val readimage: Flow<String> = dataStore.data
        .catch { exception ->
            if(exception is IOException){
                Log.d("DataStore", exception.message.toString())
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }
        .map { preference ->
            val image = preference[PreferenceKeys.image] ?: "none"
            image
        }


}