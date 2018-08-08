package com.leipeng.service

import com.leipeng.pojo.Person
import org.springframework.stereotype.Service


@Service
class PersonService {

    private val mMap: HashMap<Int, Person> = hashMapOf()
    private var id: Int = 10

    init {
        for (i in 1..10) {
            val person = Person(i,"""leipeng$i""",i,"")
            mMap[i] = person
        }
    }

    fun findAll(): ArrayList<Person> {
        return ArrayList(mMap.values)
    }

    fun insert(person: Person) {
        id++
        person.id = id
        mMap[id] = person
    }

    fun get(id: Int): Person {
        return if (mMap[id] == null) throw RuntimeException("Person is null") else mMap[id]!!
    }

    fun update(person: Person) {
        if (person.id == null)
            throw RuntimeException("Person id is null")
        else
            mMap[person.id!!] = person
    }

    fun remove(id: Int) {
        mMap.remove(id)
    }
}