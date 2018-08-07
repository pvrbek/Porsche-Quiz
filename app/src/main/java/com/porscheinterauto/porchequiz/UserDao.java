package com.porscheinterauto.porchequiz;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user_entity")
    List<UserEntity> getAllUsers();

    @Insert
    long[] insertAll(UserEntity... users);

    @Query("delete from user_entity where first_name like :badName AND last_name like :badLastName")
    int deleteUser(String badName, String badLastName);
    /*@Query("DELETE FROM user_entity")
    void deleteAll();

    @Delete
    int deleteUsers(UserEntity users);*/
}
