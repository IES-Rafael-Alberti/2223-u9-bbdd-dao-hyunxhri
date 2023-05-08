package DAO

import Ctf

interface CtfDAOInterface {

    fun add(participante: Ctf)
    fun delete(id: Int, grupoId: Int)

}