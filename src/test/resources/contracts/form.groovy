package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'PUT'
        url '/book'
        headers {
            contentType(applicationFormUrlencoded())
        }
        body([
                name: "www",
                price: 111
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