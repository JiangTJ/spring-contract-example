package contracts

import org.springframework.cloud.contract.spec.Contract

/**
 * Created by jiang (jiang.taojie@foxmail.com) 
 * 2019/4/28 21:46 End.
 */
Contract.make {
    priority(1)
    name('第一个契约呀')
    description("""
        [运营]需要[去掉操作A]，目的是[减少流程与人工成本]，存在的问题[减少A操作，会使部分数据未记录（运营人员已知晓（见邮件‘邮件主题’））]
    """)
    request {
        method 'PUT'
        urlPath($(c(regex('^/user/.+')),p('/user/1'))) {
            queryParameters {
                parameter 'limit': 100
                parameter 'filter': equalTo("email")
                parameter 'gender': value(consumer(containing("[mf]")), producer('mf'))
                parameter 'offset': value(consumer(matching("[0-9]+")), producer(123))
                parameter 'loginStartsWith': value(consumer(notMatching(".{0,2}")), producer(3))
                parameter 'uuid': $(anyUuid())
            }
        }
        headers {
            contentType(applicationJson())
        }
        body([
                name: value(anyNonEmptyString(), producer("从入门到弃坑")),
                price: value(anyNumber(), producer("1"))
        ])
    }
    response {
        status OK()
        body([
                "gender": fromRequest().query('gender'),
                "offset": fromRequest().query('offset')
        ])
        headers {
            contentType(applicationJsonUtf8())
        }
    }
}