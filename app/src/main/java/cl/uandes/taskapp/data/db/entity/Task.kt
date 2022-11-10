package cl.uandes.taskapp.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity (tableName = "tasks")
@Parcelize
data class Task (
    @PrimaryKey(autoGenerate = true)
    val id: Long?=null,

    @ColumnInfo (name="title") val title: String,
    @ColumnInfo (name="description") val description: String,
    @ColumnInfo (name="taskCreator") val taskCreator: String,
    @ColumnInfo (name="comment") val comment: String,
    @ColumnInfo (name="deadline") val deadline: String,
    @ColumnInfo (name="creationDate") val creationDate: String,
    @ColumnInfo (name="status") val status: String
) : Parcelable