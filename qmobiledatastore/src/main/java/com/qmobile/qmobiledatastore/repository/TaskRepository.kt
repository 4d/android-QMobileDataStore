/*
 * Created by qmarciset on 24/5/2022.
 * 4D SAS
 * Copyright (c) 2022 qmarciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore.repository

import androidx.lifecycle.LiveData
import com.qmobile.qmobiledatastore.dao.ActionTask
import com.qmobile.qmobiledatastore.dao.ActionTaskDao

class TaskRepository(private val actionTaskDao: ActionTaskDao) {

    fun getOne(id: String): LiveData<ActionTask> {
        return actionTaskDao.getOne(id)
    }

    fun getAll(): LiveData<List<ActionTask>> {
        return actionTaskDao.getAll()
    }

    fun getAllPending(): LiveData<List<ActionTask>> {
        return actionTaskDao.getAllPending()
    }

    suspend fun insert(obj: ActionTask) {
        actionTaskDao.insert(obj)
    }

    suspend fun deleteOne(id: String) {
        return actionTaskDao.deleteOne(id)
    }

    suspend fun deleteAll() {
        return actionTaskDao.deleteAll()
    }

    suspend fun deleteList(idList: List<String>) {
        return actionTaskDao.deleteList(idList)
    }
}
