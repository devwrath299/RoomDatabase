package com.example.roomdatabase

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 2)
@TypeConverters(Converters::class)
abstract class ContactDatabase :RoomDatabase(){
    abstract fun contactDao() : ContactDao
    companion object{
        private var INSTANCE: ContactDatabase?=null

        fun getDatabase(context: Context):ContactDatabase
        {
            val migration_1_2= object:Migration(1,2){

                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(0)")
                }
            }



            if(INSTANCE==null)
            {
                INSTANCE= Room.databaseBuilder(context.applicationContext
                    ,ContactDatabase::class.java,
                    "cnDb")
                    .addMigrations(migration_1_2)
                    .build()
            }
            return INSTANCE!!
        }


    }
}
