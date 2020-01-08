package com.qmarciset.androidmobiledatastore.repository

import androidx.lifecycle.LiveData

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
interface BaseRoomRepository<T> {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    fun getAll(): LiveData<List<T>>

    fun insert(obj: T)

    fun insertAll(obj: List<T>)

    fun update(obj: T)

    fun delete(obj: T)

    fun getOne(id: String): LiveData<T>

    fun deleteAll()

    //    fun deleteOne(id: String)
}
