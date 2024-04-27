package com.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
}
