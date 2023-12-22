
fun calcularPreuBase(versio: String): Double {
    return when (versio) {
        "camper" -> 93490.0
        else -> 73490.0
    }
}
/**
 * Calcula el precio actual de la furgoneta teniendo en cuenta diferentes factores como la depreciación.
 * @return Precio actualizado de la furgoneta.
 */
fun calcularPreuActual(PneumaticsEstat: Double, preuBase: Double, TéPortabicis: Boolean, EdatVehicle: Int): Double {
    val depreciacioPerKilometre = when {
        EdatVehicle >= 6 && EdatVehicle <= 10 -> 0.0002
        EdatVehicle > 10 -> 0.0004
        else -> 0.00001
    }

    val quilometresRecorreguts = llegirLong("${colorRojo()}Quants quilòmetres ha recorregut la furgo?", 0.0, 100000.0)
    val depreciacio = preuBase * depreciacioPerKilometre * quilometresRecorreguts
    val preuAmbAjust = preuBase - PneumaticsEstat

    val preuTéPortabicis = if (TéPortabicis) {
        preuAmbAjust + 250
    } else preuAmbAjust

    return if (preuTéPortabicis - depreciacio < 0) {
        0.0
    } else preuTéPortabicis - depreciacio
}