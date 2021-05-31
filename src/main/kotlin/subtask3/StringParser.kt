package subtask3

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val records = HashMap<Int, String>()
        val results = ArrayList<String>()

        // array of brackets
        val bracketsArr: Array<Array<Char>> = Array(3, { Array(2, { '|' }) })
        bracketsArr[0] = arrayOf('(', ')')
        bracketsArr[1] = arrayOf('[', ']')
        bracketsArr[2] = arrayOf('<', '>')

        for (brackets in bracketsArr) {

            val bracketsBegin = brackets[0]
            val bracketsEnd = brackets[1]
            val openBracketsPos = ArrayList<Int>()

            inputString.forEachIndexed { index, letter ->

                // open brackets
                if (letter == bracketsBegin) {
                    openBracketsPos.add(index + 1)
                }

                // close brackets
                if (letter == bracketsEnd) {
                    if (openBracketsPos.count() > 0) {
                        val lastPos = openBracketsPos[openBracketsPos.count() - 1]
                        val resultString = inputString.substring(lastPos, index)
                        records[lastPos] = resultString
                        openBracketsPos.removeAt(openBracketsPos.count() - 1)
                    }
                }
            }
        }

        // sort by first bracket
        val sortedMap = records.toSortedMap(compareBy { it })
        for ((key, value) in sortedMap) {
            results.add(value)
        }

        println(results)
        return results.toTypedArray()
    }
}
