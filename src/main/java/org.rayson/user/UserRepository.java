package org.rayson.user;

import org.springframework.stereotype.Repository;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-07-31
 *  Time: 下午6:19
 *  Description:
 **/
@Repository
public interface UserRepository {
    User getById(Integer id);

    User getByUsername(String username);
}
