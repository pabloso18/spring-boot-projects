package com.pabloso18.mail.type;

/**
 * This enum it's to manage the different email template
 * @author Jose_Solano
 */
public enum EmailTemplate {

    EXAMPLE_EMAIL_TEMPLATE("example-email-template")
    ;

    private String urlEmailTemplate;

    EmailTemplate(String urlEmailTemplate){
        this.urlEmailTemplate = urlEmailTemplate;
    }

    public String getUrlEmailTemplate() {
        return urlEmailTemplate;
    }
}
