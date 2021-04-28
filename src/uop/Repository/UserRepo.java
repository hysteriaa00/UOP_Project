package uop.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import uop.Model.Gender;
import uop.Model.Role;
import uop.Model.User;

public class UserRepo {

    private static final String PATH = System.getProperty("user.dir") + "/data/users.txt";

    public static Optional<User> findByUsernameAndPassword(String username, String password) throws IOException {
        return findAll()
                .stream()
                .filter(e -> e.getUsername().equals(username)
                && e.getPassword().equals(password))
                .findFirst();
    }
    public static Optional<User> findByUsername(String username) throws IOException
    {
         return findAll()
                .stream()
                .filter(e -> e.getUsername().equals(username))
                
                .findFirst();
     
    }
    public static List<User> findAll() throws FileNotFoundException, IOException {
        ArrayList<User> retList = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            while ((line = reader.readLine()) != null) {
                final User user = new User();
                String[] split = line.split(";");
                user.setUsername(split[0]);
                user.setPassword(split[1]);
                user.setName(split[2]);
                user.setSurname(split[3]);
                user.setJmbg(split[4]);
                user.setAddress(split[5]);
                user.setGender(Gender.valueOf(split[6]));
                user.setTelephone(split[7]);
                user.setRole(Role.valueOf(split[8]));
                retList.add(user);
            }
        }
        return retList;
    }
}
