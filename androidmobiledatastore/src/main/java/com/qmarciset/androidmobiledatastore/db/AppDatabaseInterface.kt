/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmarciset.androidmobiledatastore.db

import com.qmarciset.androidmobiledatastore.dao.BaseDao
import com.qmarciset.androidmobiledatastore.dao.RelationBaseDao
import com.qmarciset.androidmobiledatastore.data.RoomRelation

interface AppDatabaseInterface {

    // Returns the correct DAO object of specific type
    fun <T> getDao(tableName: String): BaseDao<T>

    // Offers the possibility to populate the database for test purposes
//    fun populateDatabase()

    fun getRelationDao(tableName: String, relatedTableName: String): RelationBaseDao<RoomRelation>
}
