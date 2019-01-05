package v_builders

import util.TODO

fun buildStringExample(): String {
    fun buildString(build: StringBuilder.() -> Unit): String {
        val stringBuilder = StringBuilder()
        stringBuilder.build()
        return stringBuilder.toString()
    }

    return buildString {
        this.append("Numbers: ")
        for (i in 1..10) {
            // 'this' can be omitted
            append(i)
        }
    }
}

/**
 * - `buildMap`接受一个函数作为参数
 * - 这个参数是一个扩展函数, 并且在`buildMap`这个域中可以使用
 * - 我们构造一个map实例, 使用传入的扩展函数, 最后返回map实例
 */
fun buildMap(build: MutableMap<Int, String>.() -> Unit): Map<Int, String> {
    val map = mutableMapOf<Int, String>()
    map.build()
    return map
}

fun todoTask37(): Nothing = TODO(
    """
        Task 37.
        Uncomment the commented code and make it compile.
        Add and implement function 'buildMap' with one parameter (of type extension function) creating a new HashMap,
        building it and returning it as a result.
    """
)

fun task37(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
