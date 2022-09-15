package cl.uandes.taskapp.data.datasources

import cl.uandes.taskapp.data.model.User

object InMemoryDataSource {
    val users = mutableListOf( User(1,"hola@chao.cl", "123456", "teamlead"),
                               User(2,"chao@hola.com","123456","user"))
}