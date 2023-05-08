package Database

import Ctf
import i
import java.sql.DriverManager

class CTFDataSource() {

    fun addParticipant(participante : Ctf) {
        val connection = DriverManager.getConnection("jdbc:h2:./default", "usuario", "usuario")
        val statement = connection.prepareStatement("INSERT INTO CTFS(ctfid, grupoId, puntuacion) VALUES (?, ?, ?)")
        statement.setInt(1, participante.id)
        statement.setInt(2, participante.grupoId)
        statement.setInt(3, participante.puntuacion)
        statement.executeUpdate()
        i("Database.CTFDataSource.addParticipant", "Participante añadido.")
        connection.close()
    }

    fun deleteParticipant(id: Int, grupoId: Int){
        val connection = DriverManager.getConnection("jdbc:h2:./default", "usuario", "usuario")
        val statement = connection.prepareStatement("DELETE FROM CTFS WHERE ctfid = $id AND grupoId = $grupoId")
        statement.executeUpdate()
        i("Database.CTFDataSource.deleteParticipant", "Participante borrado.")
        connection.close()
    }
}