Feature: Validate subscription packages for all countries

  @smoke
  Scenario: Validate subscription packages for country SA
    Given User is on subscription plan page
    When User selects "sa" country
    Then User check subscription details - plan types, price, and currency details
      | Plans   | Price | Currency |
      | LITE    | 15    | SARC     |
      | CLASSIC | 25    | SAR      |
      | PREMIUM | 60    | SAR      |

  @smoke
  Scenario: Validate subscription packages for country Bahrain
    Given User is on subscription plan page
    When User selects "bh" country
    Then User check subscription details - plan types, price, and currency details
      | Plans   | Price | Currency |
      | LITE    | 2     | BHD      |
      | CLASSIC | 3     | BHD      |
      | PREMIUM | 6     | BHD      |

  @smoke
  Scenario: Validate subscription packages for country Kuwait
    Given User is on subscription plan page
    When User selects "kw" country
    Then User check subscription details - plan types, price, and currency details
      | Plans   | Price | Currency |
      | LITE    | 1.2   | KWD      |
      | CLASSIC | 2.5   | KWD      |
      | PREMIUM | 4.8   | KWD      |