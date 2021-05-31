package subtask2

class BillCounter {

    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        var result = ""
        val sum = (bill.sum() - bill[k]) / 2
        if (sum == b) {
            result = "bon appetit"
            print("$result")
        }
        else {
            result = (b - sum).toString()
            print("$result")
        }

        return result
    }
}
