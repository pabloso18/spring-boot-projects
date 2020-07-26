package com.pabloso18.mail.service;

import com.pabloso18.mail.dto.MailTemplate;
import com.pabloso18.mail.type.EmailTemplate;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Email Service Interface
 * @author Jose_Solano
 */
public interface EmailService {

    /**
     * This method it's to send the email to the destination
     * @param mail
     * @param emailTemplate
     * @throws IOException
     * @throws MessagingException
     */
    void sendEmail(MailTemplate mail, EmailTemplate emailTemplate) throws IOException, MessagingException;

}
