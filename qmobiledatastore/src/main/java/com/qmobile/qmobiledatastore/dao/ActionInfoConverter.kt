package com.qmobile.qmobiledatastore.dao

import androidx.room.TypeConverter
import com.google.gson.Gson

class ActionInfoConverter {

    @TypeConverter
    fun actionInfoToString(app: ActionInfo): String = Gson().toJson(app)

    @TypeConverter
    fun stringToActionInfo(string: String): ActionInfo =
        Gson().fromJson(string, ActionInfo::class.java)
}
