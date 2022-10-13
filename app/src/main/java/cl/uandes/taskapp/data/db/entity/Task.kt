package cl.uandes.taskapp.data.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//@Entity(tableName = "task_table")
//@Parcelize
data class Task (
    //@PrimaryKey(autoGenerate = true)
    var id: Long?,

    val title: String,
    val description: String,
    val taskCreator: String,
    val comment: String,
    val deadline: String,
    val creationDate: String,
    val status: String
) //: Parcelable