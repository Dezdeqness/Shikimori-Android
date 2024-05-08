package com.dezdeqness.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dezdeqness.data.datasource.db.dao.AccountDao
import com.dezdeqness.data.datasource.db.dao.GenreDao
import com.dezdeqness.data.datasource.db.dao.UserRatesDao
import com.dezdeqness.data.model.db.AccountLocal
import com.dezdeqness.data.model.db.GenreLocal
import com.dezdeqness.data.model.db.UserRateLocal

@TypeConverters(StatusConverter::class, StatsConverter::class)
@Database(entities = [AccountLocal::class, UserRateLocal::class, GenreLocal::class], version = 2)
abstract class ShikimoriDatabase : RoomDatabase() {

    abstract fun accountDao(): AccountDao

    abstract fun userRatesDao(): UserRatesDao

    abstract fun genreDao(): GenreDao

    companion object {


        @JvmStatic
        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS `genre` (" +
                        "`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                        "`genreId` INTEGER NOT NULL, `name` TEXT NOT NULL, " +
                        "`russian` TEXT NOT NULL, " +
                        "`type` TEXT NOT NULL)")
            }
        }

    }
}
