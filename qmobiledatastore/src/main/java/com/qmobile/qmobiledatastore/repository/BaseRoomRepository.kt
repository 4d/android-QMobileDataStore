/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore.repository

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.sqlite.db.SupportSQLiteQuery
import kotlinx.coroutines.flow.Flow

interface BaseRoomRepository<T : Any> {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    fun getOne(id: String): LiveData<T>

    fun getAllPagedList(sqLiteQuery: SupportSQLiteQuery): DataSource.Factory<Int, T>

    fun getAllPagingData(sqLiteQuery: SupportSQLiteQuery, pagingConfig: PagingConfig): Flow<PagingData<T>>

    suspend fun insert(obj: T)

    suspend fun insertAll(objList: List<T>)

    suspend fun deleteOne(id: String)
}
