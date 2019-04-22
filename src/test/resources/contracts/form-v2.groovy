package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'PUT'
        url '/book-v2'
        headers {
            contentType(applicationFormUrlencoded())
        }
        body([
                name: value(consumer(regex(nonEmpty())), producer("从入门到弃坑")),
                price: value(consumer(regex(number())), producer("1"))
        ])
    }
    response {
        status OK()
        body([
                "name": fromRequest().query('name'),
                "price": fromRequest().query('price')
        ])
        headers {
            contentType(applicationJsonUtf8())
        }
    }
}