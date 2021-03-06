Feature: Tranfer money: should be able to transfer money between accounts.
  Should be able to check new balance after the transfer is completed.

  Scenario Outline: Tranfer money between two customers by their account ID.
    Given account <id1> who transfers <amount0> to account <id2>
    When user chooses transfer feature
    Then new balance for accounts should be <amount1> and <amount2>
    Examples:
      | id1 | amount0 | id2 | amount1 | amount2 |
      | 1   | 200.0   | 3   | 9800.0  | 300.0   |
      | 2   | 888.5   | 3   | 111.5   | 1188.5  |
