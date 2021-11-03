/*
 * Created by Quentin Marciset on 3/9/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore.dao

import androidx.lifecycle.LiveData
import com.qmobile.qmobiledatastore.data.RoomRelation

interface RelationBaseDao<R : RoomRelation> {

    fun getRelation(relationId: String): LiveData<R>
}
