package cl.uandes.taskapp.data.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "project_table")
data class Project(
    @PrimaryKey(autoGenerate = false)
    var id: Long?,

    val title: String,
    val description: String,
    val admin: String,
    val participant: String,
    val creationDate: String,
    val deadline: String,
    val percentageCompletion: String,
    val status: String
)