/*
 * Created by Quentin Marciset on 8/9/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore.data

interface RoomRelation {
    val toOne: RoomData?
    val toMany: List<RoomData>
}
