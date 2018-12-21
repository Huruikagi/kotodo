package net.kitatsu.kotodo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {

    @Autowired
    lateinit var todoMapper: TodoMapper

    @GetMapping("/")
    fun index(model: Model): String {
        val taskList = todoMapper.getAll()
        model.addAttribute("title", taskList)

        return "index"
    }

}
