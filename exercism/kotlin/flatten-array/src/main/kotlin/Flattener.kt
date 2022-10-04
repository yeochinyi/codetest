object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {

        // val r = mutableListOf<Any>()
        // var q = ArrayDeque<Any?>()

        // q.addAll(source)
        // do {
        // val s = q.removeFirst()
        // s?.let { s ->
        // if (s is Collection<Any?>) {
        // q.addAll(0, s)
        // } else {
        // r.add(s)
        // }
        // }
        // } while (q.isNotEmpty())

        // return r
        return source
                .flatMap {
                    when (it) {
                        is List<*> -> flatten(it)
                        else -> listOf(it)
                    }
                }
                .filterNotNull()
    }
}
