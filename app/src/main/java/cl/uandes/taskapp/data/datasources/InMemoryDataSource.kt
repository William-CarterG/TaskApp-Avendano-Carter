package cl.uandes.taskapp.data.datasources

import cl.uandes.taskapp.data.model.Project
import cl.uandes.taskapp.data.model.Task
import cl.uandes.taskapp.data.model.User


object InMemoryDataSource {

    val users = mutableListOf<User>(
        User(1, "hola@chao.cl", "123456", "teamlead"),
        User(2, "chao@hola.com", "123456", "user"),
        User(3, "wgcarter@miuandes.cl", "123", "user")
    )
    val tasks = mutableListOf<Task>(
        Task(
            1,
            "Add tasks menu",
            "Proyecto 1",
            "Julio Cortés",
            "You have to add the tasks menu to the fragment.",
            "08/09/2022",
            "Successful"
        ),
        Task(2,
            "Implement navigation",
            "Blog App",
            "María Pía Sánchez",
            "Add navigation's actions.",
            "13/09/2022",
            "In progress"
        )
    )
    val projects = mutableListOf<Project>(
        Project(
            1,
            "Task App",
            "App where you can organize your tasks and projects.",
            "Julio Cortés",
            "Carmencita Avendaño",
            "08/09/2022",
            "15/11/2022",
            "10%",
            "In Progress"
        ),
        Project(
            2,
            "Blog App",
            "App where you can have a profile and post about your life.",
            "María Pía Sánchez",
            "William Carter",
            "24/09/2022",
            "27/08/2022",
            "100%",
            "Successful"
        )
    )
}