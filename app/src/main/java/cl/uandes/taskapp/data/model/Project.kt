package cl.uandes.taskapp.data.model

data class Project(
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
