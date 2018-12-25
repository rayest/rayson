package mobi.rayson.foundation.enums;

import java.util.Arrays;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-11
 *  Time: 下午4:43
 *  Description:
 **/
public class DirectionAcquirement {

    public String getMessage(String code){
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.getCode().equals(code))
                .findFirst()
                .map(Direction::getMessage)
                .orElse(null);
    }
}
