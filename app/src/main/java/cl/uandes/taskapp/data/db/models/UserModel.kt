package cl.uandes.taskapp.data.models

data class UserModel (
    var id: Long?,
    val email: String,
    val password: String,
    val role: String
)
