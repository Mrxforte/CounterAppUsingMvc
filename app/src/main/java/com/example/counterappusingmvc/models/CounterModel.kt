package com.example.counterappusingmvc.models

import java.util.Observable

//Simple MVC example using observable
class CounterModel : Observable() {
    private var count = 0
    fun increment() {
        count++
        setChanged()
        notifyObservers()
    }

    fun decrement() {
        count--
        setChanged()
        notifyObservers()
    }

    fun getCount(): Int = count
}