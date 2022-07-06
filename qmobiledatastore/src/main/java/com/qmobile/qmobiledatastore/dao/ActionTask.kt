package com.qmobile.qmobiledatastore.dao

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.qmobile.qmobiledatastore.data.RoomData
import java.util.Date
import java.util.UUID
import kotlin.collections.HashMap

@Entity
data class ActionTask(
    var status: Status,
    var date: Date,
    val relatedItemId: String?, // used as primary key to send with "currentRecord actions"
    val label: String,
    val actionInfo: ActionInfo, // contain information about related action
    var message: String? = null
) : RoomData {
    @PrimaryKey
    var id = UUID.randomUUID().toString() // Not autogenerated by Room because we need this id before it's inserted

    fun filterTableTasks(tableName: String): Boolean = if (tableName.isEmpty()) {
        true // When we come from settings (no filter on table name)
    } else {
        this.actionInfo.tableName == tableName
    }

    fun filterEntityTasks(currentItemId: String): Boolean = if (currentItemId.isEmpty()) {
        true // From EntityListFragment
    } else {
        this.relatedItemId == currentItemId // From EntityDetailFragment (show only current entity tasks)
    }

    fun isHistory(): Boolean = this.status == Status.SUCCESS || this.status == Status.ERROR_SERVER
    fun isPending(): Boolean = this.status == Status.PENDING
    fun isSuccess(): Boolean = this.status == Status.SUCCESS
    fun isErrorServer(): Boolean = this.status == Status.ERROR_SERVER

    enum class Status {
        SUCCESS,
        PENDING,
        ERROR_SERVER
    }
}

data class ActionInfo(
    val paramsToSubmit: HashMap<String, Any>? = null,
    var errors: Map<String, String>? = null,
    val metaDataToSubmit: HashMap<String, String>? = null,
    val imagesToUpload: HashMap<String, String>? = null,
    val validationMap: HashMap<String, Boolean>? = null,
    val allParameters: String? = null,
    val actionName: String,
    var tableName: String,
    val actionUUID: String,
    val isOfflineCompatible: Boolean,
    val preferredShortName: String
)
