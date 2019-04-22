package contracts

import org.springframework.cloud.contract.spec.Contract
[

        Contract.make {
          request {
            method 'POST'
            url '/book'
            body([
                    name: '这东西真的好烦',
                    price: 100
            ])
            bodyMatchers {
              jsonPath('$.name', byRegex(nonEmpty()))
              jsonPath('$.price', byRegex(number()))
            }
          }
          response {
            status OK()
            body([
                    "name": fromRequest().body('$.name'),
                    "price": fromRequest().body('$.price')
            ])
            headers {
              contentType(applicationJsonUtf8())
            }
          }
        },

        Contract.make {
          request {
            method 'POST'
            url '/book'
            body([
                    name: value(anyNonEmptyString()),
                    price: value(anyNumber())
            ])
          }
          response {
            status OK()
            body([
                    "name": fromRequest().body('$.name'),
                    "price": fromRequest().body('$.price')
            ])
            headers {
              contentType(applicationJsonUtf8())
            }
          }
        }
]
