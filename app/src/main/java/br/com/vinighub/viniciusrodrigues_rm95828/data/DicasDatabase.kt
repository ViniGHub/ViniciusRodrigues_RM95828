package br.com.vinighub.viniciusrodrigues_rm95828.data

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.vinighub.viniciusrodrigues_rm95828.model.DicasModel

/**
 * Uma classe abstrata que serve como o ponto principal de acesso ao banco de dados SQLite para o aplicativo.
 * Esta classe é anotada com @Database, listando todas as entidades que devem ser criadas no banco de dados.
 * A classe estende RoomDatabase, que é uma classe do Room Persistence Library que contém o banco de dados.
 * Dentro da classe, você define um método abstrato para cada @Dao que está associado ao banco de dados.
 *
 * @author Ewerton Carreira
 * @version 1.0
 * @since 2023-03-01
 */
@Database(entities = [DicasModel::class], version = 1)
abstract class DicasDatabase : RoomDatabase() {

    /**
     * Este método abstrato serve como um ponto de acesso para a classe DAO.
     * Quando este método é chamado, o Room irá gerar uma implementação.
     *
     * @return uma instância da classe DAO (ItemDao).
     */
    abstract fun itemDao(): DicasDao
}