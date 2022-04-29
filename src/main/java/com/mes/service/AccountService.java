package com.mes.service;

import com.mes.dao.AccountDao;
import com.mes.dto.AccountDto;
import com.mes.entity.Account;

import java.sql.SQLOutput;
import java.util.List;

public class AccountService {

    private AccountDao accountDao = new AccountDao();

    //거래처 등록
    public Account createAccount(AccountDto accountDto) {

        Account account = new Account();
        account.setAccountCode(accountDto.getAccountCode());
        account.setName(accountDto.getName());

        Account createAccount = accountDao.create(account);

        if (createAccount == null) {
            System.out.println("거래처 등록실패");
            return null;
        }
        return createAccount;
    }

    //거래처 수정
    public Account updateAccount(AccountDto accountDto) {

        Account account = new Account();
        account.setId(accountDto.getId());
        account.setAccountCode(accountDto.getAccountCode());
        account.setName(accountDto.getName());

        Account updateAccount = accountDao.update(account);

        if (updateAccount == null) {
            System.out.println("거래처 수정 실패");
            return null;
        }
        return updateAccount;
    }

    //거래처 리스트
    public List<Account> findAllUser() {
        return accountDao.findWithNamedQuery("Account.findAll");
    }

    //아이디로 회원찾기
    public Account findAccountById(Integer id) {
        return accountDao.find(id);
    }
}
