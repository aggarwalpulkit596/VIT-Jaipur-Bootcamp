package com.xyz.offlinedemo

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


const val PREF_NAME = "vit_rising"
const val NAME_KEY = "name"
class MyPreference(context: Context){

    private val applicationContext = context.applicationContext
    private val dataStore:DataStore<Preferences>

    init {
        dataStore = applicationContext.createDataStore(PREF_NAME)
    }

    val name:Flow<String>
        get() = dataStore.data.map {
            it[preferencesKey<String>(NAME_KEY)] ?: ""
        }

    suspend fun setName(name:String){
        dataStore.edit {
            it[preferencesKey<String>(NAME_KEY)] = name
        }
    }

}