package cl.uandes.taskapp.data.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "user_table")
@Parcelize

data class User (
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    val email: String,
    val password: String,
    val role: String
) : Parcelable
