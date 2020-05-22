package com.liondy.kotlincalculator

import java.util.*


class Postfix {
    fun calculate(s: String): Int {
        val postFixString = getPostFixString(s)
        return calculatePostFix(postFixString)
    }

    private fun getPreference(c: Char): Int {
        return if (c == '+' || c == '-') 1 else if (c == '*' || c == '/') 2 else -1
    }

    private fun calculatePostFix(postFixList: List<String>): Int {
        val stack = Stack<Int>()
        for (i in postFixList.indices) {
            val word = postFixList[i]
            if (word.length == 1 && (word[0] == '+' || word[0] == '-' || word[0] == '*' || word[0] == '/')
            ) {
                val number2 = stack.pop()
                val number1 = stack.pop()
                if (word[0] == '+') {
                    val number = number1 + number2
                    stack.push(number)
                } else if (word[0] == '-') {
                    val number = number1 - number2
                    stack.push(number)
                } else if (word[0] == '*') {
                    val number = number1 * number2
                    stack.push(number)
                } else {
                    val number = number1 / number2
                    stack.push(number)
                }
            } else {
                val number = word.toInt()
                stack.push(number)
            }
        }
        return stack.peek()
    }

    private fun getPostFixString(s: String): List<String> {
        val stack = Stack<Char>()
        val postFixList: MutableList<String> =
            ArrayList()
        var flag = false
        for (i in 0 until s.length) {
            val word = s[i]
            if (word == ' ') {
                continue
            }
            if (word == '(') {
                stack.push(word)
                flag = false
            } else if (word == ')') {
                flag = false
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop()
                        break
                    } else {
                        postFixList.add(stack.pop().toString() + "")
                    }
                }
            } else if (word == '+' || word == '-' || word == '*' || word == '/') {
                flag = false
                if (stack.isEmpty()) {
                    stack.push(word)
                } else {
                    while (!stack.isEmpty() && getPreference(stack.peek()) >= getPreference(word)) {
                        postFixList.add(stack.pop().toString() + "")
                    }
                    stack.push(word)
                }
            } else {
                if (flag) {
                    var lastNumber = postFixList[postFixList.size - 1]
                    lastNumber += word
                    postFixList[postFixList.size - 1] = lastNumber
                } else postFixList.add(word.toString() + "")
                flag = true
            }
        }
        while (!stack.isEmpty()) {
            postFixList.add(stack.pop().toString() + "")
        }
        return postFixList
    }
}