Feature: Check Balance: Customer should be able to check their balance.

  Scenario Outline: Check balance by account id
    Given account <id> for whom we have to check balance
    Then Display the account <amount> of the customer
    Examples:
    | id | amount  |
    |  1 | 10000.0 |
    |  2 | 1000.0  |