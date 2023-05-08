package DAO

import Ctf
import Database.CTFDataSource

class CtfDAO : CtfDAOInterface {

    private val CTFDataSource = CTFDataSource()

    override fun add (participante : Ctf) {
        CTFDataSource.addParticipant(participante)
        println("Procesado: Añadida participación del grupo ${participante.grupoId} en el " +
                "CTF ${participante.id} con una puntuación de ${participante.puntuacion} puntos.")
    }

    override fun delete (id: Int, grupoId: Int) {
        CTFDataSource.deleteParticipant(id, grupoId)
        println("Procesado: Eliminada participación del grupo $grupoId en el " +
                "CTF $id.")
    }
}