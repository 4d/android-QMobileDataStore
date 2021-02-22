/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore.repository

import androidx.lifecycle.LiveData
import androidx.sqlite.db.SupportSQLiteQuery
import com.qmobile.qmobiledatastore.dao.BaseDao

class RoomRepository<T>(private val baseDao: BaseDao<T>) :
    BaseRoomRepository<T> {

    override fun getOne(id: String): LiveData<T> {
        return baseDao.getOne(id)
    }

    override fun getAll(): LiveData<List<T>> {
        return baseDao.getAll()
    }

    override suspend fun insert(obj: T) {
        baseDao.insertOrUpdate(obj)
    }

    override suspend fun insertAll(objList: List<T>) {
        baseDao.insertOrUpdateAll(objList)
    }

    override suspend fun delete(obj: T) {
        baseDao.delete(obj)
    }

    override suspend fun deleteOne(id: String) {
        return baseDao.deleteOne(id)
    }

    override suspend fun deleteAll() {
        baseDao.deleteAll()
    }

    override fun getSearchAllByQuery(query: String): LiveData<List<T>> {
        return baseDao.getAllSearchData(query)
    }

    override fun getAllDynamicQuery(sqLiteQuery: SupportSQLiteQuery): LiveData<List<T>> {
        return baseDao.getAllDynamicQuery(sqLiteQuery)
    }
}
