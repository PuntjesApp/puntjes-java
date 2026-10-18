# Changelog

## [1.2.0](https://github.com/PuntjesApp/puntjes-java/compare/1.1.0...1.2.0) (2026-10-18)


### ⚠ BREAKING CHANGES

* redemptions verify now takes a body. The spec made the body optional, but the generator makes it a required argument.
  The four methods of `VerifyRequestBuilder` (`post`, `toPostRequestInformation`, and their overloads with a configuration) take a `VerifyRedemptionData` as first argument.
  * before: `.verify().post()`
  * after: `.verify().post(new VerifyRedemptionData())`
  * 1.2.1 makes the body optional again, so both calls work.


### Features

* regenerate from puntjes-openapi v2.2.0 ([#5](https://github.com/PuntjesApp/puntjes-java/issues/5)) ([b30e38d](https://github.com/PuntjesApp/puntjes-java/commit/b30e38dc6b0c907c81921c23542ca375a02fabb0))

## [1.1.0](https://github.com/PuntjesApp/puntjes-java/compare/1.0.0...1.1.0) (2026-10-15)


### Features

* regenerate from puntjes-openapi v2.1.0 ([#3](https://github.com/PuntjesApp/puntjes-java/issues/3)) ([501b2f3](https://github.com/PuntjesApp/puntjes-java/commit/501b2f3528d865d2f65ea0c9b81303a4d158b56e))

## 1.0.0 (2026-10-12)


### Features

* the Java SDK, generated from api.json and released on JitPack ([#1](https://github.com/PuntjesApp/puntjes-java/issues/1)) ([a5a4af5](https://github.com/PuntjesApp/puntjes-java/commit/a5a4af584e403d318c3ecd08b86d8c6520ef5932))
