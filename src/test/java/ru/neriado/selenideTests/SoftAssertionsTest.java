package ru.neriado.selenideTests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;


public class SoftAssertionsTest extends TestBase{


    @Test
    void softAssertionTest() {

        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-box").$(".js-wiki-sidebar-toggle-display")
                .$$("ul li").last().$("[type=button]").click();
        $("#wiki-pages-box").$("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $("#wiki-wrapper").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));


    }
}
