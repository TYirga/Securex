package byAJ.Securex.configs;

import byAJ.Securex.AppUserRepository;
import byAJ.Securex.models.AppRole;
import byAJ.Securex.models.AppRoleRepository;
import byAJ.Securex.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Remove the annotation after you have run this method once in a database that persists to storage.
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    AppRoleRepository roleRepo;

    @Autowired
    AppUserRepository userRepository;


    @Override
    public void run(String... strings) throws Exception {

        //Add all data that should be in the database at the beginning of the application
        AppRole role = new AppRole();
        role.setRoleName("USER");
        roleRepo.save(role);

        role = new AppRole();
        role.setRoleName("Admin");
        roleRepo.save(role);

        //Add test data for users

        AppUser user = new AppUser();
        user.setUsername("me");
        user.setPassword("password");
        user.setFirstName("Ahmed");
        user.setLastName("Schmidt");
        user.addRole(roleRepo.findAppRoleByRoleName("USER"));
        userRepository.save(user);

        user=new AppUser();
        user.setUsername("Dave");
        user.setPassword("admin");
        user.setFirstName("NAME");
        user.setLastName("lastName");
        user.addRole(roleRepo.findAppRoleByRoleName("Admin"));
        userRepository.save(user);
    }
}

