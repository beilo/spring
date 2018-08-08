package com.leipeng.pojo

/**
 * 500 .BeanInstantiationException: Could not instantiate bean class [com.leipeng.pojo.Person]: No default constructor found; nested exception is java.lang.NoSuchMethodException: com.leipeng.pojo.Person.<init>()
 *
 * https://stackoverflow.com/questions/35981697/use-kotlin-for-springmvc-could-not-instantiate-bean-class-dataclass?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
 */
data class Person(var id: Int? = null,
                  var name: String? = null,
                  var age: Int? = null,
                  var photoPath: String? = null) {


    override fun toString(): String {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\''.toString() +
                ", age=" + age +
                '}'.toString()
    }
}
