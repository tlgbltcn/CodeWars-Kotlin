package util.creational

import java.lang.Exception

enum class Elements(val id: Int) {
    HELIUM(2),
    LITHIUM(3),
    BERYLLIUM(4),
    BORON(5),
    CARBON(6),
    NITROGEN(7),
    OXYGEN(8),
    FLUORIDE(9),
    NEON(10),
    SODIUM(11),
    MAGNESIUM(12)
}

sealed class Element {
    class Nitrogen(
        override val atomicNumber: Int = Elements.NITROGEN.id, override val atomicMass: Int = 14
    ) : Element()

    class Oxygen(override val atomicNumber: Int = Elements.OXYGEN.id, override val atomicMass: Int = 16) : Element()

    class Fluorine(override val atomicNumber: Int = Elements.FLUORIDE.id, override val atomicMass: Int = 19) : Element()

    class Neon(override val atomicNumber: Int = Elements.NEON.id, override val atomicMass: Int = 20) : Element()

    class Sodium(override val atomicNumber: Int = Elements.SODIUM.id, override val atomicMass: Int = 23) : Element()

    class Magnesium(override val atomicNumber: Int = Elements.MAGNESIUM.id, override val atomicMass: Int = 24) :
        Element()

    abstract val atomicNumber: Int
    abstract val atomicMass: Int
}

interface IElementFactory {
    infix fun create(atomicNumber: Int): Element
}

object ElementFactory : IElementFactory {
    override fun create(atomicNumber: Int): Element {
        return when (atomicNumber) {
            Elements.NITROGEN.id -> Element.Nitrogen()
            Elements.OXYGEN.id -> Element.Oxygen()
            Elements.FLUORIDE.id -> Element.Fluorine()
            Elements.NEON.id -> Element.Neon()
            Elements.SODIUM.id -> Element.Sodium()
            Elements.MAGNESIUM.id -> Element.Magnesium()
            else -> throw Exception("There is no element that belongs to this atomic number.")
        }
    }
}

fun main() {
    val element = ElementFactory create Elements.NITROGEN.id
    println(
        "Element is ${element.javaClass.simpleName}: \n\n" +
                "Atom Number: ${element.atomicNumber}  \n" +
                "Atomic Mass: ${element.atomicMass} \n" +
                "Neutrons: ${element.atomicMass - element.atomicNumber}"
    )
}