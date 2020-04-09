package com.toranjinotec.behzendegi.persistent_manager.repos;

import org.springframework.data.repository.CrudRepository;

import com.toranjinotec.behzendegi.persistent_manager.model.EtUsers;

public interface IUserRepository extends CrudRepository<EtUsers, String> {

}
