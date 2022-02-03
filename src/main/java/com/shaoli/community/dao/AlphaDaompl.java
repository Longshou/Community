package com.shaoli.community.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AlphaDaompl implements AlphaDao{
    @Override
    public String select() {
        return "123";
    }
}
