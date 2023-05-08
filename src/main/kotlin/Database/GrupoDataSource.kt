package Database

import i
import java.sql.DriverManager
import java.sql.SQLException

class GrupoDataSource {

    fun listaGrupos(grupoId: Int) {
        val connection = DriverManager.getConnection("jdbc:h2:./default", "usuario", "usuario")
        try {
            val statement = connection.prepareStatement("SELECT * FROM GRUPOS WHERE GRUPOID = $grupoId")
            val grupoInf = statement.executeQuery()
            grupoInf.next()
            val grupoDesc = grupoInf.getString(2)
            val mejorCTF = grupoInf.getObject(3)
            println("Processed: Group $grupoDesc participation info:")
            println("GROUP: $grupoId $grupoDesc BEST CTF: $mejorCTF")
            i("Database.GrupoDataSource.listaGrupos", "Participante $grupoId listado.")
            statement.close()
            connection.close()
        } catch (e: SQLException) {
            val sql = "SELECT * FROM GRUPOS;"
            val statement = connection.prepareStatement(sql)
            val grupoInf = statement.executeQuery()
            while (grupoInf.next()) {
                val grupoId = grupoInf.getInt(1)
                val grupoDesc = grupoInf.getString(2)
                val mejorCTF = grupoInf.getObject(3)
                println("Procesado: Listado participación del grupo $grupoDesc:")
                println("GRUPO:: $grupoId $grupoDesc MEJORCTF: $mejorCTF\n")
                println()
            }
            i("Database.GrupoDataSource.listaGrupos", "Participantes listados.")
        }
    }
}