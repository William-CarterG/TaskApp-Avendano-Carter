package cl.uandes.taskapp.data.model

data class Task (
    var id: Long?,
    val title: String,
    val description: String,
    val taskCreator: String,
    val comment: String,
    val deadline: String,
    val status: String
        )