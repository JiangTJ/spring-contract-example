package contracts

import org.springframework.cloud.contract.spec.Contract

/**
 * Created by jiang (jiang.taojie@foxmail.com) 
 * 2019/4/28 21:46 End.
 */
Contract.make {
    priority(1)
    request {
        method 'PUT'
        urlPath($(c(regex('^/user/.+')),p('/user/1')))
        headers {
            contentType(applicationJson())
        }
        body(file('index.json'))
        bodyMatchers {
            jsonPath('$.name', byRegex(nonBlank()))
        }
    }
    response {
        status OK()
    }
}