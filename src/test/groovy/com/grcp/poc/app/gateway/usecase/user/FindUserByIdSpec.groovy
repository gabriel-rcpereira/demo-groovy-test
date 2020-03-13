package com.grcp.poc.app.gateway.usecase.user

import br.com.six2six.fixturefactory.Fixture
import com.grcp.poc.app.BaseSpec
import com.grcp.poc.app.template.UserTemplate
import com.grcp.poc.groovy.app.core.domain.User
import com.grcp.poc.groovy.app.core.usecase.exception.EntityNotFoundException
import com.grcp.poc.groovy.app.core.usecase.user.FindUserById
import com.grcp.poc.groovy.app.gateway.UserGateway

import spock.lang.Ignore

class FindUserByIdSpec extends BaseSpec {

    UserGateway gateway
    FindUserById findUserById

    def setup(){
        gateway = Mock()
        findUserById = new FindUserById(gateway)
    }

    @Ignore
    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }

    def "find user by id should return one user"() {
        given:
        User userValid = Fixture.from(User.class).gimme(UserTemplate.USER_COMPLETE_VALID)
        def userId = 1L
        gateway.findById(userId) >> userValid

        when:
        def userExpected = findUserById.execute(userId)

        then:
        Optional.ofNullable(userExpected).isPresent()
    }

    def "find user by id when the user does not exist should throw an exception"(){
        given:
        def userId = 1L
        gateway.findById(userId) >> {
            throw new EntityNotFoundException(User.class, "User not found.")
        }

        when:
        findUserById.execute(userId)

        then:
        thrown(EntityNotFoundException)
    }
}
