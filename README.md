# Android Functional Validation

Simple form validation using [Arrow](http://arrow-kt.io/)

## Option - [PR](https://github.com/dcampogiani/AndroidFunctionalValidation/pull/1) - [Doc](http://kategory.io/docs/datatypes/option/)
Using this data type we can't know which field is wrong.

<img src="https://github.com/dcampogiani/AndroidFunctionalValidation/blob/master/demo/option.gif?raw=true" width="200">

## Either - [PR](https://github.com/dcampogiani/AndroidFunctionalValidation/pull/2) - [Doc](http://kategory.io/docs/datatypes/either/)
Using this data type we know which field is wrong, but when both are wrong we get just the first error.

<img src="https://github.com/dcampogiani/AndroidFunctionalValidation/blob/master/demo/either.gif?raw=true" width="200">

## Validated With Nel String - [Commit](https://github.com/dcampogiani/AndroidFunctionalValidation/pull/4/commits/ed25ac78b4328af23c42b05ae9f9af6e8199c769) - [Doc](http://kategory.io/docs/datatypes/validated/)
 Using this data type we are accumulating all errors in a NotEmptyList so we get all of them. But we are still not showing them in the proper UI.

<img src="https://github.com/dcampogiani/AndroidFunctionalValidation/blob/master/demo/validatedString.gif?raw=true" width="200">

## Validated With Nel ValidationError - [Commit](https://github.com/dcampogiani/AndroidFunctionalValidation/pull/4/commits/ec9d6b9a4c3b9b8b4833451bd2f78d21627c9bd4) - [Doc](http://kategory.io/docs/datatypes/validated/)
Using this data type we are accumulating all errors in a NotEmptyList so we get all of them. Using a sealed class instead just a string allows us to understand exactly which field is wrong and we can show errors in right TextInputLayout

<img src="https://github.com/dcampogiani/AndroidFunctionalValidation/blob/master/demo/validatedValidationError.gif?raw=true" width="200">
