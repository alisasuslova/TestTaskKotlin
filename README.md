# Тестовое задание

## Входные данные:
Тестовое задание

Есть множество (массив, где порядок не важен) целых чисел в диапазоне от 1 до 300. 
Количество чисел - до 1000. Напишите функцию сериализации / десериализации в строку, чтобы итоговая строка была компактной.
Цель задачи - максимально сжать данные относительно простой сериализации без алгоритма сжатия (хотя бы 50% в среднем). 
Сериализованная строка должна содержать только ASCII символы. Можно использовать любой язык программирования.
Вместе с решением нужно прислать набор тестов  - исходная строка, сжатая строка, коэффициент сжатия.
Примеры тестов: простейшие короткие, случайные - 50 чисел, 100 чисел, 500 чисел, 1000 чисел, граничные - все числа 1 знака, все числа из 2х знаков, все числа из 3х знаков, каждого числа по 3 - всего чисел 900.


## Реализация:

1. В Main задала входные параметры, верхнюю и нижнюю границу диапазона, в котором будут генерироваться числа случайным образом. Подключила функцию Random:
```java
    val lowBorder = 1
    val upBorder = 299
    val count = (Math.random() * (1000 - 1)).toInt()
```
2. Создала метод, который в случайном порядке будет заполнять массив числами:
```java
    fun createArray(count: Int, lowBorder: Int, upBorder: Int): IntArray {
    return List(count) { lowBorder + Random.nextInt(upBorder - lowBorder + 1) }.toIntArray()
}
```
3. Создала метод, который конвертирует массив чисел в строку символов, и на выходе возращает длину этой строки:
```java
   fun convertToString(arr: IntArray): Int {

    val sb = StringBuilder()
    for (i in arr.indices) {
        sb.append(arr[i])
    }
    return sb.length
}
```
4. Создала метод аналогичный предыдущему, но только вместо цифр соотвествующие им символы из таблицы ASCII:
```java
    fun convertToASCII(arr: IntArray): Int {

    val sb = StringBuilder()
    for (i in arr.indices) {
        val ch = arr[i].toChar()
        sb.append(ch)
    }
    return sb.length
}
```
5. Последний метод, позволяющий наглядно продемострировать изменение длины строки в процентах:
```java
    fun compressionRatio(stringLength: Int, stringLengthASCII: Int): Double {

    val result = (stringLengthASCII.toDouble() / stringLength.toDouble()) * 100
    println("исходная строка $stringLength символов")
    println("сжатая строка $stringLengthASCII символов")
    println("коэффициент сжатия $result%")
    return result
}
```
6. К методу `compressionRatio()` написаланесколько автотестов:
```java
    @Test
    fun compressionRatio50() {
        val stringLength = convertToString(createArray(Random.nextInt(1, 1000), 1, 50))
        val stringLengthASCII = convertToASCII(createArray(Random.nextInt(1, 1000), 1, 50))
        compressionRatio(stringLength, stringLengthASCII)
    }

    ....

   @Test
    fun compressionRatioLast900() {
        val stringLength = convertToString(createArray(900, 100, 999))
        val stringLengthASCII = convertToASCII(createArray(900, 100, 999))
        compressionRatio(stringLength, stringLengthASCII)
    }
```
## Входные данные:

[Скрин_1](https://github.com/alisasuslova/TestTaskJava/blob/main/res_1.JPG)

