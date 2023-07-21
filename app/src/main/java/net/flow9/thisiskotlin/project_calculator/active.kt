package net.flow9.thisiskotlin.project_calculator

import kotlin.jvm.Throws

fun main() {
    val num1 = result("Num1").toString().toInt()
    val num2 = result("Num2").toString().toInt()

    val addCalc = Calculator(AddOperation())
    println("1더하기1은 ${addCalc.operate(10, 20)}")
    val subCalc = Calculator(SubstractOperation())
    val mulCalc = Calculator(MultiplyOperation())
    val divCalc = Calculator(DivideOperation())
}


class Calculator(private val operator: AbstractOperation) {
    fun operate(num1: Int, num2: Int): Double {
        return operator.operate(num1, num2)
    }
}

abstract class AbstractOperation {
    abstract fun operate(num1: Int, num2: Int): Double
}

class AddOperation : AbstractOperation() {
    override fun operate(num1: Int, num2: Int): Double = (num1 + num2).toDouble()
}

class SubstractOperation : AbstractOperation() {
    override fun operate(num1: Int, num2: Int): Double = (num1 - num2).toDouble()
}

class MultiplyOperation : AbstractOperation() {
    override fun operate(num1: Int, num2: Int): Double = (num1 * num2).toDouble()
}

class DivideOperation : AbstractOperation() {
    @Throws(ArithmeticException::class)
    override fun operate(num1: Int, num2: Int): Double {
        require(num2 != 0) {
            ArithmeticException("Divide by Zero")
        }
        return (num1 / num2).toDouble()
    }
}


fun result(type: String): Any? {
    return when (type) {
        "selectNumber" -> {
            println("번호를 선택해주세요")
            while (true) {
                try {
                    val selectNumber: String? = readLine()
                    return selectNumber?.toInt() ?: -1
                } catch (e: java.lang.Exception) {
                    println("번호를 다시 선택해주세요")
                }
            }
        }

        "Num1" -> {
            println("숫자를 입력해주세요")
            while (true) {
                try {
                    val originAge: String? = readLine()
                    return originAge?.toInt() ?: -1
                } catch (e: Exception) {
                    println("숫자를 다시 입력해주세요")
                }
            }
        }

        "Num2" -> {
            println("숫자를 입력해주세요")
            while (true) {
                try {
                    val originAge: String? = readLine()
                    return originAge?.toInt() ?: -1
                } catch (e: Exception) {
                    println("숫자를 다시 입력해주세요")
                }
            }
        }

        else -> {
            return "no"
        }
    }
}