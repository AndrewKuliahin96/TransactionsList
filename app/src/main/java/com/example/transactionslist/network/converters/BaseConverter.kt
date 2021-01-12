package com.example.transactionslist.network.converters

abstract class BaseConverter<R, M> {

    abstract fun convert(response: R?): M?
}
