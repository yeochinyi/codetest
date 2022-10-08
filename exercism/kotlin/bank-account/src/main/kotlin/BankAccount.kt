class BankAccount {
    var balance: Long = 0
        get() = if (!isOpen) {
            throw IllegalArgumentException("")
        } else inBalance

    var inBalance = 0L
    var isOpen = true

    fun adjustBalance(amount: Long) {
        inBalance += amount
    }

    fun close() {
        isOpen = false
    }
}
