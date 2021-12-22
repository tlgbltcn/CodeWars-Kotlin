package util

interface Mappers<I, O> {
    fun map(input: I): O
}

interface ListMapper<I, O> : Mappers<List<I>, List<O>?>

open class DTO

open class DomainModel

class OrderMapper : Mappers<OrderDTO, Order> {
    override fun map(input: OrderDTO): Order {
        return Order(
            customer = Customer(
                name = Identity(
                    firstName = input.customerFirstName,
                    lastName = input.customerLastName
                )
            ),
            billingAddress = Address(street = input.billingStreet, city = input.billingCity)
        )
    }
}

class ListMapperImp<I, O>(private val mapper: Mappers<I, O>) : ListMapper<I, O> {
    override fun map(input: List<I>): List<O> {
        return input.map { mapper.map(it) }
    }
}

data class Order(
    var customer: Customer? = null,
    var billingAddress: Address? = null
) : DomainModel()

data class Customer(var name: Identity? = null)

data class Identity(
    var firstName: String? = null,
    var lastName: String? = null
)

data class Address(
    var street: String? = null,
    var city: String? = null
)

data class OrderDTO(
    var customerFirstName: String? = null,
    var customerLastName: String? = null,
    var billingStreet: String? = null,
    var billingCity: String? = null
) : DTO() {

}

fun main() {

    val mapper = OrderMapper()
    val listMapper = ListMapperImp<OrderDTO, Order>(mapper)

    val orderDTO = OrderDTO(
        customerFirstName = "Tolga",
        customerLastName = "Bolatcan",
        billingStreet = "Dumlupınar",
        billingCity = "Istanbul"
    )

    val domainModel = mapper.map(orderDTO)
    println(domainModel::class.java.simpleName)
    println(domainModel)
    println()


    val orderDTOList = listOf<OrderDTO>(
        OrderDTO(
            customerFirstName = "Tolga",
            customerLastName = "Bolatcan",
            billingStreet = "Dumlupınar",
            billingCity = "Istanbul"
        ), OrderDTO(
            customerFirstName = "Hale",
            customerLastName = "Bolatcan",
            billingStreet = "Dumlupınar",
            billingCity = "Istanbul"
        ),
        OrderDTO(
            customerFirstName = "Meryem",
            customerLastName = "Bolatcan",
            billingStreet = "Ostim mah",
            billingCity = "Ankara"
        ),
        OrderDTO(
            customerFirstName = "Ahmet",
            customerLastName = "Bolatcan",
            billingStreet = "Ostim mah",
            billingCity = "Ankara"
        )
    )

    val orderList = listMapper.map(orderDTOList)
    orderList.forEach(::println)

}



