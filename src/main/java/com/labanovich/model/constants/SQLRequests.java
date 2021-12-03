package com.labanovich.model.constants;

public class SQLRequests {
    public static final String GET_ALL_TECHNIC = """
            select id, name, producer, produce_date, service_date, cost
            from technic;
            """;
    public static final String GET_ALL_SURRENDER_TECHNIC = """
            select id, user_id, technic_id, surrender_date, receive_date
            from surrender_technic;
            """;

    public static final String GET_ALL_EMPLOYEE = """
            select id, name, surname, position, phone_number
            from employee;
            """;
    public static final String DELETE_EMPLOYEE_BY_ID = """
            delete
            from employee
            where id = ?;
            """;

    public static final String EDIT_EMPLOYEE_BY_ID = """
            update employee
            set name         = ?,
                surname      = ?,
                position     = ?,
                phone_number = ?
            where id = ?;
            """;

    public static final String DELETE_SURRENDER_TECHNIC = """
            delete
            from surrender_technic
            where id = ?;
            """;

    public static final String RECEIVE_SURRENDER_TECHNIC = """
            update surrender_technic
            set receive_date = now()
            where id = ?;
            """;
    public static final String EDIT_SURRENDER_TECHNIC_DATE = """
            update surrender_technic
            set receive_date = ?
            where id = ?;
            """;

    public static final String ADD_TECHNIC = """
            insert into technic (name, producer, produce_date, service_date, cost, isSurrender)
            values (?, ?, ?, ?, ?, ?);
            """;

    public static final String EDIT_TECHNIC_BY_ID = """
            update technic
            set name         = ?,
                producer     = ?,
                produce_date = ?,
                service_date = ?,
                cost         = ?
            where id = ?;
            """;

    public static final String DELETE_TECHNIC_BY_ID = """
            delete
            from technic
            where id = ?;
            """;

}
