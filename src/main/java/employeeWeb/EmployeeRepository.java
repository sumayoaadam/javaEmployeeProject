package employeeWeb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// inuu extand gareeyo jpa repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //searching by id
    @Query(value="Select * from employee where id =?1", nativeQuery = true)
    public List<Employee> search(@Param("keyword") Long id);
}
