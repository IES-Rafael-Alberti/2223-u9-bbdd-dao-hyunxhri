package DAO

import Database.GrupoDataSource

class GrupoDAO : GrupoDAOInterface {

    override fun listar(grupoId : Int) {
        val participantes = GrupoDataSource().listaGrupos(grupoId)
        println(participantes)
    }
}