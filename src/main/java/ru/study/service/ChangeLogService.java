package ru.study.service;

import ru.study.model.ChangeLog;
import ru.study.model.param.CreateChangeLogParam;
import ru.study.repository.ChangeLogRepository;

import java.sql.SQLException;
import java.util.List;


public class ChangeLogService {

    private final ChangeLogRepository changeLogRepository;

    public ChangeLogService() {
        changeLogRepository = new ChangeLogRepository();
    }

    public void createChangeLog(CreateChangeLogParam createChangeLogParam){
        changeLogRepository.insertChangeLog(createChangeLogParam);
    }

    public List<ChangeLog> getChangeLogs(){
        return changeLogRepository.getChangeLogDB();
    }

    public List<ChangeLog> getChangeLogsById(Long employeeId) {
        return changeLogRepository.getChangeLogsById(employeeId);
    }

}
