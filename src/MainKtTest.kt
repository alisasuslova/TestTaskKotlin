import org.junit.Test
import kotlin.random.Random

class MainKtTest {

    @Test
    fun compressionRatio50() {
        val stringLength = convertToString(createArray(Random.nextInt(1, 1000), 1, 50))
        val stringLengthASCII = convertToASCII(createArray(Random.nextInt(1, 1000), 1, 50))
        compressionRatio(stringLength, stringLengthASCII)
    }

    @Test
    fun compressionRatio100() {
        val stringLength = convertToString(createArray(Random.nextInt(1, 1000), 1, 100))
        val stringLengthASCII = convertToASCII(createArray(Random.nextInt(1, 1000), 1, 100))
        compressionRatio(stringLength, stringLengthASCII)
    }

    @Test
    fun compressionRatio500() {
        val stringLength = convertToString(createArray((Math.random() * (1000 - 1)).toInt(), 1, 500))
        val stringLengthASCII = convertToASCII(createArray((Math.random() * (1000 - 1)).toInt(), 1, 500))
        compressionRatio(stringLength, stringLengthASCII)
    }

    @Test
    fun compressionRatio1000() {
        val stringLength = convertToString(createArray(Random.nextInt(1, 1000), 1, 1000))
        val stringLengthASCII = convertToASCII(createArray(Random.nextInt(1, 1000), 1, 1000))
        compressionRatio(stringLength, stringLengthASCII)
    }

    @Test
    fun compressionRatioZ1() {
        val stringLength = convertToString(createArray(Random.nextInt(1, 1000), 0, 9))
        val stringLengthASCII = convertToASCII(createArray(Random.nextInt(1, 1000), 0, 9))
        compressionRatio(stringLength, stringLengthASCII)
    }

    @Test
    fun compressionRatioZ2() {
        val stringLength = convertToString(createArray(Random.nextInt(1, 1000), 10, 99))
        val stringLengthASCII = convertToASCII(createArray(Random.nextInt(1, 1000), 10, 99))
        compressionRatio(stringLength, stringLengthASCII)
    }

    @Test
    fun compressionRatioZ3() {
        val stringLength = convertToString(createArray(Random.nextInt(1000 - 1) + 1, 100, 999))
        val stringLengthASCII = convertToASCII(createArray(Random.nextInt(1000 - 1) + 1, 100, 999))
        compressionRatio(stringLength, stringLengthASCII)
    }

    @Test
    fun compressionRatioLast900() {
        val stringLength = convertToString(createArray(900, 100, 999))
        val stringLengthASCII = convertToASCII(createArray(900, 100, 999))
        compressionRatio(stringLength, stringLengthASCII)
    }
}