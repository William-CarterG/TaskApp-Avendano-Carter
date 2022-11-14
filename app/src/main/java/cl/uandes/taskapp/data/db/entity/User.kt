package cl.uandes.taskapp.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity (tableName="users")
@Parcelize
data class User (
    @PrimaryKey(autoGenerate = true)
    var id: Long?=null,

    @ColumnInfo(name="email") val email: String,
    @ColumnInfo (name="password") val password: String,
    @ColumnInfo (name="role") val role: String
) : Parcelable
