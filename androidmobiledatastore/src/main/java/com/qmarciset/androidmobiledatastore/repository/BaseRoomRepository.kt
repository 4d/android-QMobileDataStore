package com.qmarciset.androidmobiledatastore.repository

import androidx.lifecycle.LiveData

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
