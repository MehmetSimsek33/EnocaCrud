package EnocaCrud.EnocaCrud.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EnocaCrud.EnocaCrud.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	Company findById(int id);
}
