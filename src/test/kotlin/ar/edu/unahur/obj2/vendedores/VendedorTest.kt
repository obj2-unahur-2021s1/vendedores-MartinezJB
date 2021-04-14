package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class VendedorTest : DescribeSpec({
  val misiones = Provincia(1300000)
  val sanIgnacio = Ciudad(misiones)

  describe("Vendedor fijo") {
    val obera = Ciudad(misiones)
    val vendedorFijo = VendedorFijo(obera)

    describe("puedeTrabajarEn") {
      it("su ciudad de origen") {
        vendedorFijo.puedeTrabajarEn(obera).shouldBeTrue()
      }
      it("otra ciudad") {
        vendedorFijo.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
      }
    }
    describe("esVersatil") {
      it("con 2 certificaciones") {
        val certificacion1 = Certificacion(true, 10)
        val certificacion2 = Certificacion(true, 10)
        vendedorFijo.agregarCertificacion(certificacion1)
        vendedorFijo.agregarCertificacion(certificacion2)
        vendedorFijo.esVersatil().shouldBeFalse()
      }
      it("con 3 certificaciones de producto") {
        val certificacion1 = Certificacion(true, 10)
        val certificacion2 = Certificacion(true, 10)
        val certificacion3 = Certificacion(true, 10)
        vendedorFijo.agregarCertificacion(certificacion1)
        vendedorFijo.agregarCertificacion(certificacion2)
        vendedorFijo.agregarCertificacion(certificacion3)
        vendedorFijo.esVersatil().shouldBeFalse()
      }
      it("con 3 certificaciones, una que no es de producto") {
        val certificacion1 = Certificacion(true, 10)
        val certificacion2 = Certificacion(false, 10)
        val certificacion3 = Certificacion(true, 10)
        vendedorFijo.agregarCertificacion(certificacion1)
        vendedorFijo.agregarCertificacion(certificacion2)
        vendedorFijo.agregarCertificacion(certificacion3)
        vendedorFijo.esVersatil().shouldBeTrue()
      }
    }
    describe("esFirme") {
      it("con una certificacion de 10 puntos") {
        val certificacion1 = Certificacion(true, 10)
        vendedorFijo.agregarCertificacion(certificacion1)
        vendedorFijo.esFirme().shouldBeFalse()
      }
      it("con 2 certificaciones de 15") {
        val certificacion1 = Certificacion(true, 15)
        val certificacion2 = Certificacion(true, 15)
        vendedorFijo.agregarCertificacion(certificacion1)
        vendedorFijo.agregarCertificacion(certificacion2)
        vendedorFijo.esFirme().shouldBeTrue()
      }
    }
    describe("esInfluyente"){
      it("test 1") {
        vendedorFijo.esInfluyente().shouldBeFalse()
      }
    }
  }

  describe("Viajante") {
    val cordoba = Provincia(2000000)
    val villaDolores = Ciudad(cordoba)
    val viajante = Viajante(listOf(misiones))

    describe("puedeTrabajarEn") {
      it("una ciudad que pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(sanIgnacio).shouldBeTrue()
      }
      it("una ciudad que no pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(villaDolores).shouldBeFalse()
      }
    }
    describe("esInfluyente"){
      it("con poblacion de 2.000.000") {
        viajante.esInfluyente().shouldBeFalse()
      }
      it("con poblacion de 10.000.000") {
        val buenosAires = Provincia(10000000)
        val caba = Ciudad(buenosAires)
        val viajante2 = Viajante(listOf(buenosAires))
        viajante2.esInfluyente().shouldBeTrue()
      }
    }
  }
  describe("centro de Distribucion") {
    val cordoba = Provincia(2000000)
    val villaDolores = Ciudad(cordoba)
    val viajante = Viajante(listOf(misiones))
    val centro1 = CentroDistribucion(mutableListOf(viajante))

    //********************\***/********************
    //*********************\*/*********************
    //**********************x**********************
    //*********************/*\*********************
    //********************/***\********************
    describe("vendedorEstrella") {
      it("vendedor estrella") {
        //centro1.vendedorEstrella().shouldBeTrue()
      }
      it("una ciudad que no pertenece a una provincia habilitada") {
        //centro1.vendedorEstrella().shouldBeFalse()
      }
    }
  }
})
