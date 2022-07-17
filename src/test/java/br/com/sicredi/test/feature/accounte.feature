Feature: Account

  @GetNonce
  Scenario: Get Nonce - Endpoint - user/nonce/{publicAddress}
    Given that i execute endpoint for get nonce with
    When When I get the request return with statusCode "200"
    Then the status response on body nonce shold be "true"

  @SendEmailVerification
  Scenario: Send email verification - Endpoint - /account/email-verification
    Given that i execute endpoint for send email verification with email "renatobps06@gmail.com"
    When When I get the request return with statusCode "200"
    Then the field message sholde be the message "Verify email successfully sent"

  @SendRecoverPassword
  Scenario: Send recover password - Endpoint - /account/reset-password
    Given that i execute endpoint for recover password with email "renatobps06@gmail.com"
    When When I get the request return with statusCode "200"
    Then the field message sholde be the message "Reset password email successfully sent"

  @Upload
  Scenario: getUrlUpload - Endpoint - /upload
    Given that i execute endpoint for get upload
    Then When I get the request return with statusCode "200"

