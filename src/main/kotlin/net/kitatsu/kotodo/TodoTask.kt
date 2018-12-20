package net.kitatsu.kotodo

// MyBatisが引数なしコンストラクタを要求
data class TodoTask(
        var id: Int = 0,
        var body: String = "",
        var done: Boolean = false
)
