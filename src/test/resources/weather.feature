Feature: Weather

  Scenario: Check correct Weather data
    Given show test name

  Scenario: Checking coordinates for city
    Given city "London"
    And country "UK"

    When we are requesting weather data
    Then lon is -0.13
    And lat is 51.51

    And weather is:

      | id          | 300                     |
      | main        | Drizzle                 |
      | description | light intensity drizzle |
      | icon        | 09d                     |

    And base is "stations"

    And temp is 280.32
    And pressure is 1012
    And humidity is 81
    And temp_min 279.15
    And temp_max 281.15

    And visibility is 10000
    And speed is 4.1
    And deg is 80
    And all is 90

    And dt is 1485789600

    And type is 1
    And id_sys is 5091
    And message is 0.0103
    And country is "GB"
    And sunrise is 1485762037
    And sunset is 1485794875

    And id is 2643743
    And name is "London"
    And cod is 200



