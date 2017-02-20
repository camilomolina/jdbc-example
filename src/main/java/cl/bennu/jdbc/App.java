package cl.bennu.jdbc;

import cl.bennu.jdbc.dto.CalculateDTO;
import cl.bennu.jdbc.sql.iface.ICalculate;
import cl.bennu.jdbc.sql.impl.CalculateDAO;

import java.util.Date;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        ICalculate calculate = new CalculateDAO();

        System.out.println("--todos los calculos--");
        List<CalculateDTO> calculateList = calculate.getAll();
        for (CalculateDTO c : calculateList) {
            System.out.println(c);
        }
        System.out.println("----------------------");

        System.out.println("--insentando un dto---");
        CalculateDTO dto = new CalculateDTO();
        dto.setIp("local");
        dto.setCalculate("343-3");
        dto.setResult(340D);
        dto.setDate(new Date());
        calculate.save(dto);
        System.out.println("----------------------");

        System.out.println("--todos los calculos--");
        calculateList = calculate.getAll();
        for (CalculateDTO c : calculateList) {
            System.out.println(c);
        }
        System.out.println("----------------------");

        System.out.println("--obtiene uno---------");
        dto = calculate.get(1L);
        System.out.println(dto);
        System.out.println("----------------------");

    }

}
