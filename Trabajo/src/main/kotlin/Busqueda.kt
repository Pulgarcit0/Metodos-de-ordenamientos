


import org.w3c.dom.ranges.Range
import javax.swing.JOptionPane
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime


fun main() {
    val num = Integer.parseInt(JOptionPane.showInputDialog("Tamaño:")).toInt()
    val lis: List<IntRange> = listOf(1..num)
    val l:List<String> = listOf(lis.toString())

    val numeroBuscar=JOptionPane.showInputDialog("¿Que numero deseas  buscar dentro del rango 1...$num?")


    Kotlin(l,numeroBuscar)
    Lineal(l,numeroBuscar)
    Binaria(l,numeroBuscar)
    secuencia(num,numeroBuscar.toInt())




}
fun Kotlin(list: List<String>, valorABuscar: String) {


    val tiempo = measureTimeMillis {

        val valorEncontrado = list.find { nombre ->

            nombre.contains(valorABuscar)

        }
    }
        JOptionPane.showMessageDialog(null,"------>>BUSQUEDA CON KOTLIN<<----- \n NUMERO ENCONTRADO: ${valorABuscar} \n TIEMPO:${tiempo} milisegundos ")
        //println(valorEncontrado)



//    println("TIEMPO BUSQUEDA KOTLIN: $tiempo")

}


fun Lineal(list: List<String>, valorABuscar: String): Int? {

    val tiempo = measureTimeMillis {
        for ((index, valor) in list.withIndex()) {
            if (valor == valorABuscar) {
               // println("POSICION ENCONTRADA: $index -> $valor")
                return index
            }
        }
    }
    JOptionPane.showMessageDialog(null,"------>>BUSQUEDA LINEAL<<------ \n VALOR: $valorABuscar \n TIEMPO:$tiempo milisegundos" )
    //println("TIEMPO BUSQUEDA LINEAL: $tiempo")



    return null

}

fun Binaria(list: List<String>, key: String): Int? {

    val tiempo = measureTimeMillis {

        var rangeStart = 0
        var rangeEnd = list.count()
        while (rangeStart < rangeEnd) {
            val midIndex = rangeStart + (rangeEnd - rangeStart) / 2
            if (list[midIndex] == key) {
                //println("INDEX ENCONTRADO: $midIndex")
                return midIndex
            } else if (list[midIndex] < key) {
                rangeStart = midIndex + 1
            } else {
                rangeEnd = midIndex
            }
        }

    }
    JOptionPane.showMessageDialog(null,"------>>BUSQUEDA BINARIA<<------ \n SE BUSCO: $key \n TIEMPO:$tiempo milisegundos")
   // println("TIEMPO BUSQUEDA BINARIA : $tiempo")

    return null
}

fun secuencia(num:Int,numeroBuscar:Int){
    val arregloGenerado = (1..num).toMutableList()

    val listaDesordenada = arregloGenerado.shuffled()

    var pos=0
    var bandera=false

    val tiempoDemorado = measureTimeMillis {
        while (pos < num && bandera == false) {
            if (numeroBuscar == listaDesordenada[pos]) {
                bandera = true
                break
            }
            pos++
        }
    }
    if(bandera==true){
        JOptionPane.showMessageDialog(null,"------>>BUSQUEDA SECEUNCIAL<<------ \n  numero:  $numeroBuscar,"+"\n"+"Numero:  ${pos+1}"+"\n"+"\n"+" Demoro:  $tiempoDemorado milisegundos" )
    }else{
        JOptionPane.showMessageDialog(null,"numero:  $numeroBuscar no se encnotro en la lista")
    }

}

