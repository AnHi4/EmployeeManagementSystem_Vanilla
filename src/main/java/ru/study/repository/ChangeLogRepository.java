package ru.study.repository;

import lombok.NoArgsConstructor;
import ru.study.connection_utils.ConnectionHelper;
import ru.study.model.ChangeLog;
import ru.study.model.param.CreateChangeLogParam;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
public class ChangeLogRepository {

    public void insertChangeLog(CreateChangeLogParam createNewChangeLogParam) {
        String insertQuery =
                "INSERT INTO changelogs (employee_id, comment, createdAt) " +
                        "VALUES (?,?,?)";

        try (Connection conn = ConnectionHelper.createConnection();
             PreparedStatement prSt = conn.prepareStatement(insertQuery)) {
            prSt.setLong(1, createNewChangeLogParam.getEmployeeId());
            prSt.setString(2, createNewChangeLogParam.getComment());
            prSt.setDate(3, Date.valueOf(createNewChangeLogParam.getCreatedAt()));

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<ChangeLog> getChangeLogDB() {

        List<ChangeLog> changeLogList = new LinkedList<>();
        String selectAllQuery = "SELECT * FROM changelogs";

        try (Connection conn = ConnectionHelper.createConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(selectAllQuery)) {
            while (rs.next()) {
                long changelog_id = rs.getLong("id");
                long employee_id = rs.getLong("employee_id");
                String comment = rs.getString("comment");
                LocalDate createdAt = rs.getDate("createdAt").toLocalDate();

                ChangeLog tempChangeLog = ChangeLog.builder()
                        .id(changelog_id)
                        .employeeId(employee_id)
                        .comment(comment)
                        .createdAt(createdAt)
                        .build();
                changeLogList.add(tempChangeLog);
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return changeLogList;
    }

    public List<ChangeLog> getChangeLogsById(Long employeeId) {

        List<ChangeLog> changeLogList = new LinkedList<>();
        String selectChangeLogsByEmailQuery = "SELECT * FROM changelogs Where employee_id = ?";

        try (Connection conn = ConnectionHelper.createConnection();
             PreparedStatement prSt = conn.prepareStatement(selectChangeLogsByEmailQuery)) {            ;
            prSt.setLong(1, employeeId);

            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                long changelog_id = rs.getLong("id");
                long employee_id = rs.getLong("employee_id");
                String comment = rs.getString("comment");
                LocalDate createdAt = rs.getDate("createdAt").toLocalDate();

                ChangeLog tempChangeLog = ChangeLog.builder()
                        .id(changelog_id)
                        .employeeId(employee_id)
                        .comment(comment)
                        .createdAt(createdAt)
                        .build();
                changeLogList.add(tempChangeLog);
            }
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
        return changeLogList;
    }
}
