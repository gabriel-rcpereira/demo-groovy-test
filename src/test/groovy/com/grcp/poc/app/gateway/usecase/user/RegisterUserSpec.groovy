package com.grcp.poc.app.gateway.usecase.user

import br.com.six2six.fixturefactory.Fixture
import com.grcp.poc.app.BaseSpec
import com.grcp.poc.app.template.UserTemplate
import com.grcp.poc.groovy.app.core.domain.User
import com.grcp.poc.groovy.app.core.usecase.user.RegisterUser
import com.grcp.poc.groovy.app.gateway.UserGateway

class RegisterUserSpec extends BaseSpec {

    RegisterUser registerUser
    UserGateway userGateway

    def setup(){
        userGateway = Mock()
        registerUser = new RegisterUser(userGateway)
    }

    def "register an user should return the user object filled"(){
        given:
        def userToRegister = Fixture.from(User.class).gimme(UserTemplate.USER_VALID)
        userGateway.register(userToRegister) >> Fixture.from(User.class).gimme(UserTemplate.USER_COMPLETE_VALID)

        when:
        def userRegistered = registerUser.execute(userToRegister)

        then:
        Optional.ofNullable(userRegistered).isPresent()
    }

}
