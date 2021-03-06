package byAJ.Securex;

import byAJ.Securex.models.AppRoleRepository;
import byAJ.Securex.models.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findAppUserByUsername(String username);
}
