package ru.study.service;

import ru.study.connection_utils.ConnectionHelper;
import ru.study.model.ChangeLog;
import ru.study.model.Employee;
import ru.study.model.param.CreateNewChangeLogParam;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ChangeLogService {
    public static void createNewChangeLog(CreateNewChangeLogParam createNewChangeLogParam){
        String insQuery =
                "INSERT INTO changelog (employee_id, comment, createdAt) " +
                        "VALUES (?,?,?)";

        try (PreparedStatement prSt = ConnectionHelper.createConnection().prepareStatement(insQuery)) {
            prSt.setLong(1, createNewChangeLogParam.getEmployeeId());
            prSt.setString(2, createNewChangeLogParam.getComment());
            prSt.setDate(3, Date.valueOf(createNewChangeLogParam.getCreatedAt()));


            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ChangeLog> getChangeLogDB(){

        List<ChangeLog> changeLogList = new LinkedList<>();
        String selectAllQuery = "SELECT * FROM changelog";

        try (
                PreparedStatement prSt = ConnectionHelper.createConnection().prepareStatement(selectAllQuery);
                ResultSet rs = prSt.executeQuery()
        )
        {
            while (rs.next()) {
                long changelog_id = rs.getLong("changelog_id");
                long employee_id = rs.getLong("employee_id");
                String comment = rs.getString("comment");
                LocalDate createdAt = rs.getDate("createdAt").toLocalDate();


                ChangeLog tempChangeLog = ChangeLog.builder()
                        .changeLog_id(changelog_id)
                        .employee_id(employee_id)
                        .comment(comment)
                        .createdAt(createdAt)
                        .build();
                changeLogList.add(tempChangeLog);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return changeLogList;
    }
}
