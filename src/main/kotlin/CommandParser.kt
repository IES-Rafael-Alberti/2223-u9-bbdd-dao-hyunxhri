import DAO.CtfDAO
import DAO.GrupoDAO

class CommandParser (private var comando : String) {

    fun compruebaComando() {
        val regexA = """^-a\s+\S+(\s+\S+)+(\s+\S+)$""".toRegex()
        val regexD = """^-d\s+\S+(\s+\S+)$""".toRegex()
        val regexL = """^-l\s+\S$""".toRegex()
        println("Comando recibido: '$comando'")
        val listaParametros = comando.split(" ").toMutableList()
        listaParametros.removeAt(0)
        val listaParametrosInt = listaParametros.map { it.toInt()}
        if (comando.startsWith("-a") && regexA.matches(comando)) {
            val participante = Ctf(listaParametrosInt[0], listaParametrosInt[1], listaParametrosInt[2])
            CtfDAO().add(participante)
        }
        else if (comando.startsWith("-d") && regexD.matches(comando)) {
            CtfDAO().delete(listaParametrosInt[0], listaParametrosInt[1])
        }
        else if (comando.startsWith("-l") && regexL.matches(comando)) {
            GrupoDAO().listar(listaParametrosInt[0])
        }
        else println("ERROR: El número de parametros no es adecuado.\n")
    }
}