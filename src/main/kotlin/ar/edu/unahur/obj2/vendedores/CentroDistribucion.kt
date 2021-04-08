package ar.edu.unahur.obj2.vendedores

class CentroDistribucion(val vendedores: List<Vendedor>) {

    //val vendedores = mutableListOf<Vendedor>()

    fun vendedorEstrella() = this.vendedores.maxBy { it.puntajeCertificaciones() }

    fun puedeCubrirCiudad(ciudad: Ciudad) = this.vendedores.any { it.puedeTrabajarEn(ciudad) }

    //"esGenerico()" lo implemente en la clase vendedor
    fun vendedoresGenericos() = this.vendedores.filter { it.esGenerico() }

    fun esRobusto() = this.vendedores.filter { it.esFirme() }.size >= 3
}