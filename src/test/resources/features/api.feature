Feature: Test Automation Rest Api

  @api
  Scenario: Get User By ID normal
    Given prepare url valid for "GET_USER_BY_ID"
    And hit api get user by id
    Then validation status code is equals 200
    Then validation response body get user by id
    Then validation response json with JSONSchema "get_user_by_id_normal.json"

  @api
  Scenario: Test create new user normal
    Given prepare url valid for "CREATE_USER"
    And hit api post create new user
    Then validation status code is equals 200
    Then validation response body post create new user
    Then validation response json with JSONSchema "post_create_new_user_normal.json"

  @api
  Scenario: Test delete user normal
    Given prepare url valid for "CREATE_USER"
    And hit api post create new user
    Then  validation status code is equals 200
    Then validation response body post create new user
    Given prepare url valid for "DELETE_USER"
    And hit api delete new
    Then validation status code is equals 200

    @api
    Scenario: Test update user normal
      Given prepare url valid for "CREATE_USER"
      And hit api post create new user
      Then  validation status code is equals 200
      Then validation response body post create new user
      Given prepare url valid for "UPDATE_USER"
      And hit api update data
      Then validation status code is equals 200
      Then validation response body update user



