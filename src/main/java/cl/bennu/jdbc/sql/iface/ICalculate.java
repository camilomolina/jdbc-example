package cl.bennu.jdbc.sql.iface;

import cl.bennu.jdbc.dto.CalculateDTO;
import cl.bennu.jdbc.exception.ConnectionException;
import cl.bennu.jdbc.exception.DriverException;

import java.sql.SQLException;
import java.util.List;

public interface ICalculate {

    List<CalculateDTO> getAll() throws SQLException, ConnectionException, DriverException;

    void save(CalculateDTO calculateDTO) throws SQLException, ConnectionException, DriverException;

    void delete(Long id) throws SQLException, ConnectionException, DriverException;

    List<CalculateDTO>  find(CalculateDTO calculateDTO) throws SQLException, ConnectionException, DriverException;

    CalculateDTO get(Long id) throws SQLException, ConnectionException, DriverException;

}
