package org.csu.javaweb.service;

import org.csu.javaweb.domain.Log;
import org.csu.javaweb.persistence.LogDao;
import org.csu.javaweb.persistence.impl.LogDaoImpl;

public class LogService {

    Log log;
    private LogDao logDao;

    public LogService(){
        log = new Log();
         logDao= new LogDaoImpl();
    }

    public String logInfo(Object ...s){
        return log.logInfomation(s);
    }

    public void insertLogInfo(String username, String logInfo){
        logDao.insertLog(username, logInfo);
    }
}
