package com.mes.dao;

import com.mes.entity.Account;
import lombok.Getter;

import java.util.Date;
import java.util.List;

public class AccountDao extends JpaDao<Account> implements GenericDao<Account> {

    @Override
    public Account create(Account account) {
        account.setCreatedAt(new Date());
        account.setUpdatedAt(new Date());
        return super.create(account);
    }

    @Override
    public Account find(Object id) {
        return super.find(Account.class, id);
    }

    @Override
    public Account update(Account account) {
        account.setUpdatedAt(new Date());
        return super.update(account);
    }

    @Override
    public void delete(Object id) {
        super.delete(Account.class, id);
    }

    @Override
    public List<Account> findAll() {
        return super.findWithNamedQuery("Account.findAll");
    }
}
