package cl.uandes.taskapp.data.datasources

import cl.uandes.taskapp.data.model.Task
import cl.uandes.taskapp.data.model.User

object InMemoryDataSource {
    val users = mutableListOf( User(1,"hola@chao.cl", "123456", "teamlead"),
                               User(2,"chao@hola.com","123456","user"))
    val tasks = mutableListOf( Task(1, "Add tasks menu", "Proyecto 1", "Julio Cortés","You have to add the tasks menu to the fragment.","08/09/2022" ),
                               Task(2, "Implement navigation", "Blog App", "María Pía Sánchez","Add navigation's actions.","13/09/2022"))
}