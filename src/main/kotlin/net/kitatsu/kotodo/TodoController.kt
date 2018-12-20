package net.kitatsu.kotodo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/todo")
class TodoController {

    @Autowired
    lateinit var todoMapper: TodoMapper

    @GetMapping
    fun getAll(): List<TodoTask> {
        return todoMapper.getAll()
    }

    @PostMapping
    fun create(@RequestParam(name = "body") body: String): TodoTask {
        val task = TodoTask(body = body)
        todoMapper.insert(task)
        return task
    }

    @PutMapping("/{id}")
    @Transactional
    fun update(@PathVariable id: Int, @RequestBody todo: TodoTask): TodoTask {
        if (id != todo.id) throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        todoMapper.update(todo)
        return todoMapper.getById(id)
    }

}
