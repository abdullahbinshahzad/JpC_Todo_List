package com.example.jpc_todo_list.feature_note.domain.util

sealed class OrderBy(val orderType: OrderType){
    class Name(orderType: OrderType): OrderBy(orderType)
    class Date(orderType: OrderType): OrderBy(orderType)
    class Color(orderType: OrderType): OrderBy(orderType)

    fun copy(orderType: OrderType): OrderBy{
        return when(this) {
            is Name -> Name(orderType)
            is Date -> Date(orderType)
            is Color -> Color(orderType)
        }
    }
}