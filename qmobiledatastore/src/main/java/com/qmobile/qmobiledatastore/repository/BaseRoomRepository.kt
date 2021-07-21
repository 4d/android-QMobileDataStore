/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore.repository

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.sqlite.db.SupportSQLiteQuery

interface BaseRoomRepository<T> {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    fun getOne(id: String): LiveData<T>

    fun getAllDynamicQuery(sqLiteQuery: SupportSQLiteQuery): DataSource.Factory<Int, T>

    suspend fun insert(obj: T)

    suspend fun insertAll(objList: List<T>)

    suspend fun deleteOne(id: String)

//    suspend fun delete(obj: T)
//    suspend fun deleteAll()
//    fun getAll(): LiveData<List<T>>
//    fun getSearchAllByQuery(query: String): LiveData<List<T>>
//    fun getAllDynamicQueryFlow(sqLiteQuery: SupportSQLiteQuery): Flow<List<T>>
}
