package cl.uandes.taskapp.data.model

data class User (
    var id: Long?,
    val email: String,
    val password: String,
    val role: String
    )
