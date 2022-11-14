package cl.uandes.taskapp.data.db.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "projects")
@Parcelize
data class Project(
    @PrimaryKey(autoGenerate = true)
    val id: Long?=null,

    @ColumnInfo (name="title") val title: String,
    @ColumnInfo (name="description") val description: String,
    @ColumnInfo (name="admin") val admin: String,
    @ColumnInfo (name="participant") val participant: String,
    @ColumnInfo (name="creationDate") val creationDate: String,
    @ColumnInfo (name="deadline") val deadline: String,
    @ColumnInfo (name="percentageCompletion") val percentageCompletion: String,
    @ColumnInfo (name="status") val status: String
) : Parcelable