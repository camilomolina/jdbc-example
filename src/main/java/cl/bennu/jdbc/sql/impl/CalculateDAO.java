package cl.bennu.jdbc.sql.impl;

import cl.bennu.jdbc.builder.JDBCBuilder;
import cl.bennu.jdbc.dto.CalculateDTO;
import cl.bennu.jdbc.dto.ConnectionData;
import cl.bennu.jdbc.enums.DriverEnum;
import cl.bennu.jdbc.exception.ConnectionException;
import cl.bennu.jdbc.exception.DriverException;
import cl.bennu.jdbc.sql.iface.ICalculate;
import cl.bennu.jdbc.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalculateDAO implements ICalculate {

    public List<CalculateDTO> getAll() throws SQLException, ConnectionException, DriverException {
        ConnectionData connectionData = JDBCBuilder.buildConnectionData();

        Connection connection = JDBCUtils.getConnection(DriverEnum.MYSQL, connectionData);
        Statement statement = connection.createStatement();

        String sql = "SELECT ID, IP, USUARIO, CALCULO, RESULTADO, FECHA FROM CALCULOS";

        List<CalculateDTO> list = new ArrayList<CalculateDTO>();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            CalculateDTO dto = new CalculateDTO();
            dto.setId(resultSet.getLong(1));
            dto.setIp(resultSet.getString(2));
            dto.setUser(resultSet.getString(3));
            dto.setCalculate(resultSet.getString(4));
            dto.setResult(resultSet.getDouble(5));
            dto.setDate(resultSet.getDate(6));

            list.add(dto);
        }

        JDBCUtils.closeConnection(connection);

        return list;
    }

    public void save(CalculateDTO calculateDTO) throws SQLException, ConnectionException, DriverException {
        ConnectionData connectionData = JDBCBuilder.buildConnectionData();

        Connection connection = JDBCUtils.getConnection(DriverEnum.MYSQL, connectionData);

        String insert = "INSERT INTO CALCULOS (IP, USUARIO, CALCULO, RESULTADO, FECHA) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insert);
        statement.setString(1, calculateDTO.getIp());
        statement.setString(2, calculateDTO.getUser());
        statement.setString(3, calculateDTO.getCalculate());
        statement.setDouble(4, calculateDTO.getResult());
        statement.setDate(5, new Date(calculateDTO.getDate().getTime()));

        statement.execute();

        JDBCUtils.closeConnection(connection);
    }

    public void delete(Long id) throws SQLException, ConnectionException, DriverException {
        ConnectionData connectionData = JDBCBuilder.buildConnectionData();

        Connection connection = JDBCUtils.getConnection(DriverEnum.MYSQL, connectionData);

        String delete = "DELETE FROM CALCULOS WHERE ID = ?";
        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setLong(1, id);

        statement.execute(delete);

        JDBCUtils.closeConnection(connection);
    }

    public List<CalculateDTO> find(CalculateDTO calculateDTO) throws SQLException, ConnectionException, DriverException {
        ConnectionData connectionData = JDBCBuilder.buildConnectionData();

        Connection connection = JDBCUtils.getConnection(DriverEnum.MYSQL, connectionData);

        String sql = "SELECT ID, IP, USUARIO, CALCULO, RESULTADO, FECHA FROM CALCULOS";
        Statement statement = connection.createStatement();

        List<CalculateDTO> list = new ArrayList<CalculateDTO>();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            CalculateDTO dto = new CalculateDTO();
            dto.setId(resultSet.getLong(1));
            dto.setIp(resultSet.getString(2));
            dto.setUser(resultSet.getString(3));
            dto.setCalculate(resultSet.getString(4));
            dto.setResult(resultSet.getDouble(5));
            dto.setDate(resultSet.getDate(6));

            list.add(dto);
        }

        JDBCUtils.closeConnection(connection);

        return list;
    }

    public CalculateDTO get(Long id) throws SQLException, ConnectionException, DriverException {
        ConnectionData connectionData = JDBCBuilder.buildConnectionData();

        Connection connection = JDBCUtils.getConnection(DriverEnum.MYSQL, connectionData);

        String sql = "SELECT ID, IP, USUARIO, CALCULO, RESULTADO, FECHA FROM CALCULOS WHERE ID = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setLong((int) 1L, id);

        CalculateDTO dto = null;
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            dto = new CalculateDTO();
            dto.setId(resultSet.getLong(1));
            dto.setIp(resultSet.getString(2));
            dto.setUser(resultSet.getString(3));
            dto.setCalculate(resultSet.getString(4));
            dto.setResult(resultSet.getDouble(5));
            dto.setDate(resultSet.getDate(6));
        }

        JDBCUtils.closeConnection(connection);

        return dto;
    }
}
