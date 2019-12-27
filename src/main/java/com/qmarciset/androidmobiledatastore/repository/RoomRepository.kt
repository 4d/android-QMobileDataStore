package com.qmarciset.androidmobiledatastore.repository

import androidx.lifecycle.LiveData
import com.qmarciset.androidmobiledatastore.dao.BaseDao

class RoomRepository<T>(private val baseDao: BaseDao<T>) :
    BaseRoomRepository<T> {

    override fun getAll(): LiveData<List<T>> {
        return baseDao.getAll()
    }

    override fun insert(obj: T) {
        baseDao.insert(obj)
    }

    override fun insertAll(obj: List<T>) {
        baseDao.insertAll(obj)
    }

    override fun update(obj: T) {
        baseDao.update(obj)
    }

    override fun delete(obj: T) {
        baseDao.delete(obj)
    }

    override fun getOne(id: String): LiveData<T> {
        return baseDao.getOne(id)
    }

    override fun deleteAll() {
        baseDao.deleteAll()
    }

    //    override fun deleteOne(id: String) {
    //        baseDao.deleteOne(id)
    //    }
}
