package katas.`5kyu`
/*
import junit.framework.TestCase.assertTrue
import org.junit.Test
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
import java.io.File
import java.lang.reflect.ParameterizedType
import java.net.URL
import kotlin.reflect.KClass
import kotlin.reflect.*



/**
 *This is a series of Kotlin tricks.

As we know, Kotlin supports reified, which works only with inline.
If you don't know, search it! It's very useful.

The problem here is, reified dependends on inline. Only functions can be inlined, constructors cannot.

And your task in this Kata is to make a reified constructor!

The exmaple tests and final tests are not the same.

What? You want hint? The description above is a huge hint!

class TrickyKotlin6<T : Any>() {
fun classOrSuperClassOf(anyGetter: () -> Any) = false
}
This is your initial solution, your task is to implement a method of a class that checks if T is a super class of anyGetter's return value's class.

You may do a big refactoring to the initial solution, like changing the function signature.

I will pass some evil things to anyGetter, so please be careful to invoke it (To be honest, you can't call it. I will throw Exceptions inside).
 */

class TrickyKotlin6<T>

inline fun <reified T, reified R> TrickyKotlin6<T>.classOrSuperClassOf(anyGetter: () -> R) =
    R::class.isInstance(T::class)

open class TrickyKotlin6_<S : Any> constructor(val name: String) {
    open fun classOrSuperClassOf(fn: () -> Any) = false

    companion object {
        inline operator fun <reified S : Any> invoke(): TrickyKotlin6_<S> = object : TrickyKotlin6_<S>("foobar") {
            override fun classOrSuperClassOf(fn: () -> Any): Boolean {
                val (a, b) = arrayOf(
                    javaClass.genericSuperclass,
                    fn.javaClass.genericInterfaces[0]
                ).map {
                    (it as ParameterizedType).actualTypeArguments[0].run {
                        (this as? Class<*>) ?: ((this as ParameterizedTypeImpl).rawType as Class<*>)
                    }
                }
                return a.isAssignableFrom(b)
            }
        }
    }
}

class TrickyKotlin6__<T : Any> private constructor(private val cl: KClass<*>) {

    companion object {

        internal inline operator fun <reified T : Any> invoke(): TrickyKotlin6__<T> =
            TrickyKotlin6__(T::class)
    }

    fun classOrSuperClassOf(anyGetter: () -> Any) =
        anyGetter.reflect()?.returnType?.isSubtypeOf(cl.starProjectedType) ?: false
}

class TrickyKotlin6___<T>(val mClass: Class<T>) {
    inline fun <reified U> classOrSuperClassOf(thunk: () -> U): Boolean {
        return mClass.isAssignableFrom(U::class.java);
    }
}

inline fun <reified U> TrickyKotlin6___(): TrickyKotlin6___<U> {
    return TrickyKotlin6___(U::class.java)
}

inline fun <reified T : Any> TrickyKotlin6____() = TrickyKotlin6____<T>(T::class)

class TrickyKotlin6____<T : Any>(val t: KClass<T>) {
    inline fun <reified U : Any> classOrSuperClassOf(anyGetter: () -> U) =
        t == U::class || U::class.allSuperclasses.contains(t)
}

class TrickyKotlin6Test_ {
    @Test
    fun testCase() {
        assertTrue(TrickyKotlin6<String>().classOrSuperClassOf { "" })
        assertTrue(TrickyKotlin6<CharSequence>().classOrSuperClassOf { "" })
        assertTrue(TrickyKotlin6<Comparable<String>>().classOrSuperClassOf { "" })
        assertTrue(TrickyKotlin6<Int>().classOrSuperClassOf { 2333 })
        val num = TrickyKotlin6<Number>()
        assertTrue(num.classOrSuperClassOf { 2333 })
        assertTrue(TrickyKotlin6<Long>().classOrSuperClassOf { 6666L })
        assertTrue(num.classOrSuperClassOf { 6666L })
        assertTrue(TrickyKotlin6<File>().classOrSuperClassOf { File("") })
        assertTrue(TrickyKotlin6<URL>().classOrSuperClassOf { URL("http://ice1000.org") })
        assertTrue(TrickyKotlin6<Collection<String>>().classOrSuperClassOf { listOf("") })
    }
}

 */