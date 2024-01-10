import kotlin.random.Random

fun main(args: Array<String>) {

    val lowBorder = 1
    val upBorder = 299
    val count = (Math.random() * (1000 - 1)).toInt()

    val arr = createArray(count, lowBorder, upBorder)
    println(arr.contentToString())

    val stringLength = convertToString(arr)
    val stringLengthASCII = convertToASCII(arr)

    compressionRatio(stringLength, stringLengthASCII)
}

fun createArray(count: Int, lowBorder: Int, upBorder: Int): IntArray {
    return List(count) { lowBorder + Random.nextInt(upBorder - lowBorder + 1) }.toIntArray()
}

fun convertToString(arr: IntArray): Int {

    val sb = StringBuilder()
    for (i in arr.indices) {
        sb.append(arr[i])
    }
    return sb.length
}

fun convertToASCII(arr: IntArray): Int {

    val sb = StringBuilder()
    for (i in arr.indices) {
        val ch = arr[i].toChar()
        sb.append(ch)
    }
    return sb.length
}

fun compressionRatio(stringLength: Int, stringLengthASCII: Int): Double {

    val result = (stringLengthASCII.toDouble() / stringLength.toDouble()) * 100
    println("исходная строка $stringLength символов")
    println("сжатая строка $stringLengthASCII символов")
    println("коэффициент сжатия $result%")
    return result
}