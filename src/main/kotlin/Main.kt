fun main() {
    do {
    println("\nВыберите номер задачи (1-6)")
    val choice = readlnOrNull()?.toIntOrNull()
    when (choice) {
        1 -> task1()
        2 -> task2()
        3 -> task3()
        4 -> task4()
        5 -> task5()
        6 -> task6()
        0 -> break
        else -> println("Неверный номер задачи.")
    }
}while (choice != 0)

}

fun task1() {
    print("Введите исходную строку: ")
    val stringTask1 = readln()
    var sum = 1
    print("Исходная строка: ")
    for (i in 0 until stringTask1.length - 1) {
        print(stringTask1[i])
    }
    println()
    println("Измененная строка: ")
    for (i in 1 until stringTask1.length - 1) {
        if (stringTask1[i] == stringTask1[i - 1]) {
            sum++
        } else {
            print(stringTask1[i - 1])

            if (sum == 1) {
                print("")
            } else {
                print(sum)
            }
            sum = 1
        }
        if (i == stringTask1.length - 1) {
            print(stringTask1[i - 1])
            print(sum)
        }
    }
}

fun task2() {
    print("Введите строку: ")
    val input = readln()
    val chars = input.toCharArray()
    chars.sort()

    var i = 0
    while ( i < chars.size) {
        val current = chars[i]
        var count  = 0

        while (i < chars.size && chars[i] == current) {
            count++
            i++
        }
        println("$current - $count")
    }
}

fun task3() {
    print("Введите натуральное число: ")
    val numberTask3 = readln().toInt()

    val numberBin = numberTask3.toString(2)
    println("Двоичное число: $numberBin")
}

fun task4() {
    print("Введите числа в формате: Число1 Число2 Операция (через пробел) ")
    val input = readlnOrNull() ?: return
    val parts = input.split(" ")
    if (parts.size !=3) {
        println("Ошибка")
        return
    }
    val num1 = parts[0].toDoubleOrNull()
    val num2 = parts[1].toDoubleOrNull()
    val op = parts[2]

    if (num1 == null || num2 == null) {
        println("Ошибка некорекные числа")
        return
    }
    val result = when (op){
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> {
            if (num2 == 0.0) {
                println("Ошибка деления на ноль")
                return
            }
            num1 / num2
        }
        else -> {
            println("Ошибка")
            return
        }
    }
    println("Результат: $result")
}

fun task5() { println("Введите целое число n:")
    val nStr = readlnOrNull()
    println("Введите основание x (целое, больше 1):")
    val xStr = readlnOrNull()

    if (nStr == null || xStr == null || nStr.isEmpty() || xStr.isEmpty()) {
        println("Ошибка: оба числа должны быть введены!")
        return
    }

    try {
        val n = nStr.toLong()
        val x = xStr.toLong()

        if (x <= 1) {
            println("Ошибка: x должно быть больше 1!")
            return
        }
        if (n <= 0) {
            println("Целочисленный показатель не существует")
            return
        }

        var steepen = 1L
        var y = 0
        while (steepen < n) {
            steepen *= x
            y++
            if (steepen > n) {
                println("Целочисленный показатель не существует")
                break
            }
        }

        if (steepen == n) {
            println("Показатель степени: $y")
        }

    } catch (e: Exception) {
        println("Ошибка: введите целые числа!")
    }
}

fun task6() {
    println("Введите первую цифру:")
    val first = readlnOrNull()?.toIntOrNull()

    println("Введите вторую цифру:")
    val second = readlnOrNull()?.toIntOrNull()

    if (first == null || second == null || first !in 0..9 || second !in 0..9) {
        println("Ошибка: введите корректные цифры (от 0 до 9).")
        return
    }

    if (first == second) {
        println("Ошибка: цифры должны быть различны.")
        return
    }

    val n1 = first * 10 + second
    val n2 = second * 10 + first

    if(n1 % 2 !=0) {
        println(n1)
    } else if(n2 % 2 != 0){
        println(n2)
    } else {
        println("Созать неччетное число невозможно")
    }
}


