# Spring Boot + Email template with Thymeleaf

Now creating an email service with the ability to send different kinds of email can be pretty easy. This example can help you to how to send a personalized email, create an email sender and you can send company emails. This example uses the Gmail SMTP but you can change the properties.

This repository it's for Spring Boot + Email template with Thymeleaf.
I also add lombok project for the DTO.

You can send the request with this URL:

`http://localhost:8084/email/v1/send-email`

With the next JSON

```json
{
	"from": "mailFrom@gmail.com",
	"mailTo": "mailTo@gmail.com",
	"subject": "subject title",
	"props": {
			  "name" : "Jose",
			  "location" : "Costa Rica",
			  "sign" : "pabloso18"
			}
}
```

You will receive an 200 OK Response

### Other information

If you want to try with your personal Gmail account you need to do some steps:
1. Login to the gmail account you are sending mail from
2. Go to Manage your Google Account -> Security -> Less secure app access -> Turn on access (not recommended)
3. Turn "Allow less secure apps: OFF" to "Allow less secure apps: ON"
4. Then, after you test the project I recommend to set OFF again this property on your Google account.
