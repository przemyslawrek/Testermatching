package pl.rek.tester_matching.tester;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TesterRepository extends JpaRepository<Tester, Long> {
    List<Tester> findAllByCountry(String country);

    @Query("SELECT t.firstName as firstName, t.lastName as lastName, count(b) as experience\n" +
            "FROM Tester t\n" +
            "INNER JOIN t.bugs b\n" +
            "WHERE t.country IN :countries\n" +
            "    AND b.device.deviceId IN :deviceIds\n" +
            "GROUP BY t.firstName, t.lastName\n" +
            "ORDER BY experience DESC")
    List<ITesterExperience> findAllByCountryInAndDevicesInOrderByBugs(@Param("countries") Collection<String> countries, @Param("deviceIds") Collection<Long> deviceIds);

    @Query("SELECT t.firstName as firstName, t.lastName as lastName, count(b) as experience\n" +
            "FROM Tester t\n" +
            "INNER JOIN t.bugs b\n" +
            "WHERE t.country IN :countries\n" +
            "GROUP BY t.firstName, t.lastName\n" +
            "ORDER BY experience DESC")
    List<ITesterExperience> findAllByCountryInOrderByBugs(@Param("countries") Collection<String> countries);

    @Query("SELECT t.firstName as firstName, t.lastName as lastName, count(b) as experience\n" +
            "FROM Tester t\n" +
            "INNER JOIN t.bugs b\n" +
            "WHERE b.device.deviceId IN :deviceIds\n" +
            "GROUP BY t.firstName, t.lastName\n" +
            "ORDER BY experience DESC")
    List<ITesterExperience> findAllByDevicesInOrderByBugs(@Param("deviceIds") Collection<Long> deviceIds);

    @Query("SELECT t.firstName as firstName, t.lastName as lastName, count(b) as experience\n" +
            "FROM Tester t\n" +
            "INNER JOIN t.bugs b\n" +
            "GROUP BY t.firstName, t.lastName\n" +
            "ORDER BY experience DESC")
    List<ITesterExperience> findAllOrderByBugs();

    @Query("Select distinct t.country FROM Tester t")
    List<String> findDistinctCountry();
}
