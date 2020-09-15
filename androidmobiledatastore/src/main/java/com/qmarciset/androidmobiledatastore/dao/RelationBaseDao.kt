/*
 * Created by Quentin Marciset on 3/9/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmarciset.androidmobiledatastore.dao

import androidx.lifecycle.LiveData
import com.qmarciset.androidmobiledatastore.data.RoomRelation

interface RelationBaseDao<R : RoomRelation> {

    fun getManyToOneRelation(relationId: String): LiveData<List<R>>
}
