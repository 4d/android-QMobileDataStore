package com.qmobile.qmobiledatastore.dao

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.qmobile.qmobiledatastore.data.RoomData
import java.util.Date
import kotlin.collections.HashMap

@Entity
data class ActionTask(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var status: STATUS,
    val date: Date,
    val relatedItemId: String?, // used as primary key to send with "currentRecord actions"
    val label: String,
    val actionInfo: ActionInfo, // contain information about related action
    var message: String? = null
) : RoomData

enum class STATUS {
    SUCCESS, // server response success = true
    PENDING, // no response received yet
    ERROR_SERVER
}

data class ActionInfo(
    val paramsToSubmit: HashMap<String, Any>? = null,
    val metaDataToSubmit: HashMap<String, String>? = null,
    val imagesToUpload: HashMap<String, String>? = null,
    val validationMap: HashMap<String, Boolean>? = null,
    val allParameters: String? = null,
    val actionName: String,
    var tableName: String,
    val currentRecordId: String?,
    val actionUUID: String,
    val isOfflineCompatible: Boolean,
    val preferredShortName: String
)
