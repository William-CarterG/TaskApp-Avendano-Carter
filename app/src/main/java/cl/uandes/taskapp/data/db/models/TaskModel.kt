package cl.uandes.taskapp.data.models

data class TaskModel (
    var id: Long?,
    val title: String,
    val description: String,
    val taskCreator: String,
    val comment: String,
    val deadline: String,
    val status: String
)