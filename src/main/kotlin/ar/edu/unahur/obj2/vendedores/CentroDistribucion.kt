package ar.edu.unahur.obj2.vendedores

class CentroDistribucion() {

    val vendedores = mutableListOf<Vendedor>()

    fun vendedorEstrella() = vendedores.maxBy { it.puntajeCertificaciones() }

    fun puedeCubrirCiudad(ciudad: Ciudad) = vendedores.any { it.puedeTrabajarEn(ciudad) }

    //"esGenerico()" lo implemente en la clase vendedor
    fun vendedoresGenericos() = vendedores.filter { it.esGenerico() }

    fun esRobusto() = vendedores.filter { it.esFirme() }.size >= 3
}