/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmarciset.androidmobiledatastore.repository

import androidx.lifecycle.LiveData

interface BaseRoomRepository<T> {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    fun getOne(id: String): LiveData<T>

    fun getAll(): LiveData<List<T>>

    fun insert(obj: T)

    fun insertAll(objList: List<T>)

    fun delete(obj: T)

    fun deleteAll()
}
