package edu.towson.cosc435.hatran.tipcalculatoractivity


import kotlin.math.round

enum class ConvertType{ T10, T20, T30}

fun convertTemp(input: Double, convertType: ConvertType): Double {
    val result = when(convertType) {
        ConvertType.T10 -> (input)*(10/100.0)
        ConvertType.T20 -> (input) * (20/100.0)
        ConvertType.T30 -> (input) *(30/100.0)


    }
    return result.round(2)
}

private fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}