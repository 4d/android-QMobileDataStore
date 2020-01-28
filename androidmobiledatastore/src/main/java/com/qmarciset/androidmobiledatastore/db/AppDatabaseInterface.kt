package com.qmarciset.androidmobiledatastore.db

import com.qmarciset.androidmobiledatastore.dao.BaseDao

interface AppDatabaseInterface {

    // Returns the correct DAO object of specific type
    fun <T> getDao(tableName: String): BaseDao<T>
}
