/*
 * Created by qmarciset on 24/5/2022.
 * 4D SAS
 * Copyright (c) 2022 qmarciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore.repository

import androidx.lifecycle.LiveData
import com.qmobile.qmobiledatastore.dao.ActionTask
import com.qmobile.qmobiledatastore.dao.ActionTaskDao

class PendingTaskRepository(private val actionTaskDao: ActionTaskDao) {

    fun getOne(id: Long): LiveData<ActionTask> {
        return actionTaskDao.getOne(id)
    }

    fun getAll(): LiveData<List<ActionTask>> {
        return actionTaskDao.getAll()
    }

    fun getAllPending(): LiveData<List<ActionTask>> {
        return actionTaskDao.getAllPending()
    }

    suspend fun insert(obj: ActionTask) {
        actionTaskDao.insertOrUpdate(obj)
    }

    suspend fun insertAll(objList: List<ActionTask>) {
        actionTaskDao.insertOrUpdateAll(objList)
    }

    suspend fun deleteOne(id: Long) {
        return actionTaskDao.deleteOne(id)
    }

    suspend fun deleteAll() {
        return actionTaskDao.deleteAll()
    }
}
