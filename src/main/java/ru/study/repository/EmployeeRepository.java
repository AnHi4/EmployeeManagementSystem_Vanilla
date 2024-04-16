package ru.study.repository;

import ru.study.connection_utils.ConnectionHelper;
import ru.study.model.param.CreateNewEmployeeParam;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeRepository {

    //private static final List<Employee> employeeDatabase = new ArrayList<>();
    //если в мапу, то возможен обсёр с id какой-нибудь, тк он не включён в поля Емплоии (мне кажется, что опасн крч)
    //private static final Map<Long, Employee> employeeDatabase = new HashMap<>();
    public static final String E_TABLE = "employee";
    public static final String EMPLOYEE_ID = "employee_id";
    public static final String IS_ACTIVE_STATUS = "status";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String FATHERS_NAME = "fathersName";
    public static final String SALARY = "salary";
    public static final String CURRENCY = "currency";
    public static final String EMAIL = "email";
    public static final String SEX = "sex";
    public static final String BIRTHDAY = "birthday";
    public static final String HIREDATE = "hireDate";
    public static final String FIREDATE = "fireDate";

    //нужны ли тут эти константы или они вообще в хуй не упёрлись от слова совсем,
    // потому что в записи запроса проще писать по факту?


    //мысль: при запуске программы все объекты из БД будут заливаться в Листы или Мапы репозиториев
    //после этого работать с этими объектами через копии, как в предыдущей версии
    // и по итогу репы уже будут отдавать запросы на изменения
    //далее, если всё это хуйня и я вообще не оч, то как лучше без Спринга тут реализовать репы

    //вообще в том ли я направлении мыслю по итогу?
    //пока что всё на статике тк вопросы про репу выше
}
