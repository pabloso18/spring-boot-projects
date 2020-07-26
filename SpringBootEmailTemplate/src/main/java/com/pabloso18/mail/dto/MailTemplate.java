package com.pabloso18.mail.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * This class it's the template with the information that the service need to send an email
 * @author Jose_Solano
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MailTemplate {

    @NotBlank
    private String from;
    @NotBlank
    private String mailTo;
    @NotBlank
    private String subject;

    private List<Object> attachments;

    /**
     * This Map it will be use it for the values of the email template
     */
    private Map<String, Object> props;

}
