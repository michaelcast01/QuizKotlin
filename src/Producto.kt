class Producto {
    var CodigoProducto: Int = 0
    var NombreProducto: String = ""
    var PrecioProducto: Double = 0.0
    var Stock: Int = 0

    constructor()
    constructor(CodigoProducto: Int, NombreProducto: String, PrecioProducto: Double, Stock: Int) {
        this.CodigoProducto = CodigoProducto
        this.NombreProducto = NombreProducto
        this.PrecioProducto = PrecioProducto
        this.Stock = Stock
    }

    fun vender(cantidad: Int): Boolean {
        if (cantidad <= Stock) {
            Stock -= cantidad
            return true
        }
        return false
    }

    fun reponerStock(cantidad: Int) {
        Stock += cantidad
    }

    fun aplicarDescuento(porcentaje: Double) {
        PrecioProducto -= PrecioProducto * (porcentaje / 100)
    }

    fun mostrarInformacion() {
        println("Código: $CodigoProducto")
        println("Nombre: $NombreProducto")
        println("Precio: $PrecioProducto")
        println("Stock: $Stock")
        println("Valor total en inventario: " + calcularValorTotal())
    }

    fun aumentarPrecio(porcentaje: Double) {
        PrecioProducto += PrecioProducto * (porcentaje / 100)
    }

    fun calcularValorTotal(): Double {
        return PrecioProducto * Stock
    }

    override fun toString(): String {
        return "Producto(CodigoProducto=$CodigoProducto, NombreProducto='$NombreProducto', PrecioProducto=$PrecioProducto, Stock=$Stock)"
    }
}
