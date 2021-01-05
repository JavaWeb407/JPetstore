package org.csu.javaweb.service;

import org.csu.javaweb.domain.Account;
import org.csu.javaweb.persistence.AccountDao;
import org.csu.javaweb.persistence.impl.AccountDaoImpl;


public class AccountService {


  private AccountDao accountDao =new AccountDaoImpl();

  public Account getAccount(String username) {
    return accountDao.getAccountByUsername(username);
  }

  public Account getAccount(String username, String password) {
    Account account = new Account();
    account.setUsername(username);
    account.setPassword(password);
    return accountDao.getAccountByUsernameAndPassword(account);
  }

  public void insertAccount(Account account) {
    accountDao.insertAccount(account);
    accountDao.insertProfile(account);
    accountDao.insertSignon(account);
  }


  public void updateAccount(Account account) {
    accountDao.updateAccount(account);
    accountDao.updateProfile(account);

    if (account.getPassword() != null && account.getPassword().length() > 0) {
      accountDao.updateSignon(account);
    }
  }

}
