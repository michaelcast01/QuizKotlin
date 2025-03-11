val productos = mutableListOf<Producto>()

fun crearProducto(codigo: Int, nombre: String, precio: Double, stock: Int) {
    val producto = Producto(codigo, nombre, precio, stock)
    productos.add(producto)
}

fun buscarProducto(codigo: Int): Producto? {
    return productos.find { it.CodigoProducto == codigo }
}

fun mostrarTodosLosProductos() {
    if (productos.isEmpty()) {
        println("No hay productos en el inventario.")
    } else {
        for (producto in productos) {
            producto.mostrarInformacion()
            println("---------------")
        }
    }
}

fun mostrarTotalInventario() {
    var total = 0.0
    for (producto in productos) {
        total += producto.calcularValorTotal()
    }
    println("Valor total de inventario: $total")
}

fun eliminarProducto(codigo: Int): Boolean {
    val producto = buscarProducto(codigo)
    return if (producto != null) {
        productos.remove(producto)
        true
    } else {
        false
    }
}

fun main() {
    var opcion: Int
    do {
        println("\nmenu")
        println("1. Crear producto")
        println("2. Vender producto")
        println("3. Reponer stock")
        println("4. Aplicar descuento")
        println("5. Mostrar productos")
        println("6. Aumentar precio")
        println("7. Mostrar total inventario")
        println("8. Eliminar producto")
        println("0. Salir")
        print("Opción: ")

        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                print("Código: ")
                val codigo = readLine()?.toIntOrNull() ?: 0

                print("Nombre: ")
                val nombre = readLine() ?: ""

                print("Precio: ")
                val precio = readLine()?.toDoubleOrNull() ?: 0.0

                print("Stock: ")
                val stock = readLine()?.toIntOrNull() ?: 0

                crearProducto(codigo, nombre, precio, stock)
                println("Producto creado")
            }
            2 -> {
                print("Código: ")
                val codigo = readLine()?.toIntOrNull() ?: 0

                print("Cantidad: ")
                val cantidad = readLine()?.toIntOrNull() ?: 0

                val producto = buscarProducto(codigo)
                if (producto != null && producto.vender(cantidad)) {
                    println("Venta realizada")
                } else {
                    println("No hay suficiente stock")
                }
            }
            3 -> {
                print("Código: ")
                val codigo = readLine()?.toIntOrNull() ?: 0

                print("Cantidad: ")
                val cantidad = readLine()?.toIntOrNull() ?: 0

                val producto = buscarProducto(codigo)
                if (producto != null) {
                    producto.reponerStock(cantidad)
                    println("Stock actualizado")
                } else {
                    println("Producto no encontrado")
                }
            }
            4 -> {
                print("Código: ")
                val codigo = readLine()?.toIntOrNull() ?: 0

                val producto = buscarProducto(codigo)
                if (producto != null) {
                    producto.aplicarDescuento(2.0)
                    println("Descuento aplicado")
                } else {
                    println("Producto no encontrado")
                }
            }
            5 -> {
                mostrarTodosLosProductos()
            }
            6 -> {
                print("Código: ")
                val codigo = readLine()?.toIntOrNull() ?: 0

                val producto = buscarProducto(codigo)
                if (producto != null) {
                    producto.aumentarPrecio(6.0)
                    println("Precio aumentado")
                } else {
                    println("Producto no encontrado")
                }
            }
            7 -> {
                mostrarTotalInventario()
            }
            8 -> {
                print("Código: ")
                val codigo = readLine()?.toIntOrNull() ?: 0

                if (eliminarProducto(codigo)) {
                    println("Producto eliminado")
                } else {
                    println("Producto no encontrado")
                }
            }
            0 -> println("Saliendo...")
            else -> println("Opción inválida")
        }
    } while (opcion != 0)
}
