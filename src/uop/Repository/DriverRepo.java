/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uop.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import uop.Model.Driver;
import uop.Model.Gender;
import uop.Model.Role;
import uop.Model.User;


public class DriverRepo {
    
     private static final String PATH = System.getProperty("user.dir") + "/data/drivers.txt";
    public static List<Driver> findAll() throws IOException
    {
        
       ArrayList<Driver> retList = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            while ((line = reader.readLine()) != null) {
                final Driver driver = new Driver();
                String[] split = line.split(";");
                driver.setSalary(Long.valueOf(split[0]));
                driver.setMembershipCard(split[1]);
                driver.setUser(UserRepo.findByUsername(split[2]).get());
                retList.add(driver);
            }
        }
        return retList;
    }
}
