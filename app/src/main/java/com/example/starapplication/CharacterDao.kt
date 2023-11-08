package com.example.starapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.starapplication.data.CharacterEntity

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: List<CharacterEntity>)

    @Query("SELECT * FROM character_table")
    fun getAllCharacters(): LiveData<List<CharacterEntity>>

    @Query("SELECT * FROM character_table WHERE name LIKE :searchQuery")
    fun searchCharacters(searchQuery: String): LiveData<List<CharacterEntity>>

    @Query("DELETE FROM character_table")
    fun deleteAllCharacters()




}


