package pl.rek.testermatching.services

import pl.rek.testermatching.db.tester.TesterRepository
import spock.lang.Specification
import tester_matching.services.TesterExperienceTestsImpl

class TesterServiceTest extends Specification {
    private TesterRepository testerRepository
    private TesterService testerService
    private static final EXPECTED_TESTERS_BY_DEVICES_BY_COUNTRIES = [new TesterExperienceTestsImpl("Marcel", "Covak", 3)]
    private static final EXPECTED_TESTERS_BY_COUNTRIES = [new TesterExperienceTestsImpl("Adam", "Gate", 40), new TesterExperienceTestsImpl("Becky", "Brownsugar", 13)]
    private static final EXPECTED_TESTERS_ALL = [new TesterExperienceTestsImpl("John", "Smith", 33), new TesterExperienceTestsImpl("Ada", "Storm", 22)]


    def setup() {
        testerRepository = Mock(TesterRepository)
        testerService = new TesterService(testerRepository)
    }

    def "GetTesterByCountry"() {


    }

    def "should return all testers with experience when countries and deviceIds are empty"() {
        given:
        def countries = []
        def deviceIds = []
        def expectedTesters = [new TesterExperienceTestsImpl("John", "Smith", 33), new TesterExperienceTestsImpl("Ada", "Storm", 22)]
        testerRepository.findAllOrderByBugs() >> expectedTesters
        when:
        def testers = testerService.getTestersExperience(countries, deviceIds)

        then:
        testers == expectedTesters
    }

    def "should return testers with experience from given country when countries are given and deviceIds are empty"() {
        given:
        def countries = ["US", "GB"]
        def deviceIds = []
        def expectedTesters = [new TesterExperienceTestsImpl("Adam", "Gate", 40), new TesterExperienceTestsImpl("Becky", "Brownsugar", 13)]

        testerRepository.findAllByCountryInOrderByBugs(_) >> expectedTesters
        when:
        def testers = testerService.getTestersExperience(countries, deviceIds)

        then:
        testers == expectedTesters
    }

    def "should return testers with experience from given country for given device when countries and deviceIds are given"() {
        given:
        def countries = ["US", "GB"]
        def deviceIds = [1, 2, 3]
        def expectedTesters = [new TesterExperienceTestsImpl("Marcel", "Covak", 3)]

        testerRepository.findAllByCountryInAndDevicesInOrderByBugs(_, _) >> expectedTesters
        when:
        def testers = testerService.getTestersExperience(countries, deviceIds)

        then:
        testers == expectedTesters
    }

    def "should return #expectedTesters for #countries and #deviceIds"(countries, deviceIds, expectedTesters) {
        given:
        testerRepository.findAllByCountryInAndDevicesInOrderByBugs(_, _) >> EXPECTED_TESTERS_BY_DEVICES_BY_COUNTRIES
        testerRepository.findAllByCountryInOrderByBugs(_) >> EXPECTED_TESTERS_BY_COUNTRIES
        testerRepository.findAllOrderByBugs() >> EXPECTED_TESTERS_ALL

        when:
        def testers = testerService.getTestersExperience(countries, deviceIds)

        then:
        testers == expectedTesters
        where:
        countries    | deviceIds || expectedTesters
        []           | []        || EXPECTED_TESTERS_ALL
        ["US", "GB"] | []        || EXPECTED_TESTERS_BY_COUNTRIES
        ["US", "GB"] | [1, 2, 3] || EXPECTED_TESTERS_BY_DEVICES_BY_COUNTRIES
    }


}
