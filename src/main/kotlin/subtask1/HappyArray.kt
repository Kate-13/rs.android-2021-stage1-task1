package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {

        val sadArrayList = ArrayList<Int>()
        sadArray.forEachIndexed { i, el ->
            sadArrayList.add(el)
        }

        var results = ArrayList<Int>()

        while (true) {

            var countChanges = 0

            val happyarr = ArrayList<Int>()
            sadArrayList.forEachIndexed { i, el ->
                happyarr.add(el)
            }

            happyarr.forEachIndexed { i, el ->
                if (i<(happyarr.count()-2)) {
                    val sum = happyarr[i] + happyarr[i + 2]
                    if (happyarr[i + 1] > sum) {
                        sadArrayList.remove(happyarr[i + 1])
                        countChanges++
                    }
                }
            }

            if(countChanges == 0) {
                results = happyarr
                break
            }
        }

        return results.toIntArray()
    }
}
