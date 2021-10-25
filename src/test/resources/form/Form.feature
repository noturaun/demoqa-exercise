Feature: Practice Form
  Scenario Outline: Submit form
    Given A user on the Practice form page
    When User enter <firstName> <lastName> <email> <gender> <phone> <dob>
    And User enter <subject> <hobbies> <picture> <currentAddress> <state> <city>
    Then User submit the form
    Examples:
      | firstName | lastName | email | gender | phone | dob | subject | hobbies | picture | currentAddress | state | city |
      | Muhammad | Syahrul | noturaun@mail.com | Male | 08521234568 | 07-02-1998 | Engineering | Sport | /home/noturaun/Pictures/Win 11 Wallpaper/Windows 11 Wallpaper 30.jpg | Baghdad | NCR | Delhi |