/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmarciset.androidmobiledatastore.repository

import androidx.lifecycle.LiveData
import com.qmarciset.androidmobiledatastore.dao.BaseDao

class RoomRepository<T>(private val baseDao: BaseDao<T>) :
    BaseRoomRepository<T> {

    override fun getOne(id: String): LiveData<T> {
        return baseDao.getOne(id)
    }

    override fun getAll(): LiveData<List<T>> {
        return baseDao.getAll()
    }

    override fun insert(obj: T) {
        baseDao.insertOrUpdate(obj)
    }

    override fun insertAll(objList: List<T>) {
        baseDao.insertOrUpdateAll(objList)
    }

    override fun delete(obj: T) {
        baseDao.delete(obj)
    }

    override fun deleteOne(id: String) {
        return baseDao.deleteOne(id)
    }

    override fun deleteAll() {
        baseDao.deleteAll()
    }
}
