@product
Feature: Add new product

  Scenario: Add new a product
    Given the path "add" to the endpoint
    And the payload of the request with BrandName as "Dell", Features as "8GB RAM,1TB Hard Drive", LaptopName as "Latitude"
    When I perform the request to add new product
    Then the status code "200" should return
    And the product is added successfully with an integer Id

  Scenario: Add new product with invalid payload (json request body)
    Given the path "add" to the endpoint
    But I supply invalid json
    When I perform the request to add new product
    Then the status code "400" should return

