fun colorVerde() = "\u001B[32m"
fun colorAzul() = "\u001B[34m"
fun colorAmarillo() = "\u001B[33m"
fun colorRojo() = "\u001B[31m"
fun colorLila() = "\u001B[35m"
fun colorReset() = "\u001B[0m"

/**
 * Función principal que inicia la aplicación para calcular el precio de una furgoneta Volkswagen.
 */
fun main() {
    mostrarAsciiArt()
    println("${colorRojo()}Bienvenido a Furgo Amin${colorReset()}")
    val versioFurgo = demanarVersio()
    val PneumaticsEstat = demanarEstatPneumatics()
    mostrarPreus(versioFurgo, PneumaticsEstat)
}

fun mostrarAsciiArt() {
    println(
        """
 _____ _   _ ____   ____  ___          _    __  __ ___ _   _ 
|  ___| | | |  _ \ / ___|/ _ \        / \  |  \/  |_ _| \ | |
| |_  | | | | |_) | |  _| | | |_____ / _ \ | |\/| || ||  \| |
|  _| | |_| |  _ <| |_| | |_| |_____/ ___ \| |  | || || |\  |
|_|    \___/|_| \_\\____|\___/     /_/   \_\_|  |_|___|_| \_|
    """.trimIndent()
    )
}

/**
 * Función para solicitar al usuario la versión de la furgoneta que tiene.
 * @return Versión de la furgoneta: "normal" o "camper".
 */
fun demanarVersio(): String {
    println("${colorLila()}Que Volkswagen Grand California tienes? (normal/camper)${colorReset()}")
    return readln().toLowerCase()
}

/**
 * Función para determinar el estado de los neumáticos y asignar un valor de depreciación.
 * @return Valor de depreciación basado en los kilómetros de los neumáticos.
 */
fun demanarEstatPneumatics(): Int {
    val quilometresPneumatics = llegirLong("${colorAmarillo()}Quants quilòmetres tenen els pneumàtics?${colorReset()}", 0.0, 100000.0)
    return when {
        quilometresPneumatics <= 5000 -> 0
        quilometresPneumatics <= 10000 -> 200
        else -> 300
    }
}

/**
 * Función que muestra el precio base y el precio actual de la furgoneta.
 */
fun mostrarPreus(versioFurgo: String, PneumaticsEstat: Int) {
    val preuBase = calcularPreuBase(versioFurgo)
    val preuActual = calcularPreuActual(PneumaticsEstat.toDouble(), preuBase, false, 0)

    println("${colorRojo()}El preu base de la furgó és: €$preuBase${colorReset()}")
    println("${colorLila()}El preu que té actualment és: €$preuActual${colorReset()}")
}