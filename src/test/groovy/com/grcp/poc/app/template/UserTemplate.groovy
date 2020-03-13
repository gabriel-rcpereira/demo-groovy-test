package com.grcp.poc.app.template

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader
import com.grcp.poc.groovy.app.core.domain.User

class UserTemplate implements TemplateLoader {

    def static final USER_COMPLETE_VALID = "user valid"
    def static final USER_VALID = "user valid"

    def final ID_KEY = "id"
    def final NAME_KEY = "name"
    def final PASSWORD_KEY = "password"

    def final NAME_VALUE = "Thor"
    def final PASSWORD_VALUE = Base64.getEncoder().encodeToString("Ragnarok_S2".getBytes())

    @Override
    void load() {
        Fixture.of(User.class)
            .addTemplate(USER_COMPLETE_VALID, new Rule(){{
                add(ID_KEY, 1L)
                add(NAME_KEY, NAME_VALUE)
                add(PASSWORD_KEY, PASSWORD_VALUE)
            }})
            .addTemplate(USER_VALID, new Rule(){{
                add(NAME_KEY, NAME_VALUE)
                add(PASSWORD_KEY, PASSWORD_VALUE)
            }})
    }
}
