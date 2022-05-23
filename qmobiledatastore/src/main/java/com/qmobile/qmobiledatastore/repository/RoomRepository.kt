/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore.repository

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.sqlite.db.SupportSQLiteQuery
import com.qmobile.qmobiledatastore.dao.BaseDao
import com.qmobile.qmobiledatastore.data.RoomData
import com.qmobile.qmobiledatastore.data.RoomEntity
import kotlinx.coroutines.flow.Flow

// open for TU
open class RoomRepository<T : RoomData>(private val baseDao: BaseDao<RoomEntity, RoomData>) {

    fun getOne(id: String): LiveData<RoomEntity> {
        return baseDao.getOne(id)
    }

    fun getAllPagedList(sqLiteQuery: SupportSQLiteQuery): DataSource.Factory<Int, RoomEntity> {
        return baseDao.getAllPagedList(sqLiteQuery)
    }

    fun getAllPagingData(sqLiteQuery: SupportSQLiteQuery, pagingConfig: PagingConfig): Flow<PagingData<RoomEntity>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { baseDao.getAllPagingData(sqLiteQuery) }
        ).flow
    }

    suspend fun insert(obj: T) {
        baseDao.insertOrUpdate(obj)
    }

    suspend fun insertAll(objList: List<T>) {
        baseDao.insertOrUpdateAll(objList)
    }

    suspend fun deleteOne(id: String) {
        return baseDao.deleteOne(id)
    }

    /*override suspend fun delete(obj: T) {
        baseDao.delete(obj)
    }*/

    /*override suspend fun deleteAll() {
        baseDao.deleteAll()
    }*/

    /*override fun getAll(): LiveData<List<T>> {
      return baseDao.getAll()
    }*/

    /*override fun getSearchAllByQuery(query: String): LiveData<List<T>> {
        return baseDao.getAllSearchData(query)
    }*/

    /*override fun getAllDynamicQueryFlow(sqLiteQuery: SupportSQLiteQuery): Flow<List<T>> {
        return baseDao.getAllDynamicQueryFlow(sqLiteQuery) // Get searched dogs from Room Database
            // Combine the result with another flow
//                .combine(topBreedsFlow) { dogs, topDogs ->
//                    dogs.applyToDog(topDogs)
//                }
            .flowOn(Dispatchers.Default)
            // Return the latest values
            .conflate()
//        return baseDao.getAllDynamicQueryFlow(sqLiteQuery)
    }*/
}
