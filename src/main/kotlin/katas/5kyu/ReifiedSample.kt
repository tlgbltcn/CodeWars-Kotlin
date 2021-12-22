package katas.`5kyu`


class TrickyKotlin9<T : Any> {

    // check if `T` is a super class of `anyGetter`'s return value's class!
    inline fun <reified T, reified R>classOrSuperClassOf(anyGetter: () -> R) = R::class.isInstance((T::class))
}