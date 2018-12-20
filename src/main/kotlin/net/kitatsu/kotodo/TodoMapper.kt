package net.kitatsu.kotodo

import org.apache.ibatis.annotations.*

@Mapper
interface TodoMapper {

    @Select("""
        SELECT id, body, done
        FROM todo
        WHERE id = #{id}
    """)
    fun getById(id: Int): TodoTask

    @Select("""
        SELECT id, body, done
        FROM todo
    """)
    fun getAll(): List<TodoTask>

    @Insert("""
        INSERT INTO todo (body)
        VALUES (#{body})
    """)
    @Options(useGeneratedKeys = true)
    fun insert(task: TodoTask)

    @Update("""
        UPDATE todo SET
        body = #{body},
        done = #{done}
        WHERE id = #{id}
    """)
    fun update(todo: TodoTask)

}
